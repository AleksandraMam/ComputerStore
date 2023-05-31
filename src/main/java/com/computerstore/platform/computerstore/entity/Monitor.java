package com.computerstore.platform.computerstore.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Monitor extends Product {

    private int diagonal;

}