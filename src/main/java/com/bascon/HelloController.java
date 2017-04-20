package com.bascon;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dao.comment.CommentService;
import com.dao.comment.CommentServiceImpl;
import com.dao.episode.EpisodeServiceImpl;
import com.model.Comment;
import com.model.Episode;

@Controller
public class HelloController {

	@Autowired
	ServletContext context;
	
	
	CommentServiceImpl commentService = new CommentServiceImpl();
	EpisodeServiceImpl episodeService = new EpisodeServiceImpl();
		
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView Welcome(){
		ModelAndView md = new ModelAndView("Hello");
		
		String rick = "https://www.youtube.com/embed/39WSv4SMJHQ";		
		
		String title = "Welcome to my Special site About Madness Combat";
		md.addObject("title", title);
		md.addObject("rick",rick);
		
		return md;
	}
	
	@RequestMapping(value = "/addEpisode", method = RequestMethod.GET)
	public ModelAndView AddEpisode(){
		ModelAndView md = new ModelAndView("AddEpisode");
		String title = "Add new Episode here";
		
		Episode episode = new Episode();
		
		md.addObject("episode",episode);
		md.addObject("title",title);
		
		return md;
	}
	
	@RequestMapping(value = "/addEpisodeAction", method = RequestMethod.POST)
	public String addEpisodeAction(@Validated @ModelAttribute("episode") Episode episode, BindingResult result ,ModelMap map){
		
		map.addAttribute("title", episode.getTitle());
		map.addAttribute("link",episode.getLink());
		map.addAttribute("desc",episode.getDesc());
		
		episodeService.addEpisode(episode);
		
		return "redirect:/getSeries";
	}
	
	@RequestMapping(value = "/getSeries")
	public ModelAndView GetSeries(){
		ModelAndView md = new ModelAndView("AllEpisodes");
		String title = "You can watch Madness Combat episodes here";
		
		List<Episode> eps = episodeService.listEpisode();
		
		md.addObject("episodes",eps);
		md.addObject("title",title);
		
		return md;
	}
	
	@RequestMapping(path = "/watchEpisode/{id}")
	public ModelAndView watchEpisode(@PathVariable int id){
		ModelAndView md = new ModelAndView("WatchEpisode");
		
		Episode eps = episodeService.getEpisode(id);
		String title = eps.getTitle();
		
		md.addObject("title",title);
		md.addObject("episode",eps);
		
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

