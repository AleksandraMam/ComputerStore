package com.computerstore.platform.computerstore.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Laptop extends Product {

    private int size;

}
