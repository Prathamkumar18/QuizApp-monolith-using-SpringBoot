package com.example.QuizApp.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer quizId;
	private String title;
	@ManyToMany
	private List<Question> questions;
	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Quiz(Integer quizId, String title, List<Question> questions) {
		super();
		this.quizId = quizId;
		this.title = title;
		this.questions = questions;
	}
	public Integer getQuizId() {
		return quizId;
	}
	public void setQuizId(Integer quizId) {
		this.quizId = quizId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	@Override
	public String toString() {
		return "Quiz [quizId=" + quizId + ", title=" + title + ", questions=" + questions + "]";
	}
	 
}
