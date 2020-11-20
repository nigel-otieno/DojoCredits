package com.codingdojo.Lookify.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.Lookify.models.Look;
import com.codingdojo.Lookify.services.LookService;

@Controller
public class LookifyController {
	private final LookService lookService;
	
	public LookifyController(LookService lookService) {
		this.lookService = lookService;
	}
	@RequestMapping("/")
	public String index() {
		return "/lookify/index.jsp";
	}
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Look> looks = lookService.allLooks();
	    model.addAttribute("looks", looks);
//	    model.addAttribute("look", new Look());
		return "/lookify/dashboard.jsp";
	}
	@PostMapping("/search")
	public String search(@RequestParam("artist") String artist, Model model) {
		return "redirect:/search/" + artist;
	}
	
	@GetMapping("/search/{artist}")
	public String searchArtist(@PathVariable("artist") String artist, Model model) {
		List<Look> artistSong = lookService.findByArtist(artist);
		model.addAttribute("artistSong", artistSong);
		return "/lookify/search.jsp";
	}
	@RequestMapping("/search/topTen")
	public String topTen(Model model) {
		List<Look> looks = lookService.allLooks();
	    model.addAttribute("looks", looks);
		return "/lookify/topTen.jsp";
	}
	@RequestMapping("/songs/{id}")
	public String songs(@PathVariable("id") Long id, Model model) {
		Look look = lookService.findLook(id);
        model.addAttribute("look", look);
		return "/lookify/songs.jsp";
	}
	@RequestMapping("/songs/new")
    public String addLook(@ModelAttribute("look") Look look, Model model) {
        return "/lookify/songNew.jsp";
    }
	@RequestMapping(value="/dashboard", method=RequestMethod.POST)
	public String newSong(@Valid @ModelAttribute("look") Look look, BindingResult result) {
		if(result.hasErrors()) {
			return "/lookify/songNew.jsp";
		}else {
			lookService.createLook(look);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping(value="/looks/{id}/destroy", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        lookService.deleteLook(id);
        return "redirect:/dashboard";
    }
//	public List<Look> topSongs() {
//	    // TODO Auto-generated method stub
//	    return lookRepository.findTop10ByOrderByRatingDesc(artist);
//	}
	
	
}

