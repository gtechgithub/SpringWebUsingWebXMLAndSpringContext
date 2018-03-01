package com.javapoint;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.NoHandlerFoundException;

@Controller
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class HomeController {
	
	private Employee employee;

	
	public Employee getEmployee() {
		return employee;
	}

	@Autowired
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleResourceNotFoundMethod() {
		
		System.out.println("inside handleResourceNotFoundMetod");
		return "errorpage404";
	}
	

	@RequestMapping(value="/Home",method=RequestMethod.GET)
	public String home(Locale locale,Model model) {
		
		System.out.println("employee hashcode="+employee.hashCode());
		
		Date date = new Date();
		DateFormat dateformat = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG,locale);
		
		String formatdate = dateformat.format(date);
		
		model.addAttribute("serverTime",formatdate);
		return "home";
	}
	


	
}


