package com.yawkar.marvelcatalog.repository;

import com.yawkar.marvelcatalog.entity.Comic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicsRepository extends JpaRepository<Comic, Long> {
}
