package com.mattmattica.controllers.global;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

@Controller
public class CustomErrorController implements ErrorController {

    @ModelAttribute("ERROR_MESSAGE")
    public String labelAttribute() {
        return "Something went wrong :(";
    }

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (Objects.nonNull(status)) {
            int code = Integer.parseInt(status.toString());
            model.addAttribute("errorCode", code);
        }
        return "error";
    }
}
