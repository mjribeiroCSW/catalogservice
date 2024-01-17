package csw.catalogservice.repositories;

import csw.catalogservice.Models.LanguageModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<LanguageModel, Integer>
{

}