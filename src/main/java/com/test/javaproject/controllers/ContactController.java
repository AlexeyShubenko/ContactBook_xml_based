package com.test.javaproject.controllers;

import com.test.javaproject.dao.WorkService;
import com.test.javaproject.domains.*;
import com.test.javaproject.dto.ContactDto;
import com.test.javaproject.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@SessionAttributes("userDto")
public class ContactController {

    private WorkService service;

    @Autowired
	public ContactController(WorkService service){
		this.service = service;
	}

	@RequestMapping(value="/addContact", method=RequestMethod.GET)
	public ModelAndView addContact(){
		ModelAndView model = new ModelAndView("contactRegistr","contactDto",new ContactDto());
		model.addObject("editButton", true);
		return model;
	}
	
	@RequestMapping(value="/showContacts", method=RequestMethod.GET)
	public ModelAndView showContacts(@ModelAttribute UserDto userDto,Model model){
		List<ContactDto> contactsDto = service.getContactService().getContactList(userDto.getUser_id());
		ModelAndView modelAndView = new ModelAndView();
		//for further searching of contacts
		modelAndView.addObject("searcher", new SearchObject());
		modelAndView.setViewName("mainPage");
		///all contacts will be searched
		modelAndView.addObject("contactsDto", contactsDto);
		return modelAndView;
	}
	
	@RequestMapping(value="/saveNewContact", method=RequestMethod.POST)
	public String saveContact(@Validated @ModelAttribute("contactDto") ContactDto contactDto, BindingResult result,
							  ModelMap model, RedirectAttributes attributes){
		if(result.hasErrors() || !RegEx.checkValidTelNumber(contactDto.getMobPhoneNumber()) ||
				!RegEx.checkValidHomeNumber(contactDto.getHomePhoneNumber())){;
			if(!RegEx.checkValidTelNumber(contactDto.getMobPhoneNumber()))
				model.addAttribute("edit1", true);
			if(!RegEx.checkValidHomeNumber(contactDto.getHomePhoneNumber()))
				model.addAttribute("edit2", true);
			return "contactRegistr";
		} else{
		UserDto user = (UserDto) model.get("userDto");
		service.getContactService().saveContact(user.getUser_id(), contactDto);
		return "redirect:/showContacts";
		}
	}
	
	@RequestMapping(value="/editContact/{contact_id}", method=RequestMethod.GET)
	public ModelAndView editContactToForm(@PathVariable("contact_id") int contact_id, ModelMap model){
		ContactDto contactDto = service.getContactService().getContactById(contact_id);
		return new ModelAndView("contactOldEdit","contactDto", contactDto);
	}
	
	@RequestMapping(value="/editContact/{contact_id}", method=RequestMethod.POST)
	public String editContactToDB(@Valid @ModelAttribute("contactDto") ContactDto contactDto, BindingResult result,
								  @PathVariable("contact_id") int contact_id, ModelMap model){
		if(result.hasErrors() || !RegEx.checkValidTelNumber(contactDto.getMobPhoneNumber()) ||
				!RegEx.checkValidHomeNumber(contactDto.getHomePhoneNumber())){
			if(!RegEx.checkValidTelNumber(contactDto.getMobPhoneNumber()))
				model.addAttribute("edit1", true);
			if(!RegEx.checkValidHomeNumber(contactDto.getHomePhoneNumber()))
				model.addAttribute("edit2", true);
			return "contactOldEdit";
		} else{
		service.getContactService().editContact(contactDto);
		return "redirect:/showContacts";
		}
	}
	
	@RequestMapping(value="/deleteContact/{contact_id}", method=RequestMethod.GET)
	public String deleteContact(@PathVariable("contact_id") int contact_id, ModelMap model){
		service.getContactService().deleteContact(contact_id);
		return "redirect:/showContacts";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public ModelAndView searchOj(@ModelAttribute("searcher")SearchObject searchObject, @ModelAttribute UserDto userDto, Model model){
		List<ContactDto> contactsDto;
		if(searchObject.getSearcher().equals("")){
			contactsDto = service.getContactService().getContactList(userDto.getUser_id());
		} else{
			contactsDto = service.getContactService().getContactsByParam(searchObject,userDto.getUser_id());
		}
		return new ModelAndView("mainPage","contactsDto", contactsDto);
	}
	
	@RequestMapping(value="/logOut", method=RequestMethod.GET)
	public String logOut(){
		return "exitPage";
	}
	
	@RequestMapping(value="/exit", method=RequestMethod.GET)
	public String exit(SessionStatus session){
		session.setComplete();
		return "redirect:/startPage";
	}
	
}
