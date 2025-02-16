## Steps to run the application

1. Run Docker and then execute the docker-compose file in [infra.yml](deployment%2Finfra.yml) to spin up 2 postgres db
2. Run the springboot application :- `./gradlew bootrun`
3. Access the end-points from postman (import [api-endpoints.postman_collection.json](postman%2Fapi-endpoints.postman_collection.json))

#### About the application:-  

##### This springboot application is connected to 2 different databases namely primary and secondary and there are 2 api endpoints which perfoms 2 post operations in different tables belonging to different database

1. Setup your datasources using docker (Run 2 different db)
2. Update application.yml to connect to both the databases
3. Define your entities and repositories class in separate packages
4. 