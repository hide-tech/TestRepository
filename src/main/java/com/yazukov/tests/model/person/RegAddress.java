package com.yazukov.tests.model.person;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reg_address")
@Data
public class RegAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "index")
    private String index;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
    @Column(name = "street")
    private String street;
    @Column(name = "building")
    private String building;
    @Column(name = "extension")
    private String extension;
    @Column(name = "office")
    private String office;
    @Column(name = "begin_date")
    private LocalDate beginDate;
    @Column(name = "expire_date")
    private LocalDate expireDate;
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "person_id")
    private Person person;
    @Column(name = "deleted")
    private boolean deleted;
}
