package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.CharacterRepository;
import hu.uni.eku.tzs.dao.WorkRepository;
import hu.uni.eku.tzs.dao.entity.CharacterEntity;
import hu.uni.eku.tzs.model.Characters;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CharactersManagerImpl implements CharactersManager {
    private final CharacterRepository characterRepository;

    private static Characters convertCharactersEntity2Model(CharacterEntity characterEntity) {
        return new Characters(
                characterEntity.getId(),
                characterEntity.getDescription(),
                characterEntity.getChar_name(),
                characterEntity.getAbbrev());
    }

    private static CharacterEntity convertCharactersModel2Entity(Characters character) {
        return CharacterEntity.builder()
                .id(character.getId())
                .char_name(character.getChar_name())
                .abbrev(character.getAbbrev())
                .description(character.getDescription())
                .build();
    }

    @Override
    public Characters record(Characters character){
        //if (bookRepository.findById(book.getIsbn()).isPresent()) {
        //   throw new BookAlreadyExistsException();
        //}
        CharacterEntity characterEntity = characterRepository.save(
                CharacterEntity.builder()
                        .id(character.getId())
                        .char_name(character.getChar_name())
                        .abbrev(character.getAbbrev())
                        .description(character.getDescription())
                        .build()
        );
        return convertCharactersEntity2Model(characterEntity);
    }

    @Override
    public Collection<Characters> readAll() {
        return characterRepository.findAll().stream().map(CharactersManagerImpl::convertCharactersEntity2Model)
                .collect(Collectors.toList());
    }

    @Override
    public Characters modify(Characters character) {
        CharacterEntity entity = convertCharactersModel2Entity(character);
        return convertCharactersEntity2Model(characterRepository.save(entity));
    }

    @Override
    public void delete(Characters character) {
        characterRepository.delete(convertCharactersModel2Entity(character));

    }

}
