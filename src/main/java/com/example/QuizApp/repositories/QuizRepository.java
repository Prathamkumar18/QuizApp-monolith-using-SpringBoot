package com.example.QuizApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.QuizApp.models.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer>{
	
}
