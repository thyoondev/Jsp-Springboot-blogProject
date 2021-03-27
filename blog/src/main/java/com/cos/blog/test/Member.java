package com.cos.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

//lombok getter 와 setter 생성을 간단하게!
//@Getter
//@Setter
//@Data
//@AllArgsConstructor
//@RequiredArgsConstructor //final 붙은 애들의 Constructor를 생성해줌

/**
 * 어노테이션으로 하는 방식
 */
//@Data
//@AllArgsConstructor //전체생성자
//@NoArgsConstructor //빈생성자
//public class Member {
//
//	private int id; //final은 불면성을 위해 사용
//	private String username;
//	private String password;
//	private String email;
//	
	
/**
 * constructor를 오버로딩 없이 만드는 방법
 */
@Data
@NoArgsConstructor //빈생성자
public class Member {

	private int id; //final은 불면성을 위해 사용
	private String username;
	private String password;
	private String email;
	
	@Builder
	public Member(int id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
}
