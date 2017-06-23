package com.bascon;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.dao.comment.CommentService;
import com.dao.comment.CommentServiceImpl;
import com.dao.episode.EpisodeServiceImpl;
import com.dao.image.ImageServiceImpl;
import com.model.Comment;
import com.model.Episode;
import com.model.Image;
import com.validation.EpisodeValidation;

@Controller
public class HelloController {

	@Autowired
	ServletContext context;
	
	private static final Logger logger = Logger.getLogger(HelloController.class);
	
	//Три сервиса для работы с базой данных
	CommentServiceImpl commentService = new CommentServiceImpl();
	EpisodeServiceImpl episodeService = new EpisodeServiceImpl();
	ImageServiceImpl imageService = new ImageServiceImpl();
		
	//Приветственная страница
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView Welcome(){
		ModelAndView md = new ModelAndView("Hello");
		
		String rick = "https://www.youtube.com/embed/AqT-MJnbePM";		
		String title = "Добро пожаловать на мой сайт о Madness Combat";
		md.addObject("title", title);
		md.addObject("rick",rick);
		
		return md;
	}
	
	//Игра в Project Nexus
	@RequestMapping(value = "/playNexus", method = RequestMethod.GET)
	public ModelAndView PlayNexus(){
		ModelAndView md = new ModelAndView("Nexus");
		
		Comment come = new Comment();
		
		String title = "Здесь вы можеть сыграть в Madness Project Nexus";
		String link = "http://www.newgrounds.com/portal/view/592473";
		
		md.addObject("title", title);
		md.addObject("link",link);
		
		return md;
	}
	
	//Форма с добавлением эпизодов
	@RequestMapping(value = "/addEpisode", method = RequestMethod.GET)
	public ModelAndView AddEpisode(){
		ModelAndView md = new ModelAndView("AddEpisode");
		String title = "Добавить новый эпизод";
		String but = "Загрузить";
		
		
		String titlePlac = "Напишите название файла здесь";
		String linkPlac = "Ссылка должна содержать https://www.youtube.com/embed/";
		String descPlac = "Введите описание здесь";
		
		Episode episode = new Episode();
		
		md.addObject("episode",episode);
		md.addObject("title",title);
		md.addObject("titlePlac", titlePlac);
		md.addObject("linkPlac", linkPlac);
		md.addObject("descPlac", descPlac);
		md.addObject("butto",but);
		
		return md;
	}
	
	//Метод POST, добавляющий эпизод
	@RequestMapping(value = "/addEpisodeAction", method = RequestMethod.POST)
	public String addEpisodeAction(@Validated @ModelAttribute("episode") Episode episode, BindingResult result ,ModelMap map) throws UnsupportedEncodingException{
		
		map.addAttribute("title", episode.getTitle());
		map.addAttribute("link",episode.getLink());
		map.addAttribute("desc",episode.getDesc());
		
		/*epsiodeValidator.validate(episode, result);
		if(result.hasErrors()){
			return "redirect:/addEpisode";
		} else {}*/
			
			String mel = new String(episode.getTitle().getBytes("ISO-8859-1"), "UTF-8");
			String mec = new String(episode.getLink().getBytes("ISO-8859-1"), "UTF-8");
			String mev = new String(episode.getDesc().getBytes("ISO-8859-1"), "UTF-8");
			
			episode.setTitle(mel);
			episode.setLink(mec);
			episode.setDesc(mev);
			
		episodeService.addEpisode(episode);
		
		return "redirect:/getSeries/1";
		
	}
	
	//Список эпизодов
	@RequestMapping(value = "/getSeries/{id}")
	public ModelAndView GetSeries(@PathVariable int id){
		ModelAndView md = new ModelAndView("AllEpisodes");
		String title = "Вы можеть смотреть сериал Madness Combat здесь";
		
		long count = episodeService.getCount();
		
		long pages = count / 10 + 1;
		
		List<Episode> eps = episodeService.listEpisode(id);
		
		md.addObject("pages",pages);
		md.addObject("episodes",eps);
		md.addObject("title",title);
		
		return md;
	}
	
	//Просмотр эпизодов
	@RequestMapping(path = "/watchEpisode/{id}")
	public ModelAndView watchEpisode(@PathVariable int id){
		ModelAndView md = new ModelAndView("WatchEpisode");
		
		Episode eps = episodeService.getEpisode(id);
		String title = eps.getTitle();
		
		md.addObject("title",title);
		md.addObject("episode",eps);
		
		return md;
	}
	
	//Метод POST добавления комметариев
	@RequestMapping(value = "/addComment", method = RequestMethod.POST)
	public String addComment(@Validated @ModelAttribute("comment") Comment comment, BindingResult result, ModelMap model ) throws UnsupportedEncodingException{
		
		model.addAttribute("author", comment.getAuthor());
		model.addAttribute("content", comment.getContent());
		
		String mel = new String(comment.getAuthor().getBytes("ISO-8859-1"), "UTF-8");
		String mec = new String(comment.getContent().getBytes("ISO-8859-1"), "UTF-8");
		comment.setAuthor(mel); 
		comment.setContent(mec);
		
		commentService.addComment(comment);
		
		return "redirect:/comments/1";
	}
	
	//Список комметариев
	@RequestMapping(value = "/comments/{id}")
	public ModelAndView Commentaries(@PathVariable int id){
		ModelAndView md = new ModelAndView("Comments");
		String title = "Оставьте отзыв";		
		String post = "Отправить";
		
		long count = commentService.getCount();
		long pages = count / 5 + 1;
						
		List<Comment> coms = commentService.listComments(id);
				
		Comment comment = new Comment();		
		
		md.addObject("comment", comment);		
		md.addObject("comments",coms);
		md.addObject("title",title);
		md.addObject("Post",post);
		md.addObject("pages", pages);		
		
		return md;
	}
	
	//Доступ к галерее (В разработке)
	@RequestMapping(value = "/galery/{id}")
	public ModelAndView Gallery(@PathVariable int id){
		ModelAndView md = new ModelAndView("Gallery");
		
		Image image = new Image();
		
		long count = commentService.getCount();
		long pages = count / 20 + 1;
		
		List<Image> images = new ArrayList<Image>();
		
		images = imageService.getGallery(id);
		
		String hint = "Для увеличения щелкните по картинке";
		String title2 = "Посмотрите галерею";
		String butto = "Загрузить картинку";
	
		
		md.addObject("butto", butto);
		md.addObject("title2",title2);
		md.addObject("image",image);
		md.addObject("images",images);
		md.addObject("pages",pages);
		md.addObject("hint",hint);
		
		return md;
	}
	
	//Добавление изображений (В разработке)
	@RequestMapping(value = "/addImage", method = RequestMethod.POST)
	public String addImage(@Validated @ModelAttribute("image") Image image, ModelMap map, BindingResult result ) throws IOException{
		
		map.addAttribute("title", image.getTitle());
		map.addAttribute("file", image.getFile());
		
		String mel = new String(image.getTitle().getBytes("ISO-8859-1"), "UTF-8");
		
		image.setTitle(mel);
		
		imageService.addImage(image);
		return "redirect:/galery/1";
	}
}

