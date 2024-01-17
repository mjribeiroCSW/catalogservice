package csw.catalogservice.repositories;

import csw.catalogservice.Models.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorModel, Integer>
{

}
