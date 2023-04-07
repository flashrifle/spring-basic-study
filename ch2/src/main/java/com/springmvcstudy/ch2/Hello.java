package com.springmvcstudy.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 1. 원격 호출 가능한 프로그램으로 등
@Controller
public class Hello {
	
	int iv = 10;		//인스턴스 변수
	static int cv = 20; // static 변수
	
	// 2. URL과 메서드 맵
	@RequestMapping("/hello")
	private void main() {				// 인스턴스 메서드 - iv, cv 둘다 사용가능
		System.out.println("Hello - private");
		System.out.println(iv);
		System.out.println(cv);
	}
	
	public static void main2() {		// static 메서드 - cv 만 사용가능 
		System.out.println(cv);
	//	System.out.println(iv);		// 에러
	}
	
}

