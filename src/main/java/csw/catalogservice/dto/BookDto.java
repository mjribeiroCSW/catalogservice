package csw.catalogservice.dto;

import csw.catalogservice.dto.enums.BookAvailabilityDto;
import csw.catalogservice.dto.enums.FormatDto;
import csw.catalogservice.dto.enums.GenreDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class BookDto {
    public Optional<Integer> id = Optional.empty();

    public String originalTitle;

    public String isbn;

    public ZonedDateTime releaseDate;

    public ZonedDateTime editionDate;

    public String edition;

    public boolean isSeries;

    public String synopsis;

    public Float price;

    public Float promotionalPrice;

    public int stockAvailable;

    public Optional<Instant> DateCreated = Optional.empty();

    public Optional<Instant> DateUpdated = Optional.empty();

    public BookAvailabilityDto availability;

    public PublisherDto publisher;

    public List<AuthorDto> authors;

    public List<GenreDto> genres;

    public List<FormatDto> formats;

    public List<LanguageDto> languages;

    public List<String> tags;

    public BookDto(
            Optional<Integer> id,
            String originalTitle,
            String isbn,
            ZonedDateTime releaseDate,
            ZonedDateTime editionDate,
            String edition,
            boolean isSeries,
            String synopsis,
            Float price,
            Float promotionalPrice,
            int stockAvailable,
            Optional<Instant> dateCreated,
            Optional<Instant> dateUpdated,
            BookAvailabilityDto availability,
            PublisherDto publisher,
            List<AuthorDto> authors,
            List<GenreDto> genres,
            List<FormatDto> formats,
            List<LanguageDto> languages,
            List<String> tags) {

        this.id = id;
        this.originalTitle = originalTitle;
        this.isbn = isbn;
        this.releaseDate = releaseDate;
        this.editionDate = editionDate;
        this.edition = edition;
        this.isSeries = isSeries;
        this.synopsis = synopsis;
        this.price = price;
        this.promotionalPrice = promotionalPrice;
        this.stockAvailable = stockAvailable;
        this.DateCreated = dateCreated;
        this.DateUpdated = dateUpdated;
        this.availability = availability;
        this.publisher = publisher;
        this.authors = authors;
        this.genres = genres;
        this.formats = formats;
        this.languages = languages;
        this.tags = tags;
    }
}