package csw.catalogservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "genre")
public class GenreModel {

    @Id
    private int id;
}