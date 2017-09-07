package com.youfchen.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="QUESTION_ITEM")
public class QuestionEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@Column(name="QUESTION",columnDefinition="CLOB NOT NULL")
	@Lob
	private String question;
	
	@OneToMany(mappedBy="questionEntity",cascade=CascadeType.ALL)
	private List<AnswerEntity> answers;
	
	@Column(name="CATEGORY",length=32)
	private String category;
	
	@Column(name="KNOWLEDGE_POINT",length=256)
	private String knowledgePoint;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}


	public List<AnswerEntity> getAnswers() {
		return answers;
	}

	public void setAnswers(List<AnswerEntity> answers) {
		this.answers = answers;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getKnowledgePoint() {
		return knowledgePoint;
	}

	public void setKnowledgePoint(String knowledgePoint) {
		this.knowledgePoint = knowledgePoint;
	}
	
	

}
