package com.youfchen.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ANSWERS")
public class AnswerEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="CONTENT",length=128)
	private String content;
	
	@Column(name="IS_CORRECT_OPTION",length=1)
	private boolean correctOption;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="QUESTION_ENTITY_ID")
	private QuestionEntity questionEntity;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(boolean correctOption) {
		this.correctOption = correctOption;
	}

	public QuestionEntity getQuestionEntity() {
		return questionEntity;
	}

	public void setQuestionEntity(QuestionEntity questionEntity) {
		this.questionEntity = questionEntity;
	}
	
	

}
