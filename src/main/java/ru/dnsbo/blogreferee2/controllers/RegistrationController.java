package ru.dnsbo.blogreferee2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.dnsbo.blogreferee2.data.UsersRepository;
import ru.dnsbo.blogreferee2.form.RegistrationForm;
import ru.dnsbo.blogreferee2.services.RegistrationService;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    RegistrationService registrationService;

    @GetMapping
    private String GetRegistrationPage() {
        return "registration";
    }

    @PostMapping
    private String PostRegistrationPage(Model model, @Valid RegistrationForm form,
                                        Errors errors) {
        //проверка на существующий email
        if(usersRepository.findByEmail(form.getEmail()).isPresent()) {
            return "registration";
        }
        //проверка на валидность
        if(errors.hasErrors()){
            return "registration";
        }
        registrationService.registration(form);
        return "redirect:/login";
    }
}
