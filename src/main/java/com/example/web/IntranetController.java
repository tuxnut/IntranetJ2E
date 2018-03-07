package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.business.IIntranetBusiness;

@Controller
public class IntranetController {
	@Autowired 
	private IIntranetBusiness iib;
	
	@RequestMapping("/index")
	public String index(Model model) {
		String message = "Welcome User";
		model.addAttribute("a_message", message);
		return "index";
	}
}
