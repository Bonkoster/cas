package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "gallery_table")
public class Image {
	
	@Id
	@GeneratedValue
	@Column(name = "image_id")
	private int id;
	
	@NotNull
	@Column(name = "image_title")
	private String title;
	
	@NotNull
	@Column(name = "image_file")
	private byte[] file;
	
	@Column(name = "image_date")
	private Date date;	
	
	public Image() {
		
	}
	
	
	public Image(String title, Date date) {
		this.title = title;
		this.file = null;
		this.date = date;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public byte[] getFile() {
		return file;
	}
	
	public void setFile(byte[] file) {
		this.file = file;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getId() {
		return id;
	}	

}
