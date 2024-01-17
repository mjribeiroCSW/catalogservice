package csw.catalogservice.mappers;

import csw.catalogservice.Models.TagModel;
import csw.catalogservice.dto.TagDto;

public class TagMapper {
    public static TagModel mapDtoToModel(TagDto tagDto) {
        var tagModel = new TagModel();

        tagModel.setName(tagDto.getName());

        return tagModel;
    }

    public static TagDto mapModelToDto(TagModel tagModel) {
        var tagDto = new TagDto();

        tagDto.setId(tagModel.getId());
        tagDto.setName(tagModel.getName());

        return tagDto;
    }
}