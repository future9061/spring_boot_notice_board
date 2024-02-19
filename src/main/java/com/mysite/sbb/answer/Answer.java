package com.mysite.sbb.answer;

import java.time.LocalDateTime;

import com.mysite.sbb.question.Question;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.Question;
@Getter
@Setter
@Entity
public class Answer {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition = "TEXT")
	private String content;
	
	private LocalDateTime createDate;
	
	//answer에서 질문의 제목을 알고 싶다면 질문 엔티티와 연결된 속성이라는 걸 표시해야 한다.
	//하나의 질문의 여러 개의 답변이 달릴 수 있으므로 Many
	//질문은 하나이기 때문에 one가 된다. 즉 N:1의 관계가 성립.
	@ManyToOne
	private Question question;
}
