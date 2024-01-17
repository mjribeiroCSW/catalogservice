package csw.catalogservice.mappers;

import csw.catalogservice.Models.PublisherModel;
import csw.catalogservice.dto.PublisherDto;

public class PublisherMapper {

    public static PublisherModel mapDtoToModel(PublisherDto publisherDto) {
        var publisherModel = new PublisherModel();

        publisherModel.setName(publisherDto.getName());

        return publisherModel;
    }

    public static PublisherDto mapModelToDto(PublisherModel publisherModel) {
        var publisherDto = new PublisherDto();

        publisherDto.setId(publisherModel.getId());
        publisherDto.setName(publisherModel.getName());

        return publisherDto;
    }
}