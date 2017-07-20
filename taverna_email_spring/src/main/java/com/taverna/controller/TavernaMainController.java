package com.taverna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class TavernaMainController {

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap model) {
	
		model.addAttribute("greeting", "aaaaaaaaaaaaa");
		return "home";
	}

	@RequestMapping(value="/cadastro", method = RequestMethod.GET)
	public String cadastroHtml(ModelMap model) {
		model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
		return "cadastro";
	}
	
	@RequestMapping(value = "/helloagain", method = RequestMethod.GET)
	public String sayHelloAgain(ModelMap model) {
		model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
		return "home";
	}
	
	@ResponseBody
	@RequestMapping(value = "/search/api/getSearchResult")
	public AjaxResponseBody getSearchResultViaAjax(@RequestBody SearchCriteria search) {

		AjaxResponseBody result = new AjaxResponseBody();
		//logic
		return result;

	}

}
