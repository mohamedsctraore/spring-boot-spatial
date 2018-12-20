package com.mohamedsctraore.spatial.controller;

import com.mohamedsctraore.spatial.domain.User;
import com.mohamedsctraore.spatial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Mohamed Traore
 */
@Controller
public class RegisterController {

    private final UserService service;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegisterController(UserService service, PasswordEncoder passwordEncoder) {
        this.service = service;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String registerForm() {
        return "pages/samples/register";
    }

    @PostMapping("/register")
    public String registerProcess(@RequestParam(name = "email") String email,
                                  @RequestParam(name = "firstname") String firstName,
                                  @RequestParam(name = "lastname") String lastName,
                                  @RequestParam(name = "password") String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        service.save(user);

        return "redirect:/dashboard";
    }
}
