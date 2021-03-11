This is a Simple Spring Boot App that will be containerized
along with three DB to choose from (H2, Postgres & MySQL).
Based on Spring Profile a specific DB is chosen.

## Spring Profiles

To run App with a specific profile an additional run parameter
is required, the `-Dspring-boot.run.profiles=h2`. 

E.g.:
```
mvn spring-boot:run -f ./web/pom.xml -Dspring-boot.run.profiles=h2
```

There are three available profile:
1. `h2` - in memory DB, the default profile if none provided.
1. `postgres` - a containerized Postgres DB.
1. `mysql` - a containerized MySQL DB (to be implemented).

## Docker containers (databases)

To run both containerized databases run the following command 
in the same location as the `docker-compose.yml` file `docker-compose up`.
The following command to clean everything up `docker-compose down`.
These commands can be merge into one command for ease of use:
```
docker-compose down && docker-compose up
```
