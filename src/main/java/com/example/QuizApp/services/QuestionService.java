package com.example.QuizApp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.QuizApp.models.Question;
import com.example.QuizApp.repositories.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository questionRepository;
	
	public ResponseEntity<List<Question>>getAllQuestions(){
		try {
			return new ResponseEntity(questionRepository.findAll(),HttpStatus.OK);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<List<Question>> getQuestionsByCategory(String category){
		try {
			return new ResponseEntity<>(questionRepository.findByCategory(category),HttpStatus.OK); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<Question> addQuestion(Question question) {
		try {
			return new ResponseEntity<>(questionRepository.save(question),HttpStatus.CREATED); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<String> deleteQuestion(int id) {
		try {
			questionRepository.deleteById(id);
			return new ResponseEntity<>("Deleted",HttpStatus.OK); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	public ResponseEntity<Question> updateQuestion(Question question) {
		try {
			Question existingQuestion = questionRepository.findById(question.getId()).orElse(null);
			existingQuestion.setCategory(question.getCategory());
			existingQuestion.setDifficultyLevel(question.getCategory());
			existingQuestion.setOption1(question.getOption1());
			existingQuestion.setOption2(question.getOption2());
			existingQuestion.setOption3(question.getOption3());
			existingQuestion.setOption4(question.getOption4());
			existingQuestion.setQuestionTitle(question.getQuestionTitle());
			existingQuestion.setRightAnswer(question.getRightAnswer());
			questionRepository.save(existingQuestion);
			return new ResponseEntity<>(existingQuestion,HttpStatus.OK); 
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
}
