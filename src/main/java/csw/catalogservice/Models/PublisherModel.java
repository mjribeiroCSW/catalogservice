package csw.catalogservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "publisher")
public class PublisherModel {

    @Id
    private int id;
}
