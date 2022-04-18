package com.yazukov.tests.model.person;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "persons")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH}, mappedBy = "person")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Passport> passports;
    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH}, mappedBy = "person")
    @Fetch(value = FetchMode.SUBSELECT)
    private List<RegAddress> addresses;
    @Column(name = "deleted")
    private boolean deleted;
}
