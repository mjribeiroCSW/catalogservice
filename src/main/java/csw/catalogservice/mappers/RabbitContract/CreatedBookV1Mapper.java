package csw.catalogservice.mappers.RabbitContract;

import com.catalog.contracts.books.dto.CreatedBookV1;

import csw.catalogservice.Models.BookModel;

public class CreatedBookV1Mapper
{
    public static CreatedBookV1 ModelToContract(BookModel bookModel) {
        var createdBookV1 = new CreatedBookV1();

        createdBookV1.setAuthor("Pirilampu");
        createdBookV1.setCreatedBookName(bookModel.getOriginalTitle());
        createdBookV1.setAvailableStock(bookModel.getStockAvailable());

        return createdBookV1;
    }
}