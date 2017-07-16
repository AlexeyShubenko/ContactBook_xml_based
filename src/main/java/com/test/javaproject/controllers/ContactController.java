package com.test.javaproject.controllers;

import com.test.javaproject.dao.impl.WorkService;
import com.test.javaproject.domains.*;
import com.test.javaproject.dto.ContactDto;
import com.test.javaproject.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@Controller
//@SessionAttributes("userDto")
public class ContactController {

    private WorkService service;

    @Autowired
	public ContactController(WorkService service){
		this.service = service;
	}

	@RequestMapping(value="/showContacts", method=RequestMethod.GET)
	public ModelAndView showContacts(HttpSession session){
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		if(Objects.isNull(userDto)){
			return new ModelAndView("redirect:/");
		}
		List<ContactDto> contactsDto = service.getContactServiceImpl().getContactList(userDto.getUser_id());
		ModelAndView modelAndView = new ModelAndView();
		//for further searching of contacts
		modelAndView.addObject("searcher", new SearchObject());
		modelAndView.setViewName("mainPage");
		///all contacts will be searched
		modelAndView.addObject("contactsDto", contactsDto);
		return modelAndView;
	}

	@RequestMapping(value="/addContact", method=RequestMethod.GET)
	public ModelAndView addContact(Model model, HttpSession session){
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		ModelAndView modelAndView = new ModelAndView();
		if(Objects.isNull(userDto)){
			modelAndView.setViewName("redirect:/");
			return modelAndView;
		}
		if(!model.containsAttribute("contactDto")){
			modelAndView.addObject("contactDto", new ContactDto());
		}
		modelAndView.setViewName("contactRegistr");
		return modelAndView;
	}
	
	@RequestMapping(value="/saveNewContact", method=RequestMethod.POST)
	public String saveContact(@Validated @ModelAttribute("contactDto") ContactDto contactDto, BindingResult result,
							  RedirectAttributes attributes, HttpSession session){
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		if(Objects.isNull(userDto)){
			return "redirect:/";
		}
		if(result.hasErrors() || !RegEx.checkValidTelNumber(contactDto.getMobPhoneNumber()) ||
				!RegEx.checkValidHomeNumber(contactDto.getHomePhoneNumber())){
			///show entered data on reload page
			attributes.addFlashAttribute("org.springframework.validation.BindingResult.contactDto",result);
			attributes.addFlashAttribute("contactDto",contactDto);
			if(!RegEx.checkValidTelNumber(contactDto.getMobPhoneNumber()))
				attributes.addFlashAttribute("error1","errText.registration.errTelNumber");
//				model.addAttribute("edit1", true);
			if(!RegEx.checkValidHomeNumber(contactDto.getHomePhoneNumber()))
				attributes.addFlashAttribute("error2","errText.registration.errHomeNumber");
//				model.addAttribute("edit2", true);
			return "redirect:/addContact";
		} else{
			service.getContactServiceImpl().saveContact(userDto.getUser_id(), contactDto);
			return "redirect:/showContacts";
		}
	}
	///"editContact/{contact_id}"
	@RequestMapping(value="/{contact_id}", method=RequestMethod.GET)
	public ModelAndView editContactToForm(@PathVariable("contact_id") int contact_id, HttpSession session){
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		if(Objects.isNull(userDto)){
			return new ModelAndView("redirect:/");
		}
		ContactDto contactDto = service.getContactServiceImpl().getContactById(contact_id);
		return new ModelAndView("contactOldEdit","contactDto", contactDto);
	}
	
	@RequestMapping(value="/{contact_id}", method=RequestMethod.POST)
	public String editContactToDB(@Valid @ModelAttribute("contactDto") ContactDto contactDto, BindingResult result,
								  @PathVariable("contact_id") int contact_id,
								  RedirectAttributes attributes,HttpSession session){
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		if(Objects.isNull(userDto)){
			return "redirect:/";
		}
		if(result.hasErrors() || !RegEx.checkValidTelNumber(contactDto.getMobPhoneNumber()) ||
				!RegEx.checkValidHomeNumber(contactDto.getHomePhoneNumber())){
			///show entered data on reload page
			attributes.addFlashAttribute("org.springframework.validation.BindingResult.contactDto",result);
			attributes.addFlashAttribute("contactDto",contactDto);
			if(!RegEx.checkValidTelNumber(contactDto.getMobPhoneNumber()))
				attributes.addFlashAttribute("error1","errText.registration.errTelNumber");
//				model.addAttribute("edit1", true);
			if(!RegEx.checkValidHomeNumber(contactDto.getHomePhoneNumber()))
				attributes.addFlashAttribute("error2","errText.registration.errHomeNumber");
//				model.addAttribute("edit2", true);
			return "redirect:/"+contact_id;
		} else{
			service.getContactServiceImpl().editContact(contactDto);
			return "redirect:/showContacts";
		}
	}
	
	@RequestMapping(value="/deleteContact/{contact_id}", method=RequestMethod.GET)
	public String deleteContact(@PathVariable("contact_id") int contact_id, HttpSession session){
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		if(Objects.isNull(userDto)){
			return "redirect:/";
		}
		service.getContactServiceImpl().deleteContact(contact_id);
		return "redirect:/showContacts";
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public ModelAndView searchOj(@ModelAttribute("searcher")SearchObject searchObject, HttpSession session){
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		List<ContactDto> contactsDto;
		if(searchObject.getSearcher().equals("")){
			contactsDto = service.getContactServiceImpl().getContactList(userDto.getUser_id());
		} else{
			contactsDto = service.getContactServiceImpl().getContactsByParam(searchObject,userDto.getUser_id());
		}
		return new ModelAndView("mainPage","contactsDto", contactsDto);
	}
	
	@RequestMapping(value="/logOut", method=RequestMethod.GET)
	public String logOut(){
		return "exitPage";
	}
	
	@RequestMapping(value="/exit", method=RequestMethod.GET)
	public String exit(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
	
}
