package com.taverna.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taverna.models.Usuario;

@Controller
@RequestMapping("/")
public class TavernaMainController {
	private List<Usuario> userList = new ArrayList<Usuario>();

	@RequestMapping(method = RequestMethod.GET)
	public String sayHello(ModelMap model) {

		model.addAttribute("greeting", "aaaaaaaaaaaaa");
		return "home";
	}

	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String cadastroHtml(ModelMap model) {
		
		
		return "cadastro";
	}

	@RequestMapping(value = "/helloagain", method = RequestMethod.GET)
	public String sayHelloAgain(ModelMap model) {
		model.addAttribute("greeting", "Hello World Again, from Spring 4 MVC");
		return "home";
	}


	@RequestMapping(value = "/cadastro/doCadastro" , method = RequestMethod.POST)
	@ResponseBody
	public JSONObject add(HttpServletRequest request, HttpServletResponse response) throws Exception {

		JSONObject user = new JSONObject();
		
		String firstName = request.getParameter("data");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");

		
		
		
		
		

		

		return user;
	}
	/*
	 * @RequestMapping(value = "/cadastro/doCadastro") public @ResponseBody String getSearchResultViaAjax(@RequestParam(value = "data") String data) { System.out.println("aaaaaaa"); System.out.println(data);
	 * 
	 * return ""; }
	 */
}
