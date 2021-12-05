package hu.uni.eku.tzs.service;


import hu.uni.eku.tzs.dao.ParagraphRepository;

import hu.uni.eku.tzs.dao.entity.ParagraphEntity;

import hu.uni.eku.tzs.model.Paragraphs;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParagraphsManagerImpl implements ParagraphsManager{
    private final ParagraphRepository paragraphRepository;

    private static Paragraphs convertParagraphEntity2Model(ParagraphEntity paragraphEntity) {
        return new Paragraphs(
                paragraphEntity.getId(),
                paragraphEntity.getParagraph_num(),
                paragraphEntity.getPlain_text(),
                paragraphEntity.getChracater_id(),
                paragraphEntity.getChapter_id());

    }

    private static ParagraphEntity convertParagraphsModel2Entity(Paragraphs paragraph) {
        return ParagraphEntity.builder()
                .id(paragraph.getId())
                .paragraph_num(paragraph.getParagraph_num())
                .plain_text(paragraph.getPlain_text())
                .chracater_id(paragraph.getChracater_id())
                .chapter_id(paragraph.getChapter_id())
                .build();
    }

    @Override
    public Paragraphs record(Paragraphs paragraph){
        //if (bookRepository.findById(book.getIsbn()).isPresent()) {
        //   throw new BookAlreadyExistsException();
        //}
        ParagraphEntity paragraphEntity = paragraphRepository.save(
                ParagraphEntity.builder()
                        .id(paragraph.getId())
                        .paragraph_num(paragraph.getParagraph_num())
                        .plain_text(paragraph.getPlain_text())
                        .chracater_id(paragraph.getChracater_id())
                        .chapter_id(paragraph.getChapter_id())
                        .build()
        );
        return convertParagraphEntity2Model(paragraphEntity);
    }

    @Override
    public Collection<Paragraphs> readAll() {
        return paragraphRepository.findAll().stream().map(ParagraphsManagerImpl::convertParagraphEntity2Model)
                .collect(Collectors.toList());
    }

    @Override
    public Paragraphs modify(Paragraphs paragraph) {
        ParagraphEntity entity = convertParagraphsModel2Entity(paragraph);
        return convertParagraphEntity2Model(paragraphRepository.save(entity));
    }

    @Override
    public void delete(Paragraphs paragraph) {
        paragraphRepository.delete(convertParagraphsModel2Entity(paragraph));

    }
}
