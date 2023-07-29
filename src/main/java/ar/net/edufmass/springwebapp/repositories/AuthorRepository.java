package ar.net.edufmass.springwebapp.repositories;

import ar.net.edufmass.springwebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
