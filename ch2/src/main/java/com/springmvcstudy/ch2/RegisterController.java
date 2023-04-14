package com.springmvcstudy.ch2;

import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	
	@RequestMapping(value="/register/add", method= {RequestMethod.GET, RequestMethod.POST})
	public String register() {
		return "registerForm";
	}
	
//	@RequestMapping("/register/save", method=RequestMethod.POST)
	@PostMapping("/register/save")	// 4.3 부
	public String save(User user, Model m) throws Exception {
		// 1. 유효성 검사
		if(!isValid(user)) {
			String msg = URLEncoder.encode("id를 잘못 입력하셨습니다.", "utf-8");
//			return "redirect:/register/add?msg="+msg; // URL재작성(rewriting)
			m.addAttribute("msg"+msg);
			return "forward:/register/add";
//			return "redirect:/register/add";
		}
			
		// 2. DB에 신규 회원 정보 저
		return "registerInfo";
	}

	private boolean isValid(User user) {
		return false;
	}
	
	
}