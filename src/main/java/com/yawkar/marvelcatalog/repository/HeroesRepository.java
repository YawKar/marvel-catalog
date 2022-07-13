package com.yawkar.marvelcatalog.repository;

import com.yawkar.marvelcatalog.entity.Hero;
import org.springframework.data.repository.CrudRepository;

public interface HeroesRepository extends CrudRepository<Hero, Long> {
}
