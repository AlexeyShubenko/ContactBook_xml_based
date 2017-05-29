package com.test.javaproject.controllers;

import com.test.javaproject.dao.WorkService;
import com.test.javaproject.domains.LoginTempObject;
import com.test.javaproject.domains.RegEx;
import com.test.javaproject.domains.User;
import com.test.javaproject.dto.UserDto;
import com.test.javaproject.exceptions.UserNotFindException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
@SessionAttributes(value="userDto")
public class LoginController {

	private WorkService service;

	@Autowired
	public LoginController(WorkService service){
		this.service = service;
	}

	///redirect to startPage, where you can log in
	///LoginTempObject - have data of log in user
	@RequestMapping(value = {"/","startPage"}, method = RequestMethod.GET)
	public ModelAndView startPageLog() {	
		ModelAndView model = new ModelAndView("startPage", "loginObject", new LoginTempObject());
		return model;
	}

	///after logging in, entered data id checked
	///loginObject - come from jsp,model - object with data from jsp
	@RequestMapping(value="/checkLoginUser", method=RequestMethod.POST)
	public String checkLoginUser(@Valid @ModelAttribute("loginObject") LoginTempObject loginObject, BindingResult result, Model model){
		if(result.hasErrors()){
            model.addAttribute("edit", true);
			return "startPage";
		}
//		if(loginObject.getLoginName()==null || loginObject.getPassword()==null){
//            model.addAttribute("edit", true);
//            model.addAttribute("loginObject", new LoginTempObject());
//            return "startPage";
//        }
        UserDto userDto;
		try{
		    userDto = service.getUserService().getUserByLoginObject(loginObject);
        }catch (UserNotFindException ex){
            return "startPage";
        }
//		if(!service.getUserService().checkExistingUser(loginObject) || !RegEx.checkValidLogin(loginObject.getLoginName())) {
		if(userDto.getLoginName().equals(loginObject.getLoginName())
                && userDto.getPassword().equals(loginObject.getPassword())){
            model.addAttribute("userDto", userDto);
			return "redirect:/showContacts";
		}else{
            model.addAttribute("edit", true);
            model.addAttribute("loginObject", new LoginTempObject());
            return "startPage";
		}
	}

	///redirect to registrationPage
	@RequestMapping(value="/userRegistration", method=RequestMethod.GET)
	public ModelAndView userRegistration() {
		return new ModelAndView("userRegistr", "newUserDto", new UserDto());
	}


	@RequestMapping(value="/saveNewUser", method=RequestMethod.POST)
	public String saveNewUser(@Valid @ModelAttribute("newUserDto") UserDto userDto, BindingResult result, Model model){
		boolean isExistUser = service.getUserService().checkExistingUser(userDto);
		if(result.hasErrors() || !RegEx.checkValidLogin(userDto.getLoginName())
				|| isExistUser){
			if(!RegEx.checkValidLogin(userDto.getLoginName()))
				///wrong symbols
				model.addAttribute("edit1", true);
			if(isExistUser){
				///user not exist
				model.addAttribute("edit2", true);
			}
			return "userRegistr";
		}else{
		service.getUserService().saveUser(userDto);
		return "redirect:/startPage";}
	}	
	
}
