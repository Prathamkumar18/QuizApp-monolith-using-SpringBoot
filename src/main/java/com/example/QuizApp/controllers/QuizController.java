package com.example.QuizApp.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.QuizApp.models.QuestionWrapper;
import com.example.QuizApp.models.Response;
import com.example.QuizApp.services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {
	@Autowired
	private QuizService quizService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createQuiz(@RequestParam int noQ,@RequestParam String category, @RequestParam String title){
		return quizService.createQuiz(noQ, category, title);
	}
	
	@GetMapping("/get/{quizId}")
	public ResponseEntity<List<QuestionWrapper>> getQuestion(@PathVariable int quizId){
		return quizService.getQuestions(quizId);
	}
	
	@PostMapping("/submit/{quizId}")
	public ResponseEntity<Integer> calculateResult(@PathVariable int quizId,@RequestBody List<Response> responses){
		return quizService.calculateResult(quizId,responses);
	}
}
