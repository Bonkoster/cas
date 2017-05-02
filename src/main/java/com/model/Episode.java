package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "episodes_table")
public class Episode {
	
	@Id
	@GeneratedValue
	@Column(name = "episode_id")
	private int id;
	
	@Column(name = "episode_title")
	@NotNull
	@Size(min = 5, max = 30)
	private String title;
	
	@Column(name = "episode_link")
	@NotNull
	private String link;
	
	@Column(name = "episode_desc")
	@NotNull
	@Size(min = 5, max = 300)
	private String desc;
	
	@Column(name = "upload_data")
	private Date date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public Episode(String title, String link,String desc, Date date) {
		this.title = title;
		this.link = link;
		this.desc = desc;
		this.date = date;
	}
	
	public Episode() {
		this.date = new Date();
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	

}
