package com.idioms.api.service;

import com.idioms.api.model.Idiom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IdiomServiceTest {

    @Autowired
    private IdiomService idiomService;

    @Test
    void randomIdioms_shouldReturnOnlyGivenFrequency() {
        // Arrange: Testparameter
        int frequency = 5;
        int count = 3;

        // Act: Methode aufrufen
        List<Idiom> idioms = idiomService.getRandomIdioms(frequency, count);

        // Assert: Prüfen, ob die Ergebnisse korrekt sind
        assertNotNull(idioms, "Liste darf nicht null sein");
        assertFalse(idioms.isEmpty(), "Liste darf nicht leer sein");
        assertTrue(idioms.size() <= count, "Liste darf nicht mehr als 'count' Elemente enthalten");
        assertTrue(idioms.stream().allMatch(i -> i.getFrequency() == frequency),
                "Alle Idioms müssen die gewünschte Frequency haben");
    }

    @Test
    void randomIdioms_shouldHandleInvalidFrequency() {
        // Frequenz, die evtl. nicht existiert
        int invalidFrequency = 0;
        int count = 5;

        List<Idiom> idioms = idiomService.getRandomIdioms(invalidFrequency, count);

        // sollte einfach leer zurückgeben, kein Fehler
        assertNotNull(idioms);
    }
}
