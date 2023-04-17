package com.springmvcstudy.ch2;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class ExceptionController {
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 200 >> 500
	public String catcher(Exception ex, Model m) {
		System.out.println("catcher() is in ExceptionController");
		System.out.println("m=" + m);
		m.addAttribute("ex", ex);
		return "error";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public String catcher2(Exception ex, Model m) {
		m.addAttribute("ex", ex);
		return "error";
	}
	
	@RequestMapping("/ex")
	public String main(Model m) throws Exception { //Model은 chatcher() Model과 다
		m.addAttribute("msg", "message from ExcptionController.main()");
		throw new Exception("예외가 발생했습니다.");
	}
	@RequestMapping("/ex2")
	public String main2() throws Exception {
		throw new NullPointerException("NullPoint 예외가 발생했습니다.");
	}
}
