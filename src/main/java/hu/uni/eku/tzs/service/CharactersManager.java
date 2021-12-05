package hu.uni.eku.tzs.service;

import hu.uni.eku.tzs.model.Characters;

import java.util.Collection;

public interface CharactersManager {
    Characters record(Characters chapter); //throws BookAlreadyExistsException;

    //Chapters readByIsbn(String isbn); //throws BookNotFoundException;

    Collection<Characters> readAll();

    Characters modify(Characters chapter);

    void delete(Characters chapters); //throws BookNotFoundException;
}
