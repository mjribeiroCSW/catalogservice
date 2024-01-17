package csw.catalogservice.mappers;

import csw.catalogservice.Models.GenreModel;
import csw.catalogservice.dto.enums.GenreDto;

public class GenreMapper {

    public static GenreModel mapDtoToModel(GenreDto genreDto) {
        var GenreModel = new GenreModel();

        GenreModel.setName(genreDto.name());

        return GenreModel;
    }

    public static GenreDto mapModelToDto(GenreModel GenreModel) {
        try
        {
            return GenreDto.valueOf(GenreModel.getName().toUpperCase());
        }
        catch (IllegalArgumentException ex) //excepion que sai se falhar no match do enum
        {
            return GenreDto.UNKNOW;
        }
    }
}