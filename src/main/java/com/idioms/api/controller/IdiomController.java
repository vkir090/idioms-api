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
@Tag(name = "Idioms API", description = "Endpoints zum Abrufen von Idioms")
public class IdiomController {

    private final IdiomService idiomService;

    public IdiomController(IdiomService idiomService) {
        this.idiomService = idiomService;
    }

    @GetMapping("/random")
    @Operation(summary = "Zufällige Idioms abrufen – optional nach Häufigkeit gefiltert")
    public List<Idiom> getRandomIdioms(
            @Parameter(description = "Häufigkeit von 1 bis 5", example = "5")
            @RequestParam(defaultValue = "5") int frequency,

            @Parameter(description = "Anzahl der Idioms", example = "10")
            @RequestParam(defaultValue = "10") int count) {
        return idiomService.getRandomIdioms(frequency, count);
    }


    @GetMapping("/search")
    @Operation(summary = "Idioms nach Text oder Bedeutung suchen")
    public List<Idiom> searchIdioms(
            @Parameter(description = "Suchbegriff", example = "cat")
            @RequestParam String query) {
        return idiomService.searchIdioms(query);
    }
}

