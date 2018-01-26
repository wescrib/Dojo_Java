package com.project.Authentication.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class QuestionModel{
	@Id
	@GeneratedValue
	private long id;

	// Member variables and annotations go here.

	@OneToMany(mappedBy="question", fetch = FetchType.LAZY)
	private List<AnswerModel> answers;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
		name="question_tag",
		joinColumns=@JoinColumn(name="question_id"),
		inverseJoinColumns=@JoinColumn(name="tag_id")
	)
	private List<TagModel> tags;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private UserModel user;

	@Size(min=1, max=3000, message = "Must be at least one character")
	private String question;
	

	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date createdAt;
	
	@DateTimeFormat(pattern="MM:dd:yyyy HH:mm:ss")
	private Date updatedAt;

	@PrePersist
	public void onCreate(){this.createdAt = new Date();}
	@PreUpdate
	public void onUpdate(){this.updatedAt = new Date();}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setQuestion(String question){
		this.question = question;
	}

	public String getQuestion(){
		return question;
	}

	public List<AnswerModel> getAnswer(){
		return answers;
	}

	public List<TagModel> getTag(){
		return tags;
	}

	public void setAnswer(List<AnswerModel>answers){
		this.answers=answers;
	}

	public void setTag(List<TagModel> tag){
		this.tags = tag;
	}

	
	public QuestionModel(){
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}
}
