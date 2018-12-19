package com.mohamedsctraore.spatial.controller;

import com.mohamedsctraore.spatial.domain.User;
import com.mohamedsctraore.spatial.exception.NotFoundException;
import com.mohamedsctraore.spatial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * @author Mohamed Traore
 */
@ControllerAdvice
public class BaseControllerAdvice {
    private final UserService service;

    @Autowired
    public BaseControllerAdvice(UserService service) {
        this.service = service;
    }

    @ExceptionHandler(NotFoundException.class)
    public String handledNotFoundException(NotFoundException e, Model model) {
        model.addAttribute("status", 400);
        model.addAttribute("exception", e);

        return "pages/samples/error-404";
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        model.addAttribute("status", 500);
        model.addAttribute("exception", e);

        return "pages/samples/error-500";
    }

    @ModelAttribute
    public void addCommonAttributes(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        if (userDetails != null) {
            User user = service.findByEmail(userDetails.getUsername());
            model.addAttribute("user", user);
        }
    }
}
