package IntegrationTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import csw.catalogservice.CatalogServiceApplication;
import csw.catalogservice.SecurityTestConfig;
import csw.catalogservice.dto.BookDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {CatalogServiceApplication.class, SecurityTestConfig.class})
@AutoConfigureMockMvc
public class BookControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void CreateAndGetBook() throws Exception {
        var bookDtoJson = bookJson();

        var objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        var incomingBook = objectMapper.readValue(bookDtoJson, BookDto.class);

        var postResult = mockMvc.perform(post("/api/catalog/Book")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(bookDtoJson))
                .andExpect(status().isOk())
                .andReturn();

        var createdBookId = postResult.getResponse().getContentAsString();

        var result = mockMvc.perform(get("/api/catalog/{id}", createdBookId))
                .andExpect(status().isOk())
                .andReturn();

        var resultDto = result.getResponse().getContentAsString();
        var resultBook = objectMapper.readValue(resultDto, BookDto.class);

        assertEquals(resultBook.originalTitle, incomingBook.originalTitle);
        assertEquals(resultBook.price, incomingBook.price);
        assertEquals(resultBook.availability, incomingBook.availability);
    }

    private static String bookJson() {
        return "{\"id\":123,\"originalTitle\":\"Pineaple Adventures\",\"isbn\":\"978-1-234-56789-0\",\"releaseDate\":\"2023-01-01T12:00:00Z\",\"editionDate\":\"2023-01-15T12:00:00Z\",\"edition\":\"First Edition\",\"isSeries\":true,\"synopsis\":\"As aventures do Ananas\",\"price\":29.99,\"promotionalPrice\":19.99,\"stockAvailable\":100,\"DateCreated\":\"2023-01-01T00:00:00Z\",\"DateUpdated\":\"2023-01-15T10:30:00Z\",\"availability\":1,\"publisher\":{\"id\":456,\"name\":\"Acme Publishing\"},\"authors\":[{\"id\":1,\"name\":\"John Doe\"},{\"id\":2,\"name\":\"Jane Smith\"}],\"genres\":[1,2],\"formats\":[1,2],\"languages\":[{\"name\":\"English\",\"code\":\"en\"},{\"name\":\"Spanish\",\"code\":\"es\"}],\"tags\":[{\"name\":\"Adventure\"},{\"name\":\"Mystery\"}]}";
    }
}