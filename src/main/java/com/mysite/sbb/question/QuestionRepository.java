package com.mysite.sbb.question;

import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository JPA 인터페이스 중 하나로 CRUD 작업을 처리하는 메서드들을 내장하고 있음
//Question 엔티티로 리포지터리 생성
public interface QuestionRepository extends JpaRepository<Question,Integer>{
	Question findBySubject(String subject);
}
