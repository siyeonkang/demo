package com.example.demo.domain;

import jakarta.persistence.*;

@Table(name = "users")  //엔티티 어노테이션 위에 추가 해야 하는 이유 //s 붙이면 오류 해결
// (1) DB 테이블과 매핑되는 클래스
@Entity
public class User {

    // (2) 기본키(PK) 필드
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // (3) 예시로 이름과 이메일만 가짐
    private String name;
    private String email;

    // (4) 기본 생성자 (JPA 사용 시 필수)
    public User() {
    }

    // (5) 편의상 모든 필드를 받는 생성자
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // (6) Getter/Setter
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}