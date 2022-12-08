package ru.dnsbo.blogreferee2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dnsbo.blogreferee2.data.UsersRepository;
import ru.dnsbo.blogreferee2.models.Users;
import ru.dnsbo.blogreferee2.models.UsersDto;
import ru.dnsbo.blogreferee2.security.details.UsersDetailsImpl;
import ru.dnsbo.blogreferee2.services.RegistrationService;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    private UsersRepository usersRepository;


    @GetMapping
    private String GetShopPage(Model model, Authentication authentication) {
        UsersDetailsImpl principal = (UsersDetailsImpl) authentication.getPrincipal();
        UsersDto users = UsersDto.from(principal.getUsers());

        model.addAttribute("users", users);
        return "profile";
    }
}
