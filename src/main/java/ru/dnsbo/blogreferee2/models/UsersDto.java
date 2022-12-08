package ru.dnsbo.blogreferee2.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link Users} entity
 */
@Data
@AllArgsConstructor
@Builder
public class UsersDto implements Serializable {
    private final String firstname;
    private final String lastname;
    private final String email;
    private final String numberPhone;
    private final String country;
    private final String city;
    private final String street;
    private final String house;
    private final String flat;
    private final State state;

    public static UsersDto from(Users users) {
        return UsersDto.builder().
                firstname(users.getFirstname())
                .lastname(users.getLastname())
                .email(users.getEmail())
                .numberPhone(users.getNumberPhone())
                .country(users.getCountry())
                .city(users.getCity())
                .street(users.getStreet())
                .house(users.getHouse())
                .flat(users.getFlat())
                .state(users.getState())
                .build();
    }
}