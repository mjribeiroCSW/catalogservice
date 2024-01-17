package csw.catalogservice.mappers;

import csw.catalogservice.Models.BookModel;
import csw.catalogservice.Models.enums.BookAvailabilityModel;
import csw.catalogservice.dto.BookDto;
import csw.catalogservice.dto.enums.BookAvailabilityDto;
import org.hibernate.MappingException;

import java.util.Optional;
import java.util.stream.Collectors;

public class BookMapper {
    public static BookModel mapDtoToModel(BookDto bookDto) throws MappingException {
        var bookModel = new BookModel();

        bookModel.setOriginalTitle(bookDto.getOriginalTitle());
        bookModel.setIsbn(bookDto.getIsbn());
        bookModel.setReleaseDate(bookDto.getReleaseDate());
        bookModel.setEditionDate(bookDto.getEditionDate());
        bookModel.setEdition(bookDto.getEdition());
        bookModel.setSeries(bookDto.isSeries());
        bookModel.setSynopsis(bookDto.getSynopsis());
        bookModel.setPrice(bookDto.getPrice());
        bookModel.setPromotionalPrice(bookDto.getPromotionalPrice());
        bookModel.setStockAvailable(bookDto.getStockAvailable());
        bookModel.setDateCreated(bookDto.getDateCreated());
        bookModel.setDateUpdated(bookDto.getDateUpdated());
        bookModel.setAvailability(mapDtoToModel(bookDto.getAvailability()));

        bookModel.setAuthors(bookDto.getAuthors().stream()
                .map(AuthorMapper::mapDtoToModel)
                .collect(Collectors.toList()));

        bookModel.setFormats(bookDto.getFormats().stream()
                .map(FormatMapper::mapDtoToModel)
                .collect(Collectors.toList()));

        bookModel.setGenres(bookDto.getGenres().stream()
                .map(GenreMapper::mapDtoToModel)
                .collect(Collectors.toList()));

        if (bookDto.getLanguages() != null) {
            bookModel.setLanguages(bookDto.getLanguages().stream()
                    .map(LanguageMapper::mapDtoToModel)
                    .collect(Collectors.toList()));
        }

        if (bookDto.getTags() != null) {
            bookDto.getTags().stream()
                    .map(TagMapper::mapDtoToModel)
                    .forEach(bookModel::addTag);
        }

        if (bookDto.getPublisher() != null) {
            bookModel.setPublisher(PublisherMapper.mapDtoToModel(bookDto.getPublisher()));
        }

        return bookModel;
    }

    public static BookDto mapModelToDto(BookModel bookModel) throws MappingException {
        BookDto bookDto = new BookDto();
        bookDto.setId(bookModel.getId());
        bookDto.setOriginalTitle(bookModel.getOriginalTitle());
        bookDto.setIsbn(bookModel.getIsbn());
        bookDto.setReleaseDate(bookModel.getReleaseDate());
        bookDto.setEditionDate(bookModel.getEditionDate());
        bookDto.setEdition(bookModel.getEdition());
        bookDto.setSeries(bookModel.isSeries());
        bookDto.setSynopsis(bookModel.getSynopsis());
        bookDto.setPrice(bookModel.getPrice());
        bookDto.setPromotionalPrice(bookModel.getPromotionalPrice());
        bookDto.setStockAvailable(bookModel.getStockAvailable());
        bookDto.setDateCreated(bookModel.getDateCreated());
        bookDto.setDateUpdated(bookModel.getDateUpdated());
        bookDto.setAvailability(mapModelToDto(bookModel.getAvailability()));

        bookDto.setAuthors(bookModel.getAuthors().stream()
                .map(AuthorMapper::mapModelToDto)
                .collect(Collectors.toList()));

        bookDto.setFormats(bookModel.getFormats().stream()
                .map(FormatMapper::mapModelToDto)
                .collect(Collectors.toList()));

        bookDto.setGenres(bookModel.getGenres().stream()
                .map(GenreMapper::mapModelToDto)
                .collect(Collectors.toList()));

        bookDto.setLanguages(bookModel.getLanguages().stream()
                .map(LanguageMapper::mapModelToDto)
                .collect(Collectors.toList()));

        bookDto.setTags(bookModel.getTags().stream()
                .map(TagMapper::mapModelToDto)
                .collect(Collectors.toList()));

        if (bookModel.getPublisher() != null) {
            bookDto.setPublisher(PublisherMapper.mapModelToDto(bookModel.getPublisher()));
        }

        return bookDto;
    }

    private static BookAvailabilityModel mapDtoToModel(BookAvailabilityDto dto) {
        return BookAvailabilityModel.values()[dto.getValue()];
    }

    private static BookAvailabilityDto mapModelToDto(BookAvailabilityModel model) {
        return BookAvailabilityDto.values()[model.ordinal()];
    }
}