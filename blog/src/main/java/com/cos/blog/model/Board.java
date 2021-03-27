package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //빌더패턴
@Entity
public class Board {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob //대용량 데이터
	private String content; //섬머노트 라이브러리 <html> 태그가 섞여서 디자인됨
	
	@ColumnDefault("0")
	private int count; //조회수

	@ManyToOne(fetch = FetchType.EAGER) //Board = Many, User = One //한명의 유저는 여러개의 게시글을 작성할 수 있다.
	@JoinColumn(name = "userId")
	private User user; //DB는 오브젝트를 저장할 수 없다. FK, 자바는 오브젝트를 저장할 수 있다.
	//private int userId;
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER) //mappedBy가 적혀있으면 연관관계의 주인이 아니다(난 FK가 아니에요) DB에 칼럼을 만들지 마세요.
	//FetchType.EAGER 화면 보여줄 때 바로 가져옴 ex)댓글창 바로 보일 때
	//FetchType.LAZY 화면 보여줄 때 바로 가져오지 않고 필요할 때 가져옴 ex)댓글창 바로 안보이고 더보기.. 같은 버튼 눌렀을 때
	//@JoinColumn(name = "replyId")은 필요없음
	private List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate;
}
