package com.idioms.api.controller;

import com.idioms.api.model.Idiom;
import com.idioms.api.service.IdiomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/idioms")
@Tag(name = "Idioms API", description = "REST-Endpoints zum Abrufen und Suchen von Idioms")
public class IdiomController {

    private final IdiomService idiomService;

    public IdiomController(IdiomService idiomService) {
        this.idiomService = idiomService;
    }

    // Gibt zufällige Idioms zurück
    @GetMapping("/random")
    @Operation(summary = "Zufällige Idioms abrufen")
    public List<Idiom> getRandom(
            @RequestParam(defaultValue = "5") int frequency,
            @RequestParam(defaultValue = "10") int count) {

        // kleine Schutzlogik für API
        if (count > 100) count = 100;
        return idiomService.findRandomIdioms(frequency, count);
    }


    // Sucht Idioms nach Text oder Bedeutung
    @GetMapping("/search")
    public List<Idiom> search(@RequestParam String query) {
        return idiomService.searchIdioms(query);
    }
}

