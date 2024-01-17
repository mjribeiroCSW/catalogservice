package csw.catalogservice.repositories;

import csw.catalogservice.Models.PublisherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<PublisherModel, Integer>
{

}