package com.mohamedsctraore.spatial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Mohamed on 12/19/18.
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "pages/samples/dashboard";
    }
}
