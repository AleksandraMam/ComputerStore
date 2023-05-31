package com.computerstore.platform.computerstore.repository;

import com.computerstore.platform.computerstore.entity.Desktop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesktopRepository extends JpaRepository<Desktop, Long> {}
