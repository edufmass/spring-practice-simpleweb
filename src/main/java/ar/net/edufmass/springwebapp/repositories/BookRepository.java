package ar.net.edufmass.springwebapp.repositories;

import ar.net.edufmass.springwebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
