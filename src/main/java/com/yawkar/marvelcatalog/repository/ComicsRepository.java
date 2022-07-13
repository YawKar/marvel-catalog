package com.yawkar.marvelcatalog.repository;

import com.yawkar.marvelcatalog.entity.Comic;
import org.springframework.data.repository.CrudRepository;

public interface ComicsRepository extends CrudRepository<Comic, Long> {
}
