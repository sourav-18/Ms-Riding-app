package com.ms.rider_service.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "riders")
@Getter
@Setter
public class Rider extends Base{

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "mobile_no",nullable = false,unique = true)
    private String mobileNo;

    @Column(name = "email")
    private String email;

    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;
}
