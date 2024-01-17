package csw.catalogservice.mappers;

import csw.catalogservice.Models.FormatModel;
import csw.catalogservice.dto.enums.FormatDto;

public class FormatMapper {

    public static FormatModel mapDtoToModel(FormatDto formatDto) {
        var formatModel = new FormatModel();

        formatModel.setName(formatDto.name());

        return formatModel;
    }

    public static FormatDto mapModelToDto(FormatModel formatModel) {
        try
        {
            return FormatDto.valueOf(formatModel.getName().toUpperCase());
        }
        catch (IllegalArgumentException ex) //excepion que sai se falhar no match do enum
        {
            return FormatDto.UNKNOW;
        }
    }
}