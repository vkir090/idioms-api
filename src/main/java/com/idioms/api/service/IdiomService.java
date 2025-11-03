package com.idioms.api.service;

import com.idioms.api.model.Idiom;
import com.idioms.api.repository.IdiomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdiomService {

    private final IdiomRepository idiomRepository;

    public IdiomService(IdiomRepository idiomRepository) {
        this.idiomRepository = idiomRepository;
    }

    public List<Idiom> getRandomIdioms(int frequency, int count) {
        return idiomRepository.randomIdioms(frequency, count);
    }

    public List<Idiom> searchIdioms(String query) {
        if (query == null || query.trim().length() < 3) {
            throw new IllegalArgumentException("Suchbegriff muss mindestens 3 Buchstaben enthalten.");
        }
        return idiomRepository.search(query.trim());
    }
}

