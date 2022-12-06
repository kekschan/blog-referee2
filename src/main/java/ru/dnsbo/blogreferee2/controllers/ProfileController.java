package ru.dnsbo.blogreferee2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dnsbo.blogreferee2.form.RegistrationForm;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @GetMapping
    private String GetRegistrationPage() {
        return "profile";
    }

}
