# Marvel catalog - REST API service
REST API service for managing catalog of superheroes and comics

![Project stage: Development][project-stage-badge: Development]

[project-stage-badge: Development]: https://img.shields.io/badge/Project%20Stage-Development-yellowgreen.svg

## Table of Contents
* [How to run](#how-to-run)
* [API endpoints](#api-endpoints)
* [Database UML Model](#database-uml-model)
* [Technologies and Features used](#technologies-and-features-used)

## How to run
```bash
chmod +x mvnw                     # allow executing maven wrapper
./mvnw clean                      # clean /target (if it's not the first run)
./mvnw package -Dmaven.test.skip  # build .jar (and skip testing)
docker compose up                 # run composition
```

## API endpoints
Postman collection is available for playing with api: [Marvel Catalog.postman_collection.json](docs/Marvel%20Catalog.postman_collection.json)
* Characters controller
    * `GET /v1/public/characters`
        * Gets the list of all heroes from the catalog
    * `GET /v1/public/characters/{heroId}`
        * Gets a hero by the specified `heroId`
    * `GET /v1/public/characters/{heroId}/comics`
        * Gets all comics in which the hero with the specified `heroId` present
    * `POST /v1/public/characters`
        * Posts new hero
    * `PUT /v1/public/characters/{heroId}`
        * Updates the existing hero
    * `PUT /v1/public/characters/{heroId}/comics`
        * Updates comics in which the hero presents
* Comics controller
    * `GET /v1/public/comics`
        * Gets the list of all comics from the catalog
    * `GET /v1/public/comics/{comicId}`
        * Gets the comic by the specified `comicId`
    * `GET /v1/public/comics/{comicId}/characters`
        * Gets all heroes which present in the comic with the specified `comicId`
    * `POST /v1/public/comics`
        * Posts new comic
    * `PUT /v1/public/comics/{comicId}`
        * Updates the existing comic

## Database UML Model
UML/Entities Relationship diagram:
![ER Diagram](docs/ER_Diagram.png)

## Technologies and Features used

![java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![spring](https://img.shields.io/badge/spring%20-%236DB33F.svg?&style=for-the-badge&logo=spring&logoColor=white)
![Spring Boot](https://img.shields.io/static/v1?style=for-the-badge&message=Spring+Boot&color=6DB33F&logo=Spring+Boot&logoColor=FFFFFF&label=)
![Spring Data](https://img.shields.io/static/v1?style=for-the-badge&message=Spring+Data&color=6DB33F&logo=Spring+Data&logoColor=FFFFFF&label=)
![junit](https://img.shields.io/badge/junit-%2343B02A.svg?style=for-the-badge&logo=data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA4AAAAOCAYAAAAfSC3RAAABcWlDQ1BpY2MAACiRdZE9S8NQFIbftkpFKx0UlOKQoYpDi0VBHLUOXYqUWsGqS3KbtEKShpsUKa6Ci0PBQXTxa/Af6Cq4KgiCIoi4+Af8WqTEc5tCi7Qn3JyH9573cO+5gD+tM8PuSQCG6fBsKimt5tek4Dt8iGAEUwjJzLYWMpk0usbPI1VTPMRFr+51HWOgoNoM8PURzzKLO8TzxOktxxK8RzzMSnKB+IQ4xumAxLdCVzx+E1z0+Eswz2UXAb/oKRXbWGljVuIG8SRx1NArrHkecZOQaq4sU47QGoONLFJIQoKCCjahw0Gcskkz6+xLNHxLKJOH0d9CFZwcRZTIGyO1Ql1VyhrpKn06qmLu/+dpazPTXvdQEuh9dd3PcSC4D9Rrrvt76rr1MyDwAlybLX+Z5jT3TXqtpUWPgfAOcHnT0pQD4GoXGH22ZC43pAAtv6YBHxfAYB4Yugf6171ZNfdx/gTktumJ7oDDI2CC6sMbf/dvaAZsdJhFAAAACXBIWXMAAELcAABC3AECnn0dAAACg0lEQVQoU01STUhUYRQ938+b9944MzJoptmMDtIiNKVaRBJFUYvUNkOBRajbNkGbFkEUJELhpqJNlBVTEEQhucgK2hT0Y5EpJjiaZKTQTD8246jv7+u+MaMLH3zvvXvuOfecx/BfTSZbGnXOj3hKtTqel6BPSmNs4lZ9ZPDi5sjtbPLq+Go78y9TyRZNMNapcX5aBPS4Izhszyv2GODobSrB3Ro5XWJ5PcpVfenOPk/e27UNnLEuKfglx7YN42A7ynfugUBxJnF6MD/2g82+TjDNuKyUY8XOt6ZkU1lZI7WcVQqGpYBgbR1mSnX0T76ARyC/RpYykC7NkJ7BGOs2KireS3+nAGfr8rYDLiX0kjBGslPoeZkCzYEmJIJSh8YFlO2C61oMYIclGdFmrwymLg0IBUGESG7YUXw1/n0GX/IZCMZXlLs+NQ5IV6kEgelBgWRgOZ9DczSO5oZ2wDQwY+fQO/wAg5/fIsAlAYlFIcEoggXaMejL8ktEoySZmC0LWvV6VB47jnRY4NDAOeStAgQ5TsACpxgmKIZ/aTrZLKy5Wdg/fyA39Aq/371B1Aij3AzDUbSjIL85T3OKYrAI9KUSEzeDxbtyHIhQBLKiEgVnGfPWwsqekg5nj+SS66aUUoel69aIujjK2jtgZ79BFQrQYnFgUwPujD5EpjAPQ9d9Z6fppMTeqjWZtaa5YDK+by7I5eMtMbj1G5FLxDCm27jyYQD3088hNAkmxJLyvJOLX2ef/v09gGzb/q6hauPMie2R2kWS4wduew65xaEHAmAePilPdaePXrtRNHHVlQsTk8Nbdzc8G60K/QLnpUypkOTC1rgc42A3Ybun0h3Xn6z2/wHzuf4Hs/nm1gAAAABJRU5ErkJggg==)
![maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven)
![postgres](https://img.shields.io/badge/postgres-%23316192.svg?&style=for-the-badge&logo=postgresql&logoColor=white)
![swagger](https://img.shields.io/badge/swagger-%2385EA2D.svg?&style=for-the-badge&logo=swagger&logoColor=white)
![docker](https://img.shields.io/badge/docker-%232496ED.svg?&style=for-the-badge&logo=docker&logoColor=white)
![postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white)

* Spring
    * Spring Boot 2.7.1
    * Spring Data JPA
    * Spring Boot Starter Validation
* JUnit 5
* PostgreSQL 14
* ModelMapper
* Swagger
    * Springdoc
    * Swagger Annotations
* Docker
  * docker-compose (PostgreSQL14 + Spring Boot)
* Postman
* StarUML
