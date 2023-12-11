package com.example.QuizApp.models;

public class Response {
	private Integer id;
	private String rightAnswer;
	public Response(Integer id, String rightAnswer) {
		super();
		this.id = id;
		this.rightAnswer = rightAnswer;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRightAnswer() {
		return rightAnswer;
	}
	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
	
}
