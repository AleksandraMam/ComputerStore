package com.computerstore.platform.computerstore.repository;

import com.computerstore.platform.computerstore.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long> {}
