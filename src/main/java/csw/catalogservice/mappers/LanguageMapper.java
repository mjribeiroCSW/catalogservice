package csw.catalogservice.mappers;

import csw.catalogservice.Models.LanguageModel;
import csw.catalogservice.dto.LanguageDto;

public class LanguageMapper {

    public static LanguageModel mapDtoToModel(LanguageDto languageDto) {
        var languageModel = new LanguageModel();

        languageModel.setName(languageDto.getName());
        languageModel.setCode(languageDto.getCode());
        return languageModel;
    }

    public static LanguageDto mapModelToDto(LanguageModel languageModel) {
        var languageDto = new LanguageDto();

        languageDto.setId(languageModel.getId());
        languageDto.setName(languageModel.getName());
        languageDto.setCode(languageModel.getCode());

        return languageDto;
    }
}