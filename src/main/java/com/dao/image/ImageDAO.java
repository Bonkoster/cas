package com.dao.image;

import java.util.List;

import com.model.Image;

public interface ImageDAO {

	public List<Image> getGallery();
	
	public void addImage(Image image);
	
	public void deleteimage(int id);
	
	public Image getImage(int id);
	
	public long getCount();
}
