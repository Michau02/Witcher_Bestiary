# Project description

A fan-made web application inspired by The Witcher III: Wild Hunt,
designed to organize and present key elements of the game such as
alchemy, crafting, and monsters. Users can browse in-game content,
explore lore, and personalize their experience by saving favorite
recipes or entries. The project is developed mainly in Java and aims
to combine functionality with an engaging interface true to the
spirit of the Witcher universe.

# Functional requirements

### User authentication

- Register/Login/Logout
- Password encryption

### Alchemy section

- List of potions/elixirs/oils/decoctions
- Every item should show its ingredients, requirements and effects

### Crafting section

- List of gear
- Recipe details and requirements (lvl) with effects

### Bestiary

- Monster list with details:
    - health
    - strengths
    - weaknesses (oils, signs, etc.)
    - battle tactics
    - etc.

### My recipes

- It should be available only when user is logged in
- Adding or removing recipes or monsters to personal favorites so they can be accessed faster

### Search functionality

- Input field to search/filter on every page (containing some kind of list)

### Music section

- Soundtrack download site
- Background music plays quietly on load

### Lore chronicles

- Page with history of Witcher universe (factions, kings, etc.)

### Theme switching

- Light/Dark mode

# Non functional requirements

### User-friendly interface

- Clean UI
- intuitive layout

### Security

- Input validation
- Password encryption
- Protection against SQL injection

### Code quality

- Layered architecture
- Following SOLID rules

### Performance

- Pagination in case of large datasets
- Fast responses
- Caching (maybe)

### Error handling

- Custom 404 and 500 error code pages
- Validations with user friendly messages

### Background music user experience

- Low volume by default
- Possibility to mute/pause/increase volume of music on site

### Technologies

- Docker
- Java, Spring Boot
- JavaScript, HTML, CSS, Thymeleaf
- PostgreSQL
