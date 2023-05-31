package com.computerstore.platform.computerstore.repository;

import com.computerstore.platform.computerstore.entity.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Long> {}
