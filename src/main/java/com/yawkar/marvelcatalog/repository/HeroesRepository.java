package com.yawkar.marvelcatalog.repository;

import com.yawkar.marvelcatalog.entity.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroesRepository extends JpaRepository<Hero, Long> {
}
