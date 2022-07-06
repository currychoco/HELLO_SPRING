package hello.hellospring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public String hello(Model model) {
		
		model.addAttribute("data","데이타가 어디 가는데!!!!!");
		return "hello";
		
	}
	
	@GetMapping("/hello-mvc")
	public String helloMvc(
			@RequestParam("name") String name
			, @RequestParam("name2") String name2
			, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("name2", name2);
		return "hello-template";
	}
	
	@GetMapping("/hello-mvc2")
	public String helloMvc2(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String name2 = request.getParameter("name2");
		model.addAttribute("name", name);
		return "hello-template";
	}
	
	@GetMapping("/empInfo")
	public String insertFormEmpInfo(@RequestParam(value = "name", required = false) String name
			, @RequestParam(value = "gender", required = false) String gender
			, @RequestParam(value = "hpNo", required = false) String hpNo
			, Model model) {
		
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		model.addAttribute("hpNo", hpNo);
		
		return "emp-info-form";
	}
	
	@PostMapping("/empInfo")
	public String insertEmpInfo(@RequestParam(value = "name", required = false) String name
			, @RequestParam(value = "gender", required = false) String gender
			, @RequestParam(value = "hpNo", required = false) String hpNo
			, Model model) {
		
		model.addAttribute("name", name);
		model.addAttribute("gender", gender);
		model.addAttribute("hpNo", hpNo);
		
		// DB 에 정보 저장
		
		//
		
		return "emp-info";
	}
	
	

}
