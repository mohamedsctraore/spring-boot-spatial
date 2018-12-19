package com.mohamedsctraore.spatial.repository;

import com.mohamedsctraore.spatial.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mohamed Traore
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
