package ru.dnsbo.blogreferee2.services;

import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.dnsbo.blogreferee2.data.UsersRepository;
import ru.dnsbo.blogreferee2.form.RegistrationForm;
import ru.dnsbo.blogreferee2.models.Role;
import ru.dnsbo.blogreferee2.models.State;
import ru.dnsbo.blogreferee2.models.Users;

@Service
@Builder
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void registration(RegistrationForm registrationForm) {

        String hashPassword = passwordEncoder.encode(registrationForm.getPassword());

        //заполняем форму для регистрации
        Users users = Users.builder()
                .firstname(registrationForm.getFirstname())
                .lastname(registrationForm.getLastname())
                .email(registrationForm.getEmail())
                .password(hashPassword)
                .numberPhone(registrationForm.getNumberPhone())
                .country(registrationForm.getCountry())
                .city(registrationForm.getCity())
                .dateBirthday(registrationForm.getDateBirthday())
                .street(registrationForm.getStreet())
                .house(registrationForm.getHouse())
                .flat(registrationForm.getFlat())
                //ставится по умолчанию
                .role(Role.USER)
                .state(State.ACTIVE)
                .build();

        //сохраняем пользователя в бд
        usersRepository.save(users);
    }
}
