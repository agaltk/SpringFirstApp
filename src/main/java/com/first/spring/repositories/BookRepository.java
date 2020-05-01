package com.first.spring.repositories;

import com.first.spring.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {{
}
