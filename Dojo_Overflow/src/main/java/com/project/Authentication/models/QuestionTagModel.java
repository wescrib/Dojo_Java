package com.project.Authentication.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="question_tag")
public class QuestionTagModel{
    public QuestionTagModel(QuestionModel question, TagModel tag){ //WHAT IS HAPPENING HERE?
        this.question=question;
        this.tag = tag;
    }

	@Id
	@GeneratedValue
	private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id")
    private QuestionModel question;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tag_id")
    private TagModel tag;
	
}