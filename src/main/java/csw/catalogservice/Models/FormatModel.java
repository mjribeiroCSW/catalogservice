package csw.catalogservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "format")
public class FormatModel {

    @Id
    private int id;
}