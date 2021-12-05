package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.model.Works;

import java.util.Collection;

public interface WorksManager {
    Works record(Works chapter); //throws BookAlreadyExistsException;

    //Chapters readByIsbn(String isbn); //throws BookNotFoundException;

    Collection<Works> readAll();

    Works modify(Works chapter);

    void delete(Works chapters); //throws BookNotFoundException;
}
