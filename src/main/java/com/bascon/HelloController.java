package com.bascon;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dao.comment.CommentService;
import com.dao.comment.CommentServiceImpl;
import com.model.Comment;

@Controller
public class HelloController {

	@Autowired
	ServletContext context;
	
	
	CommentServiceImpl commentService = new CommentServiceImpl();
		
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public ModelAndView Welcome(){
		ModelAndView md = new ModelAndView("Hello");
		
		String rick = "https://www.youtube.com/embed/39WSv4SMJHQ";		
		
		String title = "Welcome to my Special site About Madness Combat";
		md.addObject("title", title);
		md.addObject("rick",rick);
		
		return md;
	}
	
	@RequestMapping(value = "/getSeries")
	public ModelAndView GetSeries(){
		ModelAndView md = new ModelAndView("AddBook");
		String title = "Get Episodes of Madness Combat here";
		
		md.addObject("title",title);
		
		return md;
	}
	
	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	public String addComment(@Validated @ModelAttribute("comment") Comment comment, BindingResult result, ModelMap model ){
		
		model.addAttribute("author", comment.getAuthor());
		model.addAttribute("content", comment.getContent());
		
		commentService.addComment(comment);
		
		return "redirect:/comments";
	}
	
	@RequestMapping(value = "/comments")
	public ModelAndView Commentaries(){
		ModelAndView md = new ModelAndView("Comments");
		String title = "You can post your comment Here";		
		
		List<Comment> coms = commentService.listComments();
		
		Comment comment = new Comment();
		
		md.addObject("comment", comment);
		
		md.addObject("comments",coms);
		
		md.addObject("title",title);
		
		return md;
	}
	
}

