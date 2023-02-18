package com.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.web.dto.ClubDto;
import com.web.services.ClubService;

@Controller
public class ClubController {
	
private ClubService clubService;

@Autowired
public ClubController(ClubService clubService) {
	this.clubService = clubService;
}

@GetMapping("/all-clubs")
public String listClubs(Model model) {
	List<ClubDto> clubs = clubService.findAllClubs();
	model.addAttribute("clubs", clubs);
	
	return "club-list";
}

}
