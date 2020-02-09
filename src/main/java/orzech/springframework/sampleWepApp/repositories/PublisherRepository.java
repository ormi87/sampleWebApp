package orzech.springframework.sampleWepApp.repositories;

import org.springframework.data.repository.CrudRepository;
import orzech.springframework.sampleWepApp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
