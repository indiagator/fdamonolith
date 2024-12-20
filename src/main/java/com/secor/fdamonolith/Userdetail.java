package com.secor.fdamonolith;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "userdetails")
@Getter
@Setter
public class Userdetail {

    @Id
    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "firstname", length = 50)
    private String fname;

    @Column(name = "lastname", length = 50)
    private String lname;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "country", length = 50)
    private String country;


}