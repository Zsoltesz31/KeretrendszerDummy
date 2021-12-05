package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.dao.WorkRepository;
import hu.uni.eku.tzs.dao.entity.WorkEntity;
import hu.uni.eku.tzs.model.Works;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WorksManagerImpl implements WorksManager{
    private final WorkRepository workRepository;

    private static Works convertWorkEntity2Model(WorkEntity workEntity) {
        return new Works(
                workEntity.getId(),
                workEntity.getTitle(),
                workEntity.getGenre_type(),
                workEntity.getDate(),
                workEntity.getLong_title());

    }

    private static WorkEntity convertWorksModel2Entity(Works work) {
        return WorkEntity.builder()
                .id(work.getId())
                .title(work.getTitle())
                .genre_type(work.getGenre_type())
                .date(work.getDate())
                .long_title(work.getLong_title())
                .build();
    }

    @Override
    public Works record(Works work){
        //if (bookRepository.findById(book.getIsbn()).isPresent()) {
        //   throw new BookAlreadyExistsException();
        //}
        WorkEntity workEntity = workRepository.save(
                WorkEntity.builder()
                        .id(work.getId())
                        .title(work.getTitle())
                        .genre_type(work.getGenre_type())
                        .date(work.getDate())
                        .long_title(work.getLong_title())
                        .build()
        );
        return convertWorkEntity2Model(workEntity);
    }

    @Override
    public Collection<Works> readAll() {
        return workRepository.findAll().stream().map(WorksManagerImpl::convertWorkEntity2Model)
                .collect(Collectors.toList());
    }

    @Override
    public Works modify(Works work) {
        WorkEntity entity = convertWorksModel2Entity(work);
        return convertWorkEntity2Model(workRepository.save(entity));
    }

    @Override
    public void delete(Works work) {
        workRepository.delete(convertWorksModel2Entity(work));

    }
}
