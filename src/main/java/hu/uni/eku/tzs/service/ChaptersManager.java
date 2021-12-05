package hu.uni.eku.tzs.service;



import hu.uni.eku.tzs.model.Chapters;

import java.util.Collection;

public interface ChaptersManager {
    Chapters record(Chapters chapter); //throws BookAlreadyExistsException;

    //Chapters readByIsbn(String isbn); //throws BookNotFoundException;

    Collection<Chapters> readAll();

    Chapters modify(Chapters chapter);

    void delete(Chapters chapters); //throws BookNotFoundException;
}
