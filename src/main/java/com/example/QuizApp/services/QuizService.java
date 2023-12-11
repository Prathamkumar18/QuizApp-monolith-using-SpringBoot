package com.example.QuizApp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.QuizApp.models.Question;
import com.example.QuizApp.models.QuestionWrapper;
import com.example.QuizApp.models.Quiz;
import com.example.QuizApp.models.Response;
import com.example.QuizApp.repositories.QuestionRepository;
import com.example.QuizApp.repositories.QuizRepository;

@Service
public class QuizService {
	@Autowired
	private QuizRepository quizRepository;
	@Autowired
	private QuestionRepository questionRepository;

	public ResponseEntity<String> createQuiz(int noQ, String category, String title) {
		try {
			Quiz quiz=new Quiz();
			quiz.setTitle(title);
			List<Question> questions=questionRepository.getQuestionsByCategory(noQ, category);
			quiz.setQuestions(questions);
			quizRepository.save(quiz);
			return new ResponseEntity<>("quiz created",HttpStatus.CREATED);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new String("Failed to create"),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestions(int quizId) {
		try {
			Quiz quiz=quizRepository.findById(quizId).orElse(null);
			List<Question> questions=quiz.getQuestions();
			List<QuestionWrapper> questionForUser= new ArrayList<>(); 
			for(Question q:questions) {
				QuestionWrapper qWrapper=new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
				questionForUser.add(qWrapper);
			}
			return new ResponseEntity<>(questionForUser,HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculateResult(int quizId, List<Response> responses) {
		try {
			Quiz quiz=quizRepository.findById(quizId).orElse(null);
			List<Question> questions=quiz.getQuestions();
			int correct=0;
			int i=0;
			for(Response response:responses) {
				if(response.getRightAnswer().equals(questions.get(i).getRightAnswer())) {
					correct++;
				}
				i++;
			}
			return new ResponseEntity<>(correct,HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(-1,HttpStatus.OK);
	}
	
}
