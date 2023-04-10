package com.springmvcstudy.ch2;

import java.io.IOException;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class YoilTellerMVC {

	@RequestMapping("/getYoilMVC")
	public ModelAndView main(int year, int month, int day) throws IOException {
		//1.ModelAndView를 생성하고, 기본 뷰를 지정 
		ModelAndView mv = new ModelAndView();
        
		//2. 작업 
		char yoil = getYoil(year, month, day);
		
		//3. 결과 ModelAndView에 저
		mv.addObject("year", year);
		mv.addObject("month", month);
		mv.addObject("day", day);
		mv.addObject("yoil", yoil);
		
		//4. 작업 결과 보여줄 뷰의 이름 지정 
		mv.setViewName("yoil");
		
		//5. ModelAndVie 반환
		return mv;
		
	}

	private boolean isValid(int year, int month, int day) {
		return true;
	}

	private char getYoil(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		return " 일월화수목금토".charAt(dayOfWeek);
	}

}
