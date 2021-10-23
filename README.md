# MS-SP-SpringMySQLDBService
Spring boot application uses My SQL DB

# Create docker image
mvn clean install -U
docker build . -t users-mysql

# Start container with the latest image
docker run -p 8086:8086 --name users-mysql --link mysql-standalone:mysql -d users-mysql

# list all containers
docker container ls --all

# create db container with database test, user - sa and password - password
docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=test -e MYSQL_USER=sa -e MYSQL_PASSWORD=password -d mysql:latest

# remove all the un-used images
docker image prune --all