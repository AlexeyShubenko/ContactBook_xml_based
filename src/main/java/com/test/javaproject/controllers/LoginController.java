package com.test.javaproject.controllers;

import com.test.javaproject.dao.impl.WorkService;
import com.test.javaproject.domains.LoginTempObject;
import com.test.javaproject.dto.UserDto;
import com.test.javaproject.exceptions.UserNotFindException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@SessionAttributes(value="userDto")
public class LoginController {

	private WorkService service;

	@Autowired
	Environment env;

	@Autowired
	public LoginController(WorkService service){
		this.service = service;
	}

	///redirect to startPage, where you can log in
	///LoginTempObject - have data of log in user
	@RequestMapping(value = {"/","startPage"}, method = RequestMethod.GET)
	public ModelAndView startPageLog(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		if(!model.containsAttribute("loginObject")){
			model.addAttribute("loginObject", new LoginTempObject());
		}
		modelAndView.setViewName("startPage");
		return modelAndView;
	}

	///after logging in, entered data id checked
	///loginObject - come from jsp,model - object with data from jsp
	@RequestMapping(value="/checkLoginUser", method=RequestMethod.POST)
	public String checkLoginUser(@Valid @ModelAttribute("loginObject") LoginTempObject loginObject, BindingResult result,
								 RedirectAttributes attributes, HttpSession session){
		if(result.hasErrors()){
			attributes.addFlashAttribute("error", "errText.isExisting");
			return "redirect:/";
		}
        UserDto userDto;
		try{
		    userDto = service.getUserServiceImpl().getUserByLoginObject(loginObject);
        }catch (UserNotFindException ex){
            return "redirect:/";
        }
        ///if user exist
		if(userDto.getLoginName().equals(loginObject.getLoginName())
                && userDto.getPassword().equals(loginObject.getPassword())){
			session.setAttribute("userDto", userDto);
			return "redirect:/showContacts";
		}else{
			System.out.println("IN ELSE!");
			attributes.addFlashAttribute("error", "errText.isExisting");
            return "redirect:/";
		}
	}


	
}
