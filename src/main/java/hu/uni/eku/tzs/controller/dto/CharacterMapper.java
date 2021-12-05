package hu.uni.eku.tzs.controller.dto;

import hu.uni.eku.tzs.model.Characters;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
    CharactersDto character2CharactersDto(Character chr);

    Characters CharactersDto2characters(CharactersDto dto);
}
