package hu.uni.eku.tzs.service;


import hu.uni.eku.tzs.dao.ChapterRepository;
import hu.uni.eku.tzs.dao.WorkRepository;
import hu.uni.eku.tzs.dao.entity.ChapterEntity;
import hu.uni.eku.tzs.model.Chapters;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChaptersManagerImpl implements ChaptersManager {
    private final ChapterRepository chapterRepository;

    private static Chapters convertChapterEntity2Model(ChapterEntity chapterEntity) {
        return new Chapters(
                chapterEntity.getId(),
                chapterEntity.getAct(),
                chapterEntity.getScene(),
                chapterEntity.getDescription(),
                chapterEntity.getWork_id());
    }

    private static ChapterEntity convertChaptersModel2Entity(Chapters chapter) {
        return ChapterEntity.builder()
                .id(chapter.getId())
                .act(chapter.getAct())
                .scene(chapter.getScene())
                .description(chapter.getDescription())
                .work_id(chapter.getWork_id())
                .build();
    }

    @Override
    public Chapters record(Chapters chapter){
       //if (bookRepository.findById(book.getIsbn()).isPresent()) {
         //   throw new BookAlreadyExistsException();
        //}
        ChapterEntity chapterEntity = chapterRepository.save(
                ChapterEntity.builder()
                        .id(chapter.getId())
                        .act(chapter.getAct())
                        .scene(chapter.getScene())
                        .description(chapter.getDescription())
                        .work_id(chapter.getWork_id())
                        .build()
        );
        return convertChapterEntity2Model(chapterEntity);
    }

    @Override
    public Collection<Chapters> readAll() {
        return chapterRepository.findAll().stream().map(ChaptersManagerImpl::convertChapterEntity2Model)
                .collect(Collectors.toList());
    }

    @Override
    public Chapters modify(Chapters chapter) {
        ChapterEntity entity = convertChaptersModel2Entity(chapter);
        return convertChapterEntity2Model(chapterRepository.save(entity));
    }

    @Override
    public void delete(Chapters chapter) {
        chapterRepository.delete(convertChaptersModel2Entity(chapter));

    }


}
