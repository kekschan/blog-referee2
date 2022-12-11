package ru.dnsbo.blogreferee2.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.dnsbo.blogreferee2.models.Books.Books;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstname;
    private String lastname;
    private String email;
    private String numberPhone;
    private String dateBirthday;
    private String password;
    private String country;
    private String city;
    private String street;
    private String house;
    private String flat;

    @OneToOne
    private Books books;

    @Enumerated(value = EnumType.STRING)
    private Role role;
    @Enumerated(value = EnumType.STRING)
    private State state;

}
