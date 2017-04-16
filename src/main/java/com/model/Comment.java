package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "comments_table")
public class Comment {
	
	@Id
	@GeneratedValue
	@Column(name = "comment_id")
	private int id;
	
	@Column(name = "comment_author")
	@NotNull(message = "Fill the author field")
	@Size(min = 3,max = 30)
	private String author;
	
	@Column(name = "comment_content")
	@NotNull(message = "Fill the content field")
	@Size(min = 2,max = 600)
	private String content;
	
	@Column(name = "comment_data")
	private Date date;	
	
	public Comment(){	
		this.date = new Date();
	}
	
	public Comment(int id,String author,String content,Date date){
		this.id = id;
		this.author = author;
		this.content = content;
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
