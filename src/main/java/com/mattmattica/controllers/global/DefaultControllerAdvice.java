package com.mattmattica.controllers.global;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class DefaultControllerAdvice {

    public static final String BASE_URL = "BASE_URL";
    public static final String TITLE = "TITLE";

    @ModelAttribute(BASE_URL)
    public String addBaseHrefToModel(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        int queryIndex = url.indexOf("?");
        // Try to remove query parameters
        if (queryIndex >= 0) {
            url = url.substring(0, queryIndex);
        }
        // Try adding trailing slash
        if (url.charAt(url.length() - 1) != '/') {
            url += "/";
        }
        return url;
    }

}
