package com.mohamedsctraore.spatial.controller;

import com.mohamedsctraore.spatial.domain.User;
import com.mohamedsctraore.spatial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public RegisterController(UserService service) {
        this.service = service;
    }

    @GetMapping("/register")
    public String registerForm() {
        return "pages/samples/register";
    }

    @PostMapping("/register")
    public String registerProcess(@RequestParam(name = "username") String email,
                                  @RequestParam(name = "password") String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        service.save(user);

        return "redirect:/";
    }

}
