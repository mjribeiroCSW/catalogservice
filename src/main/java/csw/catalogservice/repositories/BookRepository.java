package csw.catalogservice.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository
{
    public BookRepository()
    {
    }
}

/*
public interface BookRepository extends JpaRepository<BookDto, Integer> {

    BookDto findByIsbn(String isbn);

    BookDto findByOriginalTitle(String originalTitle);
} */