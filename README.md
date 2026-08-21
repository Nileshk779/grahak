# Grahak — Hyperlocal AI-Driven E-Commerce Middleware

Turns neighborhood retail stores into a decentralized network of smart "dark stores" for 30–60 minute delivery, without requiring dedicated warehouse infrastructure.

## Tech Stack
- **Backend:** Java 21, Spring Boot 3.x, Spring Data JPA
- **Database:** PostgreSQL 16 + PostGIS (geospatial queries)
- **Build:** Maven

## Core Feature (MVP)
**Asset-Light Hyperlocal Router** — given a customer's location, finds the nearest vendor with stock within a configurable radius and assigns the order automatically.

## Running Locally
1. Start PostGIS via Docker:
   docker run --name grahak-db -e
   POSTGRES_USER=grahak -e POSTGRES_PASSWORD=devpass -e
   POSTGRES_DB=grahak_db -p 5432:5432 -d postgis/postgis:16-3.4
2. Run the app:
   ./mvnw spring-boot:run
3. API docs: `http://localhost:8080/swagger-ui.html`

## API Endpoints
- `GET /api/vendors` — list all vendors
- `GET /api/vendors/nearby?lat=X&lng=Y&radiusMeters=3000` — radius search
- `POST /api/orders` — place an order `{ "lat": X, "lng": Y }`, auto-assigns nearest vendor
- `GET /api/orders` — list all orders

## Architecture Notes
- DTOs decouple JPA entities from API responses (avoids leaking DB structure, avoids JSON serialization issues with spatial types)
- PostGIS `ST_DWithin` powers efficient radius queries at the database level rather than in application code
