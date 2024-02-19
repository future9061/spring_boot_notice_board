package com.mysite.sbb.question;

import java.time.LocalDateTime;
import java.util.List;

import com.mysite.sbb.answer.Answer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Question {
	//엔티티에서 각 데이터를 구분하는 값, 중복되서는 안된다.
	@Id
	//데이터를 자동으로 1씩 증가시키며 GenerationType.IDENTITY는 고유의 번호를 생성
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=200)
	private String subject;
	
	//글자 수 관계 없이 텍스트를 넣겠다.
	@Column(columnDefinition="TEXT")
	private String content;
	
	
	private LocalDateTime createDate;
	
	//질문에서 답변을 참조한다.
	//1:N 관계이고, 질문에서 답변을 참조하려면 question.getAnswerList() 호출하면 된다.
	//mappedBy는 참조 엔티티의 속성명을 정의한다.
	//CascadeType.REMOVE는 질문이 삭제 되면 그에 대한 enswer이 모두 삭제되도록 한다.
	@OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
	private List<Answer> answerList;
}
