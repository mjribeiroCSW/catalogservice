package csw.catalogservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "author")
public class AuthorModel {

    @Id
    private int id;
}
