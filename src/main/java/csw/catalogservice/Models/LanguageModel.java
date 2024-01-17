package csw.catalogservice.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "language")
public class LanguageModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    @Size(max = 255)
    private String name;

    @Column(name = "code", nullable = false)
    @Size(max = 255)
    private String code;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "languages", cascade = CascadeType.ALL)
    List<BookModel> books;
}
