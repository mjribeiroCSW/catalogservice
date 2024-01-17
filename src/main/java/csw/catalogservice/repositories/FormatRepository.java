package csw.catalogservice.repositories;

import csw.catalogservice.Models.FormatModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormatRepository extends JpaRepository<FormatModel, Integer>
{

}