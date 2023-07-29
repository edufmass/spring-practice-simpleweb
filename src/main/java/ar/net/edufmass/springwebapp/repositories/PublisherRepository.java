package ar.net.edufmass.springwebapp.repositories;

import ar.net.edufmass.springwebapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
