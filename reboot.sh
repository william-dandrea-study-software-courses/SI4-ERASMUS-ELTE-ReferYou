cd authentification-service
mvn clean
cd ..
cd cloud-gateway
mvn clean
cd ..
cd database-models
mvn clean
cd ..
cd distribution-service
mvn clean
cd ..
cd moderation-service
mvn clean
cd ..
cd promotion-service
mvn clean
cd ..
cd service-registry
mvn clean
cd ..
mvn clean

docker rm $(docker ps --filter status=exited -q)
docker volume rm $(docker volume ls -q)
docker rmi -f $(docker images -aq)
# docker network prune

docker compose build
docker compose up



