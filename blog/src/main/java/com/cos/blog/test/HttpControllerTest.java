package com.cos.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//사용자가 요청 ->응답(HTML 파일)
//@Controller

//사용자가 요청 -> 응답(Data)

@RestController
public class HttpControllerTest {

	private static final String TAG = "HttpConstrollerTest : ";
	
	/**
	 * 롬복 이용
	 * @return
	 */
//	@GetMapping("/http/lombok")
//	public String lombokTest() {
//		Member m = new Member(1, "ssar", "1234", "email");
//		System.out.println(TAG + " getter : " + m.getUsername());
//		m.setUsername("홍길동");
//		System.out.println(TAG + " setter : " + m.getUsername());
//		return "lombok test 완료";
//	}
	
	/**
	 * @Builder 어노테이션을 이용한 객체 생성
	 * @return
	 */
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = Member.builder().username("ssar").password("1234").email("ssar@nate.com").build(); //순서 상관없음
		System.out.println(TAG + " getter : " + m.getUsername());
		m.setUsername("cos");
		System.out.println(TAG + " setter : " + m.getUsername());
		return "lombok test 완료";
	}
	

	/**
	 *  인터넷 브라우저 요청은 무조건 get 요청밖에 할 수가 없다.
	 * http://localhost:8080/http/get(select)
	 * @param m
	 * @return
	 */
	
//	@GetMapping("/http/get")
//	public String getTest(@RequestParam int id, @RequestParam String username) {
//		return "get 요청 : " + id + ", " + "username : " + username;
//	}
	
	@GetMapping("/http/get")
	public String getTest(Member m) { //?id=1&username=ss&password=1234&email=ssar@nate.com
		return "get 요청 : " + m.getId() + ", " + "username : " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}
	
	/**
	 * http://localhost:8080/http/post(insert)
	 * @param m
	 * @return
	 */
	
//	@PostMapping("/http/post")
//	public String postTest(Member m) {
//		return "post 요청 : " + m.getId() + ", " + "username : " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
//	}
	
//	@PostMapping("/http/post") //text/plain (평문)
//	public String postTest(@RequestBody String text) {
//		return "post 요청 : " + text;
//	}
	
	@PostMapping("/http/post") //application/json
	public String postTest(@RequestBody Member m) { //MassageConverter (스프링부트)
		return "post 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}
	
	/**
	 * http://localhost:8080/http/put(update)
	 * @param m
	 * @return
	 */
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
	}
	
	/**
	 * http://localhost:8080/http/delete(delete)
	 * @return
	 */
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
