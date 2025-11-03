package com.idioms.api.repository;

import com.idioms.api.model.Idiom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IdiomRepository extends JpaRepository<Idiom, Long> {
    // Volltextsuche (case-insensitive)
    @Query("SELECT i FROM Idiom i WHERE LOWER(i.text) LIKE LOWER(CONCAT('%', :query, '%')) " +
            "OR LOWER(i.meaning) LIKE LOWER(CONCAT('%', :query, '%')) " +
            "OR LOWER(i.example) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Idiom> search(String query);

    // Zufällige Idioms (nach Frequency)
    @Query(value = "SELECT * FROM idioms WHERE frequency=:frequency ORDER BY RANDOM() LIMIT :count", nativeQuery = true)
    List<Idiom> randomIdioms(@Param("frequency") int frequency, @Param("count") int count);
}