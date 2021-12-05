package hu.uni.eku.tzs.controller.dto;

import hu.uni.eku.tzs.model.Paragraphs;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses={CharacterMapper.class,ChapterMapper.class})
public interface ParagraphMapper {
    ParagraphsDto paragraphs2paragraphDto(Paragraphs paragraph);

    Paragraphs paragraphDto2paragraphs(ParagraphsDto dto);

}
