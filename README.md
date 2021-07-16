This is a Simple Spring Boot App that will be containerized
along with two DBs (and one in memory DB) to choose from 
(H2, Postgres & MySQL). Based on Spring Profile a specific 
DB will be chosen.

## Spring Profiles

To run the App with a specific profile an additional run parameter
is required, the `-Dspring-boot.run.profiles=h2`. The ***web*** module
holds the spring runner.

E.g.:
```
mvn spring-boot:run -f ./web/pom.xml -Dspring-boot.run.profiles=h2
```

There are three available profile:
1. `h2` - in memory DB, the default profile if none provided.
1. `postgres` - a containerized Postgres DB.
1. `mysql` - a containerized MySQL DB.
One of these profiles is hardcoded into `docker-compose.yml` file.

## Logging

This application uses a Logback XML file to configure logging levels.
By default, logging level is set to `INFO` in a production code and to
`ERROR` in a test code. To change it use a java command line parameter
`-Dlogging.level=INFO` (or for a test code `-Dlogging.test.level=INFO`)
while running `java` command.

## Docker containers (databases)

To run both containerized databases run the following command 
in the same location as the `docker-compose.yml` file `docker-compose up`.
Run the following command to clean everything up `docker-compose down`.
Both databases will be started regardless of Spring profile. This is a pet project,
so I am ok with that.

A chosen Spring profile is hardcoded into this `docker-compose.yml` file. By 
default, it's set to `postgres` Spring profile. Also `logging.level` is hardcoded
into `docker-compose.yml` file to the `INFO` value.

These commands can be merged into one command for ease of use. It is important
to recompile the Spring Boot App with `mvn clean install` so that updated Jar 
file will be picked up by `docker-compose` tool.
```
docker-compose down && mvn clean install && docker-compose up
```

## Internal (localhost) links

1. Local [OpenAPI Specification 3.0](http://localhost:8080/api/swagger-ui/).
2. Local [H2 console](http://localhost:8080/api/h2-console) (only if 
   `h2` or `default` spring profile is active).
3. Local [Redis GUI](http://localhost:8081). It logs automatically into Redis.
4. Local [PhpMyAdmin](http://localhost:8082) which is configured to allow connection only into MySQL database (not Postgres). User and password can be taken from `docker-compose.yml` file (very secure place to store credentials).
5. Local [PgAdmin](http://localhost:8083). Password to this tool can be found in `docker-compose.yml` file. From there, a connection to Postgres database can be established. Again, use the `docker-compose.yml` file to get Postgres user and password.
