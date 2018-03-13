package com.example.web;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.business.IIntranetBusiness;

@Controller
public class IntranetController {
	private String userType = "";
	private String email = "";
	
	@Autowired 
	private IIntranetBusiness iib;
	
	@RequestMapping(value = {"/Home", "/"})
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println("COOKIE VALUE ==> " + cookie.getValue());
				if (cookie.getName().equals("email")) { 
					cookie.setValue(email);
					response.addCookie(cookie);
				}
				else if (cookie.getName().equals("userType")) {
					cookie.setValue(userType);
					response.addCookie(cookie);
				}
			}
		}
		model.addAttribute("a_userType", userType);
		System.out.println("VALUE USER ==> " + userType);
		System.out.println("VALUE MAIL ==> " + email);
		return "index";
	}

	@PostMapping(value = "/loginProcess")
	public String loginProcess(HttpServletRequest request, HttpServletResponse response, Model model) {
		Pair<String, String> result = iib.loginProcess(request, response);
		
		String error = result.getFirst();
		userType = result.getSecond();
		
		model.addAttribute("a_userType", userType);
		if (error == "") {
			email = request.getParameter("email");
			switch(userType) {
			case "admin":
//				return "index";
				return "redirect:/GestionNews";
			case "teacher":
				return "redirect:/GestionNotes";
			case "student":
				return "redirect:/MesNotes";
			}
		}
		model.addAttribute("a_erro", error);
		return "redirect:/Home";
	}
	
	@PostMapping(value="/logoutProcess")
	public String logoutProcess(HttpServletRequest request, HttpServletResponse response, Model model) {
	
		if (request.getParameter("answer").equals("yes")) {
			Cookie[] cookies = request.getCookies();
			if (cookies == null) {
				throw new RuntimeException("Cookies not found");
			}
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("email") || cookie.getName().equals("userType")) {
				cookie.setValue("");
				response.addCookie(cookie);
				userType = "";
				email = "";
				}
			}
		}
		model.addAttribute("a_userType", userType);
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
