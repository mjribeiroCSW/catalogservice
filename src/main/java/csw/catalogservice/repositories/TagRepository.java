package csw.catalogservice.repositories;

import csw.catalogservice.Models.TagModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<TagModel, Integer>
{

}