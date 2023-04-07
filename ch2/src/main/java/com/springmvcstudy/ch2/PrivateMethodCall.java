package com.springmvcstudy.ch2;

import java.lang.reflect.Method;

public class PrivateMethodCall {

	public static void main(String[] args) throws Exception {

//		Hello hello = new Hello();
//		hello.main2();
		
		
		//Reflection API를 사용 - 클래스 정보를 얻고 다룰 수 있는 기능 제공
		//java.lang.reflect 패키지 제공
		//Hello 클래스의 Class객체를 얻어온다
		Class helloClass = Class.forName("com.springmvcstudy.ch2.Hello");
		Hello hello = (Hello)helloClass.newInstance(); // 클래스가 가진 정보로 객체 생성
		Method main = helloClass.getDeclaredMethod("main");	
		main.setAccessible(true); // private인 main()을 호출 가능하게 한다.
		
		main.invoke(hello); // hello.main()
	}

}
