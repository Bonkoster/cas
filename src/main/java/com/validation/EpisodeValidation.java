package com.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.model.Episode;

public class EpisodeValidation implements Validator {

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Episode.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		String url = "https://www.youtube.com/embed/";
		
		Episode eps = (Episode) target;
		
		if (!eps.getLink().contains(url)) {
			errors.rejectValue("link", "The link must be from youtube and be embeded");
		}
		
	}

}
