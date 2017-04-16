package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "episodes_table")
public class Episode {
	
	@Id
	@GeneratedValue
	@Column(name = "episode_id")
	private int Id;
	
	@Column(name = "episode_title")
	private String title;
	
	@Column(name = "episode_link")
	private String link;
	
	@Column(name = "upload_data")
	private Date date;
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Episode(String title, String link, Date date) {
		this.title = title;
		this.link = link;
		this.date = date;
	}
	
	public Episode() {
		
	}
	
	

}
