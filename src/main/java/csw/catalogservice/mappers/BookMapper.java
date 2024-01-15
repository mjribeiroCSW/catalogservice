package csw.catalogservice.mappers;

import csw.catalogservice.Models.BookModel;
import csw.catalogservice.dto.BookDto;

import java.sql.SQLException;
import java.util.Optional;

public class BookMapper {

    public static BookModel mapDtoToModel(BookDto bookDto) throws SQLException {
        BookModel bookModel = new BookModel();

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
        bookModel.setDateCreated(bookDto.getDateCreated().orElse(null));
        bookModel.setDateUpdated(bookDto.getDateUpdated().orElse(null));
        /*
        bookModel.setAuthors(bookDto.getAuthors().stream()
                .map(authorDto -> AuthorMapper.mapDtoToModel(authorDto))
                .collect(Collectors.toList()));
        */

        return bookModel;
    }

    public BookDto mapModelToDto(BookModel bookModel) {
        BookDto bookDto = new BookDto();
        bookDto.setId(Optional.of(bookModel.getId()));
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
        bookDto.setDateCreated(Optional.ofNullable(bookModel.getDateCreated()));
        bookDto.setDateUpdated(Optional.ofNullable(bookModel.getDateUpdated()));

        /*
        bookDto.setAuthors(bookModel.getAuthors().stream()
                .map(authorModel -> AuthorMapper.mapModelToDto(authorModel))
                .collect(Collectors.toList()));
        */

        return bookDto;
    }
}