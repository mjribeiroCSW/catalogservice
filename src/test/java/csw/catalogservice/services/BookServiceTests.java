package csw.catalogservice.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import csw.catalogservice.Models.BookModel;
import csw.catalogservice.dto.*;
import csw.catalogservice.dto.enums.BookAvailabilityDto;
import csw.catalogservice.dto.enums.FormatDto;
import csw.catalogservice.dto.enums.GenreDto;
import csw.catalogservice.repositories.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.*;
import java.util.Arrays;
import java.util.Optional;

import java.sql.SQLException;

@SpringBootTest
public class BookServiceTests {

    @Mock
    private BookRepository bookRepository;

    private BookService bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bookService = new BookService(bookRepository);
    }

    @Test
    public void CreateBook_validCreate_returnsId() throws SQLException {
        // Arrange
        var bookDto = this.createMockBookDto();
        var bookModel = new BookModel();
        bookModel.setId(10);
        when(bookRepository.save(any(BookModel.class))).thenReturn(bookModel);

        // Act
        int createdBookId = bookService.CreateBook(bookDto);

        // Assert
        assertEquals(10, createdBookId);
        verify(bookRepository, times(1)).save(any(BookModel.class));
    }

    /*
    @Test
    public void GetBook_validCreate_returnsId() throws SQLException {
        // Arrange
        int bookId = 1;
        BookModel bookModel = new BookModel();
        bookModel.setId(bookId);
        bookModel.setAvailability(BookAvailabilityModel.AVAILABLE);

        Optional<BookModel> bookModelOptional = Optional.of(bookModel);
        when(bookRepository.findById(bookId)).thenReturn(bookModelOptional);

        // Act
        var result = bookService.GetBook(bookId);

        // Assert
        assertNotNull(result);
        verify(bookRepository, times(1)).findById(bookId);
    } */

    @Test
    public void GetBook_validGet_returnsId() throws SQLException {
        // Arrange
        int bookId = 1;
        when(bookRepository.findById(bookId)).thenReturn(Optional.empty());

        // Act
        var result = bookService.GetBook(bookId);

        // Assert
        assertNull(result);
        verify(bookRepository, times(1)).findById(bookId);
    }

    private BookDto createMockBookDto() {
        return new BookDto(
                1,
                "Mock Title",
                "123-456-789",
                LocalDateTime.now(),
                LocalDateTime.now(),
                "1st Edition",
                false,
                "Mock Synopsis",
                10.0f,
                8.0f,
                100,
                Instant.now(),
                Instant.now(),
                BookAvailabilityDto.AVAILABLE,
                createMockPublisherDto(),
                Arrays.asList(createMockAuthorDto()),
                Arrays.asList(createMockGenreDto()),
                Arrays.asList(createMockFormatDto()),
                Arrays.asList(createMockLanguageDto()),
                Arrays.asList(createMockTagDto())
        );
    }

    private TagDto createMockTagDto() {
        var tag = new TagDto();

        tag.setName("XMAS EVENT 2024");

        return tag;
    }

    private LanguageDto createMockLanguageDto() {
        var language = new LanguageDto();

        language.setCode("PT");
        language.setName("Portugal Caralho");

        return language;
    }

    private FormatDto createMockFormatDto() {
        return FormatDto.DIGITAL;
    }

    private GenreDto createMockGenreDto() {
        return GenreDto.ACTION;
    }

    private AuthorDto createMockAuthorDto() {
        var author = new AuthorDto();

        author.setName("Geremias");
        author.setId(1);

        return author;
    }

    private PublisherDto createMockPublisherDto() {
        var publisher = new PublisherDto();

        publisher.setName("Geremias");
        publisher.setId(1);

        return publisher;
    }
}