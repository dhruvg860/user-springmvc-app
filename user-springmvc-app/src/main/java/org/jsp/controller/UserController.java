package org.jsp.controller;

import org.jsp.dao.UserDao;
import org.jsp.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	private UserDao dao;

	@PostMapping("/save")
	public ModelAndView saveUser(ModelAndView view, @ModelAttribute User user) {
		view.setViewName("print.jsp");
		user = dao.saveUser(user);
		view.addObject("msg", "User saved with ID:" + user.getId());
		return view;
	}
}
