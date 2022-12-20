package ru.dnsbo.blogreferee2.form;

import lombok.Data;
import javax.validation.constraints.Size;

@Data
public class RegistrationForm {
    @Size(min = 3,max = 10)
    private String firstname;
    private String lastname;
    private String email;
    private String numberPhone;
    private String password;
    private String country;
    private String city;
    private String dateBirthday;
    private String street;
    private String house;
    private String flat;
}
