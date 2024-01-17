package csw.catalogservice.dto;

import csw.catalogservice.dto.enums.BookAvailabilityDto;
import csw.catalogservice.dto.enums.FormatDto;
import csw.catalogservice.dto.enums.GenreDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BookDto {
    public int id;

    public String originalTitle;

    public String isbn;

    public LocalDateTime releaseDate;

    public LocalDateTime editionDate;

    public String edition;

    public boolean isSeries;

    public String synopsis;

    public Float price;

    public Float promotionalPrice;

    public int stockAvailable;

    public Instant DateCreated;

    public Instant DateUpdated;

    public BookAvailabilityDto availability;

    public PublisherDto publisher;

    public List<AuthorDto> authors;

    public List<GenreDto> genres;

    public List<FormatDto> formats;

    public List<LanguageDto> languages;

    public List<TagDto> tags;

    public BookDto(
            Integer id,
            String originalTitle,
            String isbn,
            LocalDateTime releaseDate,
            LocalDateTime editionDate,
            String edition,
            boolean isSeries,
            String synopsis,
            Float price,
            Float promotionalPrice,
            int stockAvailable,
            Instant dateCreated,
            Instant dateUpdated,
            BookAvailabilityDto availability,
            PublisherDto publisher,
            List<AuthorDto> authors,
            List<GenreDto> genres,
            List<FormatDto> formats,
            List<LanguageDto> languages,
            List<TagDto> tags) {

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