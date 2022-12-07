package ru.dnsbo.blogreferee2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @GetMapping
    private String GetShopPage(){
        return "profile";
    }
}
