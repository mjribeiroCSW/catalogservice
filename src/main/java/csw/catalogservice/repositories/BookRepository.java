package csw.catalogservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import csw.catalogservice.Models.BookModel;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Integer>
{

}