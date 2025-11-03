package com.idioms.api.service;

import com.idioms.api.model.Idiom;
import com.idioms.api.repository.IdiomRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdiomService {

    private final IdiomRepository idiomRepo;

    public IdiomService(IdiomRepository idiomRepo) {
        this.idiomRepo = idiomRepo;
    }

    public List<Idiom> findRandomIdioms(int frequency, int count) {
        return idiomRepo.randomIdioms(frequency, count);
    }

    public List<Idiom> searchIdioms(String query) {
        if (query == null || query.trim().length() < 3) {
            throw new IllegalArgumentException("Suchbegriff zu kurz (min. 3 Zeichen).");
        }

        String cleanQuery = query.trim();
        return idiomRepo.search(cleanQuery);
    }
}

