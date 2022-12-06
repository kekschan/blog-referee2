package ru.dnsbo.blogreferee2.form;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;
import ru.dnsbo.blogreferee2.models.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RegistrationForm {

    private String firstname;
    private String lastname;
    private String email;
    private String numberPhone;
    private String password;
    private String country;
    private String city;
    private String street;
    private String house;
    private String flat;

   /* public Users toUser(PasswordEncoder passwordEncoder){
        return new Users
                (firstname,lastname,email,country,numberPhone,
                passwordEncoder.encode(password), city,street,house,flat);
    }*/
}
