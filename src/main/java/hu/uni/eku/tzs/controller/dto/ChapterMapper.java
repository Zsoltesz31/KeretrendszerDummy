package hu.uni.eku.tzs.controller.dto;

import hu.uni.eku.tzs.model.Chapters;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {WorkMapper.class})
public interface ChapterMapper {
    ChapterDto chapters2ChapterDto(Chapters chapter);

    Chapters chapterDto2chapters(ChapterDto dto);
}
