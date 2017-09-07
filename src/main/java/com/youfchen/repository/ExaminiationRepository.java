package com.youfchen.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.youfchen.entity.QuestionEntity;

public interface ExaminiationRepository extends JpaRepository<QuestionEntity, Long> {
	
	@SuppressWarnings("unchecked")
	QuestionEntity save(QuestionEntity examinationEntity);
	
	Page<QuestionEntity> findByCategory(String category,Pageable pageable);
	
	Page<QuestionEntity> findByKnowledgePoint(String knowledgePoint,Pageable pageable);
	
	List<QuestionEntity> findAll();

}
