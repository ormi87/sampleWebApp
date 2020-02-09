package orzech.springframework.sampleWepApp.repositories;

import org.springframework.data.repository.CrudRepository;
import orzech.springframework.sampleWepApp.domain.Author;

public interface AuthorRepositories extends CrudRepository<Author, Long> {
}
