package csw.catalogservice.Models;

import csw.catalogservice.Models.enums.BookAvailabilityModel;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
public class BookModel {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Setter(AccessLevel.PROTECTED)
    private int id;

    @Column(name = "original_title", nullable = false)
    private String originalTitle;

    @Column(name = "isbn", nullable = true)
    private String isbn;

    @Column(name = "release_date", nullable = true)
    private ZonedDateTime releaseDate;

    @Column(name = "edition_date", nullable = true)
    private ZonedDateTime editionDate;

    @Column(name = "edition", nullable = true)
    private String edition;

    @Column(name = "series", nullable = true)
    private boolean isSeries;

    @Column(name = "synopsis", nullable = true)
    private String synopsis;

    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "promotional_price", nullable = true)
    private Float promotionalPrice;

    @Column(name = "stock_available", nullable = false)
    private int stockAvailable;

    @Column(name = "date_created", nullable = false)
    private Instant dateCreated;

    @Column(name = "date_updated", nullable = true)
    private Instant dateUpdated;

    @Enumerated(EnumType.ORDINAL)
    private BookAvailabilityModel availability;

    @ManyToOne
    private PublisherModel publisher;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "author", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<AuthorModel> authors;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "genre", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<GenreModel> genres;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "format", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "format_id"))
    private List<FormatModel> formats;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "language", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "language_id"))
    private List<LanguageModel> languages;

    @ElementCollection
    private List<String> tags;
}