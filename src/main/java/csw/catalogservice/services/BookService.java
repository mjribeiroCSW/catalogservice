package csw.catalogservice.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import csw.catalogservice.dto.BookDto;
import csw.catalogservice.mappers.BookMapper;
import csw.catalogservice.mappers.RabbitContract.CreatedBookV1Mapper;
import csw.catalogservice.repositories.BookRepository;
import org.jobrunr.scheduling.JobScheduler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDateTime;

@Service
public class BookService
{
    @Autowired
    private JobScheduler jobScheduler;

    private final BookRepository bookRepository;

    private final RaabitSenderService sender;
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    public BookService(
            BookRepository bookRepository,
            RaabitSenderService sender)
    {
        this.bookRepository = bookRepository;
        this.sender = sender;
    }

    public int CreateBookWithError(BookDto book) throws SQLException {
        try
        {
            throw new Exception("error saving on DB.");
        }
        catch (Exception ex)
        {
            jobScheduler.schedule(LocalDateTime.now().plusMinutes(1), () -> this.CreateBook(book));
        }

        return 0;
    }

    public int CreateBook(BookDto book) throws Exception
    {
        logger.info("Create Book started.");

        // DTO TO MODEL - SAVE
        var bookToSave = BookMapper.mapDtoToModel(book);
        var result = bookRepository.save(bookToSave);

        // MAP TO RABBIT CONTRACT
        var createdBookV1 = CreatedBookV1Mapper.ModelToContract(result);

        // OBJECT TO STRING
        var jsonData = objectMapper.writeValueAsString(createdBookV1);

        // SEND RABBIT MESSAGE
        sender.run(jsonData);

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