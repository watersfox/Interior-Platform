package com.interiormon.interiorProject.persistence;

import com.interiormon.interiorProject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    boolean existsByUserId(String userId);

    boolean existsByEmail(String email);

    boolean existsByNickname(String nickname);

    User findByUserIdAndPassword(String userId, String password);

    User findByUserId(String userId);

    User findByEmail(String email);

    void deleteUserByUserId(String userId);
}