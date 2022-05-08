
docker rm $(docker ps --filter status=exited -q)
docker volume rm $(docker volume ls -q)
docker rmi -f $(docker images -aq)
# docker network prune

docker compose build
docker compose up



