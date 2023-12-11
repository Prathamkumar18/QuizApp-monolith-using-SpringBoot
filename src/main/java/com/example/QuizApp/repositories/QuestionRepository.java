package com.example.QuizApp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.QuizApp.models.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer>{
	public List<Question> findByCategory(String category);
	
	@Query(value = "select * from question q where q.category=:category limit :noQ",nativeQuery = true)
	public List<Question> getQuestionsByCategory(int noQ, String category);
}
