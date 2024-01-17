package csw.catalogservice.controllers;

import csw.catalogservice.dto.BookDto;
import csw.catalogservice.services.BookService;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/catalog")
public class CatalogController {

    private final BookService bookService;

    // @Autowired
    public CatalogController(BookService bookService) {
        this.bookService = bookService;
    }

    // hasAuthority for one
    //@PreAuthorize("hasAuthority('read_books')")
    @GetMapping("/GetAllBooks")
    public ResponseEntity<List<String>> getAllBooks(
            @AuthenticationPrincipal OAuth2AuthorizedClient authorizedClient,
            HttpServletRequest request) {

        List<String> creditCards = new ArrayList<String>() {};
        creditCards.add("test");

        if (authorizedClient != null && hasReadBooksScope(authorizedClient))
        {
            return ResponseEntity.ok(creditCards);
        }
        else if (request != null && hasReadBooksScope(request))
        {
            return ResponseEntity.ok(creditCards);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(array = @ArraySchema(schema = @Schema(implementation = BookDto.class)), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @PostMapping("/Book")
    public ResponseEntity<Integer> createBook(
            @RequestBody BookDto bookDto) throws SQLException {
        var result = bookService.CreateBook(bookDto);

        return ResponseEntity.ok(result);
    }

    // hasAnyAuthority for multiple
    // @PreAuthorize("hasAnyAuthority('read_books', 'SCOPE_manage-books')")
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(array = @ArraySchema(schema = @Schema(implementation = BookDto.class)), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(
            @PathVariable int id) {
        try
        {
            var result = bookService.GetBook(id);
            return ResponseEntity.ok(result);
        }
        catch (EntityNotFoundException e)
        {
            return ResponseEntity.notFound().build();
        }
        catch (SQLException e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/Book/{id}")
    public int updateBook(@RequestBody int bookId) {
        return 0;
    }

    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {@Content(array = @ArraySchema(schema = @Schema(implementation = String.class)), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())}),
            @ApiResponse(responseCode = "500", content = {@Content(schema = @Schema())})})
    @DeleteMapping("/Book/{id}")
    public String deleteBook(@PathVariable int id) {
        return null;
    }

    private boolean hasReadBooksScope(
            OAuth2User oauth2User)
    {
        return oauth2User.getAuthorities().stream()
                .anyMatch(authority -> authority.getAuthority().equals("read_books"));
    }

    private boolean hasReadBooksScope(
            OAuth2AuthorizedClient authorizedClient)
    {
        return authorizedClient.getAccessToken().getScopes().contains("read_books");
    }

    private boolean hasReadBooksScope(
            HttpServletRequest request)
    {
        var accessToken = request.getHeader("Authorization");
        if (accessToken != null)
        {
            return accessToken.contains("read_books");
        }
        else
        {
            return false;
        }
    }
}
