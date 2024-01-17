package csw.catalogservice.mappers;

import csw.catalogservice.Models.AuthorModel;
import csw.catalogservice.dto.AuthorDto;

public class AuthorMapper {

    public static AuthorModel mapDtoToModel(AuthorDto authorDto) {
        var authorModel = new AuthorModel();

        authorModel.setName(authorDto.getName());

        return authorModel;
    }

    public static AuthorDto mapModelToDto(AuthorModel authorModel) {
        var authorDto = new AuthorDto();

        authorDto.setId(authorModel.getId());
        authorDto.setName(authorModel.getName());

        return authorDto;
    }
}