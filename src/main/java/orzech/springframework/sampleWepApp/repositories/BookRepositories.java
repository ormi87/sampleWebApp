package orzech.springframework.sampleWepApp.repositories;

import org.springframework.data.repository.CrudRepository;
import orzech.springframework.sampleWepApp.domain.Book;

public interface BookRepositories extends CrudRepository<Book, Long> {
}
