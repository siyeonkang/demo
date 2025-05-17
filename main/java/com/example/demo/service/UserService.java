package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    // (1) 생성자 주입
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // (2) Create(생성)
    public User createUser(String name, String email) {
        User user = new User(name, email);
        return userRepository.save(user); // INSERT
    }

    // (3) Read - 전체 조회
    public List<User> getAllUsers() {
        return userRepository.findAll();  // SELECT *
    }

    // (4) Read - 단건 조회
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // (5) Update(수정)
    public User updateUser(Long id, String name, String email) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(name);
            user.setEmail(email);
            return userRepository.save(user); // UPDATE
        }
        return null;
    }

    // (6) Delete(삭제)
    public void deleteUser(Long id) {
        userRepository.deleteById(id); // DELETE
    }
}