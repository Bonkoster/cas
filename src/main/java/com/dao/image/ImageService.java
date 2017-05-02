package com.dao.image;

import java.util.List;

import com.model.Image;

public interface ImageService {

	public List<Image> getGallery();
	
	public void addImage(Image ima);
	
	public void deleteImage(int id);
	
	public Image getImage(int id);
	
	public long getCount();
}
