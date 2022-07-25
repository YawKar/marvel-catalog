package com.yawkar.marvelcatalog.repository;

import com.yawkar.marvelcatalog.repository.entity.Comic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicsRepository extends JpaRepository<Comic, Long> {
}
