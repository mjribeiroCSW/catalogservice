package csw.catalogservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "language")
public class LanguageModel {

    @Id
    private int id;
}
