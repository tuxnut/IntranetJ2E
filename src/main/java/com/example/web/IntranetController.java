package com.example.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.business.IIntranetBusiness;

@Controller
public class IntranetController {
	private String userType = "";
	
	@Autowired 
	private IIntranetBusiness iib;
	
	@RequestMapping(value = {"/Home", "/"})
	public String index(HttpServletRequest request, Model model) {
//		userType = (request.getAttribute("a_userType") != null) ? (String) request.getAttribute("a_userType") : "";
		model.addAttribute("a_userType", userType);
		return "index";
	}

	@PostMapping(value = "/loginProcess")
	public String loginProcess(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		String result = iib.loginProcess(request);
		
		// TODO : cookie
			
		if (result.equals("admin")) {
			userType = result;
			return "redirect:/GestionNews";
		} else if (result.equals("teacher")) {
			userType = result;
			return "redirect:/GestionNotes";
		} else if (result.equals("student")) {
			userType = result;
			return "redirect:/MesNotes";
		} else {
			model.addAttribute("a_error", result);
		}
		return "redirect:/Home";
	}
	
	@PostMapping(value="/logoutProcess")
	public String logoutProcess(HttpServletRequest request, Model model) {
		String answer = iib.logoutProcess(request);
		
		if (answer.equals("yes")) {
			// TODO : cookie
			userType = "";
			model.addAttribute("a_userType", userType);
		}
		// TODO : Redirect to current page ?
		return "redirect:/Home";
	}
	
	@RequestMapping("/News")
	public String news(HttpServletRequest request, Model model) {
		model.addAttribute("a_userType", userType);
		return "news";
	}
	
	@RequestMapping("/GestionNews")
	public String manageNews(HttpServletRequest request, Model model) {
		model.addAttribute("a_userType", userType);
		if (!userType.equals("admin"))
			return "index";
		
		return "manageNews";
	}
	
	@RequestMapping("/GestionComptes")
	public String manageUsers(HttpServletRequest request, Model model) {
		model.addAttribute("a_userType", userType);
		if (!userType.equals("admin"))
			return "index";
		
		return "manageUsers";
	}
	
	@PostMapping(value = "/addUser")
	public String addUser(HttpServletRequest request, Model model) {
		Map<String, String> m_errors = iib.addUser(request);
		
		if (!m_errors.isEmpty()) {
			model.addAttribute("a_errors", m_errors);
			return "forward:/GestionComptes";
		} else {
			model.addAttribute("a_success", "User created with success");
			return "manageUsers";
		}
	}
}
