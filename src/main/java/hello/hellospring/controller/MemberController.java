package hello.hellospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;

@Controller
public class MemberController {

	private final MemberService memberService;

	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	
	 @PostMapping(value = "/member/join") public String
	 joinMember(@RequestParam(name = "name") String name, Model model) { Member
	 newMember = new Member(); newMember.setName(name); long id =
	 memberService.join(newMember); newMember.setId(id);
	 
	 model.addAttribute("member", newMember);
	 
	 return "joinMember"; }
	 
}
