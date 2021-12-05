package hu.uni.eku.tzs.controller.dto;

import hu.uni.eku.tzs.model.Works;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WorkMapper {
    WorksDto work2WorksDto(Works work);

    Works worksDto2Works(WorksDto dto);
}
