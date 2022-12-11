package ru.dnsbo.blogreferee2.models.Books;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    //состояние судейской книжки
    private StateBooks stateBooks;
    //дата окончания судейской книжки
    private String expirationDate;

}
