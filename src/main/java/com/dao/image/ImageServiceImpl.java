package com.dao.image;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.model.Image;

public class ImageServiceImpl implements ImageService {

	ImageDAOImpl im = new ImageDAOImpl();
	
	public List<Image> getGallery() {
		List<Image> ima = im.getGallery();
		return ima;
	}

	public void addImage(Image file) {
		im.addImage(file);
		
	}

	public void deleteImage(int id) {
		im.deleteimage(id);
		
	}

	public Image getImage(int id) {
		Image ima = im.getImage(id); 
		return ima;
	}

	public long getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

}
