package csw.catalogservice.Models;

import csw.catalogservice.Models.enums.BookAvailabilityModel;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
public class BookModel {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "original_title", nullable = false)
    private String originalTitle;

    @Column(name = "isbn", nullable = true)
    private String isbn;

    @Column(name = "release_date", nullable = true)
    private LocalDateTime releaseDate;

    @Column(name = "edition_date", nullable = true)
    private LocalDateTime editionDate;

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
    @Column(name = "availability", columnDefinition = "integer")
    private BookAvailabilityModel availability;

    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "publisher_id")
    private PublisherModel publisher;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<AuthorModel> authors;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "book_genre", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<GenreModel> genres;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "book_format", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "format_id"))
    private List<FormatModel> formats;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "book_language", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "language_id"))
    private List<LanguageModel> languages;

    @OneToMany(mappedBy = "book", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<TagModel> tags = new ArrayList<TagModel>();

    public void addTag(TagModel tag) {
        tags.add(tag);
        tag.setBook(this);
    }
}