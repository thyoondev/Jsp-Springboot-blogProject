package com.cos.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cos.blog.model.User;

//DAO
//자동으로 Bean으로 등록이 된다.
//@Repository 생략 가능
public interface UserRepository extends JpaRepository<User, Integer>{
	//JPA Naming전략 (이름으로 쿼리 자동생성)
	//select * form where username = ?1 and password = ?2;
	//방법1
	User findByUsernameAndPassword(String username, String password);
	
	//방법2(native query)
//	@Query(value = "select * form where username = ?1 and password = ?2", nativeQuery = true)
//	User login(String username, String password);
}
