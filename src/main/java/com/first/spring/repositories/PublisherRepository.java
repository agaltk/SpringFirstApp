package com.first.spring.repositories;

import com.first.spring.domain.Book;
import com.first.spring.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
