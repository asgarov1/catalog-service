# Catalog Service

### Before starting:
- create docker network `docker network create catalog-network`
- run postgres db with Docker:
`docker run -d --name polar-postgres --net catalog-network -e
POSTGRES_USER=user -e POSTGRES_PASSWORD=password -e POSTGRES_DB=polardb_catalog
-p 5432:5432 postgres:14.1`
- run [CloudConfigServer](https://github.com/asgarov1/polar-config-server)

### Run the application:
- Build the image:
`
docker build -t catalog-service .
`

After that easiest way is to use [Docker Compose](https://docs.docker.com/compose/install/)
`docker-compose up -d`

Alternatively you could run the docker container manually:
`
docker run --rm -d --name catalog-service --net catalog-network -p 9001:9001 -e SPRING_DATASOURCE_URL=jdbc:postgresql://polar-postgres:5432/polardb_catalog catalog-service
`
