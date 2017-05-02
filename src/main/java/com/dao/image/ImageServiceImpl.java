package com.dao.image;

import java.util.List;

import com.model.Image;

public class ImageServiceImpl implements ImageService {

	ImageDAOImpl im = new ImageDAOImpl();
	
	public List<Image> getGallery() {
		List<Image> ima = im.getGallery();
		return ima;
	}

	public void addImage(Image ima) {
		im.addImage(ima);
		
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
