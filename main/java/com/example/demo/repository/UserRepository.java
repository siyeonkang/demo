package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// (1) JpaRepository<Entity, PK타입>을 상속
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 별도의 메서드 정의 없이 기본적인 CRUD 사용 가능
}