# Microservices Project - Grupo 09

This project consists of a microservices architecture with three main services and a MySQL database, all containerized using Docker.

## Project Structure

- **MSEmployee**: Manages employee data (Port: 8080)
- **MSResident**: Manages resident data (Port: 8081)
- **MSReservation**: Manages reservation data (Port: 8082)
- **MySQL**: Database server with separate databases for each service (Port: 3306)

## Prerequisites

- [Docker](https://docs.docker.com/get-docker/) (version 20.10 or higher)
- [Docker Compose](https://docs.docker.com/compose/install/) (version 1.29 or higher)
- Git (optional, for cloning the repository)

## Getting Started

### 1. Clone the Repository (If not already done)

```bash
git clone <repository-url>
cd grupo-09
```

### 2. Set Environment Variables

Create a `.env` file in the root directory with the following content:

```
DB_PASSWORD=your_secure_password
```

Replace `your_secure_password` with the password of your MySQL root user.

### 3. Build and Start the Services

```bash
docker-compose up -d
```

This command will:
- Build the Docker images for all services
- Create and start the containers
- Set up the network and volumes
- Configure the MySQL database with the required databases

### 4. Verify the Services

You can check if all services are running with:

```bash
docker-compose ps
```

### 5. Access the Services

- **MSEmployee API**: http://localhost:8080
- **MSResident API**: http://localhost:8081
- **MSReservation API**: http://localhost:8082

## Stopping the Services

To stop and remove the containers, networks, and volumes:

```bash
docker-compose down
```

To stop without removing the containers:

```bash
docker-compose stop
```

## Development

### Running Individual Services

You can build and run individual services using:

```bash
docker-compose up -d <service-name>
```

For example, to run only the MySQL service:

```bash
docker-compose up -d mysql
```

### Viewing Logs

To view logs from all services:

```bash
docker-compose logs
```

To view logs from a specific service:

```bash
docker-compose logs <service-name>
```

### Database Access

You can connect to the MySQL database using a MySQL client with:

- **Host**: localhost
- **Port**: 3306
- **Username**: root
- **Password**: (the password you set in the .env file)

Available databases:
- employeedb
- residentdb
- reservationdb

## Troubleshooting

### Service Not Starting

If a service fails to start, check the logs for that specific service:

```bash
docker-compose logs <service-name>
```

### Database Connection Issues

If the microservices cannot connect to the database:

1. Ensure the MySQL service is running:
   ```bash
   docker-compose ps mysql
   ```

2. Check the MySQL logs:
   ```bash
   docker-compose logs mysql
   ```

3. Verify the environment variables in the docker-compose.yml file match the application.properties in each microservice.

### Rebuilding Services

If you make changes to a service, you need to rebuild it:

```bash
docker-compose build <service-name>
docker-compose up -d <service-name>
```

## Project Details

This project is a microservices-based application with the following components:

- **MSEmployee**: Spring Boot service for employee management
- **MSResident**: Spring Boot service for resident management
- **MSReservation**: Spring Boot service for reservation management
- **MySQL**: Database service with separate databases for each microservice

Each microservice is independent and communicates through well-defined APIs.
