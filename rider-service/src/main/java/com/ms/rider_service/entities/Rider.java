package com.ms.rider_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "riders")
public class Rider extends Base{

    private String name;

    private String mobileNo;

    private String email;

    private Double latitude;

    private Double longitude;
}
