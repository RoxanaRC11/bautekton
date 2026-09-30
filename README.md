# BauteKton

**Full-stack web application for architecture project management**

A complete web platform developed as a client project for an architecture office,
built with Spring Boot, Spring Security, MySQL and Thymeleaf.

🇩🇪 [Deutsche Version](#-deutsch) · 🇬🇧 [English version](#-english)

---

## 🇩🇪 Deutsch

### Über das Projekt

**BauteKton** ist eine Full-Stack-Webanwendung zur Verwaltung von
Architekturprojekten. Sie wurde als Kundenprojekt für ein Architekturbüro
entwickelt und deckt den gesamten Workflow ab: von der Projektverwaltung
über Kundenverwaltung bis hin zu einem dynamischen Blog mit Kommentarfunktion.

### Technologie-Stack

| Bereich | Technologien |
|---------|--------------|
| **Backend** | Java 21, Spring Boot 3.4, Spring MVC, Spring Security, Spring Data JPA |
| **Datenbank** | MySQL 8 mit Hibernate ORM |
| **Frontend** | Thymeleaf, Bootstrap 5, HTML5, CSS3, JavaScript |
| **Testing** | JUnit 5 |
| **Build** | Maven |
| **Tools** | Git, GitHub, Spring Tool Suite |

### Funktionen

- ✅ Rollenbasierte Authentifizierung (ADMIN / USER) mit BCrypt
- ✅ Vollständige CRUD-Funktionalitäten für Projekte, Kunden, Bestellungen und Galerie
- ✅ Dynamisches Blog-System mit Kommentarfunktion
- ✅ Serverseitige Formularvalidierung mit Bean Validation
- ✅ Responsive Design mit Bootstrap 5
- ✅ REST-Endpunkte für asynchrone Anfragen
- ✅ MySQL-Datenbank mit JPA / Hibernate ORM

### Installation

**Voraussetzungen:**
- Java 21 oder höher
- Maven 3.9+
- MySQL 8+

**Schritte:**

1. Repository klonen:
   ```bash
   git clone https://github.com/RoxanaRC11/bautekton.git
   cd bautekton
   ```

2. Datenbank konfigurieren in `src/main/resources/application.properties`.

3. Anwendung starten:
   ```bash
   mvn spring-boot:run
   ```

4. Im Browser öffnen:
   ```
   http://localhost:8087/principal
   ```

### Demo-Zugänge

| Rolle | E-Mail | Passwort |
|-------|--------|----------|
| ADMIN | admin@revilla.com | Admin123 |
| USER | usuario@revilla.com | Usuario123 |

---

## 👩‍💻 Developer

**Roxana Revilla**
*Fachinformatikerin für Anwendungsentwicklung (IHK)*

- GitHub: [@RoxanaRC11](https://github.com/RoxanaRC11)
- Location: Germany
