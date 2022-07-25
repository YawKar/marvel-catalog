package com.yawkar.marvelcatalog.repository;

import com.yawkar.marvelcatalog.repository.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroesRepository extends JpaRepository<Hero, Long> {
}
