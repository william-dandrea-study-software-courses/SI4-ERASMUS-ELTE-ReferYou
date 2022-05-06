# ReferYou

For launching all the microservices : 
```
docker compose build
docker compose up
```


For launching only one microservice :
> If the microservice is running `docker compose stop <service>`

```
docker compose build <service>
docker compose up <service>
```
**Wait _2 to 3_ minutes**

## How to access to microservices

The micro-services are managed on the port 8080. A gateway-service redirect all
the routes to the good microservices.

#### Promotion routes
- `localhost:8080/promotion` : Test route for the promotion service (_accessing the SponsorController_)

#### Distribution routes
- `localhost:8080/distribution` : Test route for the distribution service (_accessing the distribution-service/PageCOntroller_)

#### Authentification routes


#### Moderation routes
