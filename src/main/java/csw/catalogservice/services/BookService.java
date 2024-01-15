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

        var bookModel = BookMapper.mapDtoToModel(book);

        var bookId = 1;

        bookModel.getId();

        // what
        logger.info("Create book success, id:{}.", bookId);
        return bookId;
    }
}