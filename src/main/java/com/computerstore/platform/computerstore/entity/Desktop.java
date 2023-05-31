package com.computerstore.platform.computerstore.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Desktop extends Product {

    private String formFactor;

}
