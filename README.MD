# Marvel catalog - REST API service
REST API service for managing catalog of superheroes and comics

## Table of Contents
* [API endpoints](#api-endpoints)
* [Persistence layer details](#persistence-layer-details)
* [Technologies & Features](#technologies-and-features)

---
## API endpoints
All routes are clickable!
* Characters controller
  * [`GET /v1/public/characters`](https://github.com/YawKar/marvel-catalog/blob/1511d84c147d092289ec36b7f5112c259790b76b/src/main/java/com/yawkar/marvelcatalog/controller/CharactersController.java#L31-L50)
    * Gets the list of all heroes from the catalog
  * [`GET /v1/public/characters/{heroId}`](https://github.com/YawKar/marvel-catalog/blob/1511d84c147d092289ec36b7f5112c259790b76b/src/main/java/com/yawkar/marvelcatalog/controller/CharactersController.java#L52-L80)
    * Gets a hero by the specified `heroId`
  * [`GET /v1/public/characters/{heroId}/comics`](https://github.com/YawKar/marvel-catalog/blob/1511d84c147d092289ec36b7f5112c259790b76b/src/main/java/com/yawkar/marvelcatalog/controller/CharactersController.java#L82-L110)
    * Gets all comics in which the hero with the specified `heroId` present
  * [`POST /v1/public/characters`](https://github.com/YawKar/marvel-catalog/blob/1511d84c147d092289ec36b7f5112c259790b76b/src/main/java/com/yawkar/marvelcatalog/controller/CharactersController.java#L112-L132)
    * Posts new hero
  * [`PUT /v1/public/characters`](https://github.com/YawKar/marvel-catalog/blob/1511d84c147d092289ec36b7f5112c259790b76b/src/main/java/com/yawkar/marvelcatalog/controller/CharactersController.java#L134-L161)
    * Updates the existing hero
* Comics controller
  * [`GET /v1/public/comics`](https://github.com/YawKar/marvel-catalog/blob/1511d84c147d092289ec36b7f5112c259790b76b/src/main/java/com/yawkar/marvelcatalog/controller/ComicsController.java#L31-L50)
    * Gets the list of all comics from the catalog
  * [`GET /v1/public/comics/{comicId}`](https://github.com/YawKar/marvel-catalog/blob/1511d84c147d092289ec36b7f5112c259790b76b/src/main/java/com/yawkar/marvelcatalog/controller/ComicsController.java#L52-L80)
    * Gets the comic by the specified `comicId`
  * [`GET /v1/public/comics/{comicId}/characters`](https://github.com/YawKar/marvel-catalog/blob/1511d84c147d092289ec36b7f5112c259790b76b/src/main/java/com/yawkar/marvelcatalog/controller/ComicsController.java#L82-L110)
    * Gets all heroes which present in the comic with the specified `comicId`
  * [`POST /v1/public/comics`](https://github.com/YawKar/marvel-catalog/blob/1511d84c147d092289ec36b7f5112c259790b76b/src/main/java/com/yawkar/marvelcatalog/controller/ComicsController.java#L112-L132)
    * Posts new comic
  * [`PUT /v1/public/comics`](https://github.com/YawKar/marvel-catalog/blob/1511d84c147d092289ec36b7f5112c259790b76b/src/main/java/com/yawkar/marvelcatalog/controller/ComicsController.java#L134-L160)
    * Updates the comic
* Attachments controller
  * [`PUT /v1/public/attach`](https://github.com/YawKar/marvel-catalog/blob/1511d84c147d092289ec36b7f5112c259790b76b/src/main/java/com/yawkar/marvelcatalog/controller/AttachmentsController.java#L28-L50)
    * Adds connections between heroes and comics

---
## Persistence layer details
In total there are 3 main tables in the database:
1. `heroes`
   * Contains `(<PK> id, real_name, alias)`
   * Cascades many-to-many relationship with `comics` via `PERSIST` and `MERGE`
   * Is the owning side of the many-to-many relationship
2. `comics`
   * Contains `(<PK> id, title, executive_editor)`
   * Is the inverse side of the many-to-many relationship
3. `heroes_in_comics`
   * Contains `(hero_id, comic_id)`
   * `<PK>` is the mix of the foreign keys
   * Connects `heroes` entities with `comics` through bidirectional joining

Also, there are 2 auxiliary tables for persisting of `@ElementCollection` fields:
1. `comic_cover_artists`
   * Persists `cover_artists`
2. `hero_superpowers`
   * Persists `superpowers`

---
## Technologies and Features

![java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![spring](https://img.shields.io/badge/spring%20-%236DB33F.svg?&style=for-the-badge&logo=spring&logoColor=white)
![Spring Boot](https://img.shields.io/static/v1?style=for-the-badge&message=Spring+Boot&color=6DB33F&logo=Spring+Boot&logoColor=FFFFFF&label=)
![Spring Data](https://img.shields.io/static/v1?style=for-the-badge&message=Spring+Data&color=6DB33F&logo=Spring+Data&logoColor=FFFFFF&label=)
![maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven)
![postgres](https://img.shields.io/badge/postgres-%23316192.svg?&style=for-the-badge&logo=postgresql&logoColor=white)
![swagger](https://img.shields.io/badge/swagger-%2385EA2D.svg?&style=for-the-badge&logo=swagger&logoColor=white)
![docker](https://img.shields.io/badge/docker-%232496ED.svg?&style=for-the-badge&logo=docker&logoColor=white)

* Spring
  * Spring Boot 2.7.1
  * Spring Data 
* Validation
  * Spring Boot Starter Validation (javax.validation)
* PostgreSQL 14
* ModelMapper
* Swagger
  * Springdoc
  * Swagger Annotations
* Docker