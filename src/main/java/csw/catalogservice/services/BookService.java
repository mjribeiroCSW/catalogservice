package csw.catalogservice.services;

import csw.catalogservice.dto.BookDto;
import csw.catalogservice.mappers.BookMapper;
import csw.catalogservice.repositories.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class BookService
{
    private final BookRepository bookRepository;
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    public BookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    public int CreateBook(BookDto book) throws SQLException {
        logger.info("Create Book started.");

        var bookToSave = BookMapper.mapDtoToModel(book);

        var result = bookRepository.save(bookToSave);

        logger.info("Create Book success, id:{}.", result.getId());
        return result.getId();
    }

    public BookDto GetBook(int id) throws SQLException {
        logger.info("Get Book started.");

        var result = bookRepository.findById(id);

        if (result.isPresent()) {
            var bookDto = BookMapper.mapModelToDto(result.get());

            logger.info("Get Book success, Name:{}.", bookDto.getOriginalTitle());

            return bookDto;
        }
        else
        {
            logger.info("Book not found with ID: {}", id);

            return null;
        }
    }
}