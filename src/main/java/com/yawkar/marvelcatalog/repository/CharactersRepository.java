package com.yawkar.marvelcatalog.repository;

import com.yawkar.marvelcatalog.entity.Character;
import org.springframework.data.repository.CrudRepository;

public interface CharactersRepository extends CrudRepository<Character, Long> {
}
