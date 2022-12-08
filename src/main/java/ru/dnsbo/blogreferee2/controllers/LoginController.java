package ru.dnsbo.blogreferee2.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping
    public String PageLogin(Authentication authentication, HttpServletRequest request, Model model) {
        if (authentication != null) {
            return "redirect:/profile";
        }
        if (request.getParameterMap().containsKey("error")) {
            model.addAttribute("error", "Пользователь не найден");
        }/* else {
            model.addAttribute("error", false);
        }*/
        return "/login";
    }

    @PostMapping("/login")
    public String SignIn(Model model) {
        return "redirect:/profile";
    }

}
