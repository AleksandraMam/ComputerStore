package com.computerstore.platform.computerstore.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class HardDrive extends Product {

    private int capacity;
}
