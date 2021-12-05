package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.model.Paragraphs;

import java.util.Collection;

public interface ParagraphsManager {
    Paragraphs record(Paragraphs paragraph); //throws BookAlreadyExistsException;

    //Chapters readByIsbn(String isbn); //throws BookNotFoundException;

    Collection<Paragraphs> readAll();

    Paragraphs modify(Paragraphs paragraph);

    void delete(Paragraphs chapters); //throws BookNotFoundException;
}
