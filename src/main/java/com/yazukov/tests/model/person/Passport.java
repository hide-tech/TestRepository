package com.yazukov.tests.model.person;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "passports")
@Data
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "identification_number")
    private String identificationNumber;
    @Column(name = "passport_number")
    private String passportNumber;
    @Column(name = "issue_date")
    private LocalDate issueDate;
    @Column(name = "expire_date")
    private LocalDate expireDate;
    @Column(name = "authority")
    private String authority;
    @ManyToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;
}
