package com.mattmattica.controllers;

import com.mattmattica.controllers.global.DefaultControllerAdvice;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Controller
public class IndexController {

    @GetMapping({"", "/", "index", "index.html"})
    public String index(Model model) {
        model.addAttribute(DefaultControllerAdvice.TITLE, "MattMattica");
        return "index";
    }

}
