package com.dao.image;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.model.Image;

public interface ImageService {

	public List<Image> getGallery(int page);
	
	public void addImage(Image file);
	
	public void deleteImage(int id);
	
	public Image getImage(int id);
	
	public long getCount();
}
