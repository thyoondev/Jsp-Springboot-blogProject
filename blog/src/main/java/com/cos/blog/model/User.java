package com.cos.blog.model;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //빌더패턴
//ORM -> JAVA(다른언어) Object -> 테이블로 맵핑
@Entity //User 클래스가 자동으로 MySQL에 테이블이 생성된다.
//@DynamicInsert //insert시에 null인 필드를 제외시켜준다.
public class User {
 
	@Id //Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.(오라클: 시퀀스, MySQL : auto_increment)
	private int id;
	
	@Column(nullable = false, length = 30)
	private String username; //아이디
	
	@Column(nullable = false, length = 100) //123456 => hash(비밀번호 암호화)
	private String password; 
	
	@Column(nullable = false, length = 50)
	private String email;
	
	//@ColumnDefault("'user'")
	//DB는 RoleType이라는 것이 없다.
	@Enumerated(EnumType.STRING) //DB에 타입 명시
	private RoleType role; //Enum을 쓰는게 좋다.(도메인 설정 가능 = [범위 ex) 남, 녀]) //ADMIN, USER
	
	@CreationTimestamp //시간이 자동 입력
	private Timestamp createDate;
}
