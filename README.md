# Idioms-API

Ein kleines Java-Backend zum Verwalten und Abrufen englischer Idioms.  
Das Projekt ist als Lern- und Portfolio-API entstanden, um eine saubere Spring-Boot-Architektur mit REST-Endpoints, Service-Layer und Datenbankanbindung zu zeigen.

---

## Tech-Stack

- **Java 21**
- **Spring Boot 3.5**
- **Gradle 8**
- **PostgreSQL 15**
- **OpenAPI / Swagger-UI**

---

## Idee

Beim Start lädt die Anwendung einen Datensatz mit mehreren tausend englischen Idioms in eine PostgreSQL-Datenbank.  
Ziel war es, eine einfache, aber stabile API zu bauen, die per Request zufällige oder gezielt gesuchte Idioms ausliefert – z. B. für Lern- oder Sprach-Apps.

---

## Architektur

| Schicht | Aufgabe |
|----------|----------|
| **Controller** | Nimmt HTTP-Requests entgegen und liefert JSON-Responses |
| **Service** | Enthält Geschäftslogik und Validierungen |
| **Repository** | Zugriff auf die Datenbank via JPA |
| **Entity (Idiom)** | Datenmodell für Idioms-Tabelle |

---

## Endpoints

| Methode | Pfad | Beschreibung |
|----------|------|--------------|
| `GET /api/idioms/random` | Liefert zufällige Idioms, optional nach Häufigkeit (`frequency`, `count`) |
| `GET /api/idioms/search` | Sucht Idioms nach Text oder Bedeutung (`query`) |

---

## Beispiel-Request

GET http://localhost:8080/api/idioms/search?query=cat

Antwort:

```json
[
  {
    "id": 42,
    "text": "let the cat out of the bag",
    "meaning": "to reveal a secret",
    "example": "She let the cat out of the bag about the surprise party.",
    "frequency": 5
  }
]
```

---

## Projektstruktur

```
src/
 ├─ main/
 │   ├─ java/com/idioms/api/
 │   │   ├─ controller/IdiomController.java
 │   │   ├─ service/IdiomService.java
 │   │   ├─ repository/IdiomRepository.java
 │   │   └─ model/Idiom.java
 │   └─ resources/
 │       ├─ application.yml
 │       └─ data/ (lokale CSV, nicht im Repo)
 └─ test/
```

---

## Starten

```bash
./gradlew bootRun
```

Swagger-UI ist danach erreichbar unter:  
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## Daten

Die API nutzt eine lokale PostgreSQL-Instanz.  
Der ursprüngliche Datensatz (`idioms.csv`) bleibt **privat** und wird nicht im Repository geteilt.

---

## Autor

**Vladimir Kirizleev**  
Java / Spring Boot Backend-Entwicklung · Datenlogik · API-Design  
[github.com/kirizleev-portfolio](https://github.com/kirizleev-portfolio)

