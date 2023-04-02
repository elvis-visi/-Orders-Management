package com.elvis.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.elvis.models.LoginModel;

@Controller
@RequestMapping("/login")
public class LoginController {

	@GetMapping("/")
	public String displayLoginForm(Model model)
	{
		
		model.addAttribute("loginModel", new LoginModel());
		
		
		return "loginForm.html";
	}
	
	//BindingResult will take whatever was input in the form and send its parameter to the 
	//controller so we can sense whether there has been an error in the validation
	@PostMapping("/processLogin")
	public String processLogin(@Valid LoginModel loginModel, BindingResult bindingResult,
			Model model)
	{
		
		if(bindingResult.hasErrors())
		{
			model.addAttribute("loginModel", loginModel);
			return "loginForm.html";
		}
		
		model.addAttribute("loginModel", loginModel);
		
		
		return "loginResults.html";
	}
}


/*
anything going to /login will be handled by an event inside the controller
*/