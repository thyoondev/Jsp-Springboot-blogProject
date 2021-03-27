package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {

	//http://localhost:8000/blog/temp/home
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()");
		//파일리턴 기본경로 : src/main/resources/static (static 폴더안에는 정적 파일만 넣어야된다.)
		//리턴명 : /home.html
		//풀경로 : src/main/resources/static/home.html
		return "/home.html";
	}
	
	@GetMapping("/temp/img")
	public String tempImg() {
		return "/a.jpg";
	}
	
	//http://localhost:8000/blog/temp/home
	@GetMapping("/temp/jsp")
	public String tempJsp() {
		System.out.println("tempHome()");
		//prefix: /WEB-INF/views/
	    //suffix: .jsp
		//풀경로 : /WEB-INF/views/home.jsp
		return "/test";
	}

}
