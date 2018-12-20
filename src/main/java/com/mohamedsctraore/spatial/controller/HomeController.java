package com.mohamedsctraore.spatial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Mohamed Traore.
 */
@Controller
public class HomeController {

    @GetMapping("/dashboard")
    public String home() {
        return "pages/samples/dashboard";
    }
}
