package com.example.web;

import java.util.Date;
import java.util.List;
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
import com.example.entities.News;
import com.example.entities.Section;

@Controller
public class IntranetController {
	private final String admin = "admin";
	private final String teacher = "teacher";
	private final String student = "student";
	
	private String userType = "";
	private String email = "";
	
	private String login_error = "";
	
	@Autowired 
	private IIntranetBusiness iib;
	
	@RequestMapping(value = {"/Home", "/"})
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		// Set cookie for email
		Cookie cookieMail = new Cookie("email", email);
		cookieMail.setMaxAge(60 * 60 * 24);
		cookieMail.setPath("/");
		cookieMail.setSecure(false);
		response.addCookie(cookieMail);
		
		// Set cookie for userType
		Cookie cookieType = new Cookie("userType", userType);
		cookieType.setMaxAge(60 * 60 * 24);
		cookieType.setPath("/");
		cookieType.setSecure(false);
		response.addCookie(cookieType);
		
		// forward usertype for view (that display only a part of the navBar)
		model.addAttribute("a_userType", userType);
		
		// forward list of news to the view
		List<News> l_news = iib.getAllNews();
		model.addAttribute("a_news", l_news);

		model.addAttribute("a_error", login_error);
		return "index";
	}

	@PostMapping(value = "/loginProcess")
	public String loginProcess(HttpServletRequest request, HttpServletResponse response, Model model) {
		Pair<String, String> result = iib.loginProcess(request, response);
		
		login_error = result.getFirst();
		
		if (login_error.equals("")) {
			userType = result.getSecond();
			model.addAttribute("a_userType", userType);
			email = request.getParameter("email");
			
			switch(userType) {
			case admin:
				return "redirect:/GestionNews";
			case teacher:
				return "redirect:/GestionNotes";
			case student:
				return "redirect:/MesNotes";
			}
		}
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
		List<News> l_news = iib.getAllNews();
		model.addAttribute("a_news", l_news);
		return "news";
	}
	
	@RequestMapping("/GestionNews")
	public String manageNews(HttpServletRequest request, Model model) {
		model.addAttribute("a_userType", userType);
		if (!userType.equals(admin))
			return "index";
		
		List<News> l_news = iib.getAllNews();
		model.addAttribute("a_news", l_news);
		return "manageNews";
	}
	
	@RequestMapping("/GestionComptes")
	public String manageUsers(HttpServletRequest request, Model model) {		
		model.addAttribute("a_userType", userType);
		if (!userType.equals(admin))
			return "index";
		
		List<Section> l_sections = iib.getAllSections();
		model.addAttribute("a_sections", l_sections);
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
			model.addAttribute("a_userType", userType);
			return "manageUsers";
		}
	}
}
