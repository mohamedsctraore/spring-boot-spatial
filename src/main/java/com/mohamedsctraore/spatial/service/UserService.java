package com.mohamedsctraore.spatial.service;

import com.mohamedsctraore.spatial.domain.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Mohamed Traore
 */
public interface UserService extends CrudService<User, Long>, UserDetailsService {

    User findByEmail(String email);
}
