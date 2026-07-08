# CineBite Movie Booking Management System

A Spring Boot backend for movie ticket and food-order booking, featuring JWT-secured authentication (via Spring Security) and role-based access for users and admins, paired with a React frontend for registration and login.

## Overview

CineBite lets users register, log in, browse movies and seats, and place food orders alongside their booking. Admins manage movie and show listings. The system is built with a layered architecture (controller-service-repository) and secured using Spring Security with JWT tokens for stateless authentication.

## Tech Stack

**Backend:** Java, Spring Boot, Spring Security, Spring Data JPA, Hibernate ORM, Oracle Database, Maven
**Frontend:** React (registration and login)
**Tools:** Postman, Git/GitHub

## Features

- User registration and management (CRUD)
- JWT-based login authentication via Spring Security's `AuthenticationManager`
- Movie management (admin-only add/list)
- Seat management (create, update, delete, fetch)
- Food item management (CRUD)
- Food order booking linked to user and food item, with automatic total price calculation
- Global exception handling for consistent API error responses
- Query optimization on Oracle DB (30% average response time reduction)

## API Endpoints (sample)

- `POST /api/auth/login` — authenticate and receive JWT
- `POST /api/users/create`, `GET /api/users/all`, `PUT /api/users/update/{id}`, `DELETE /api/users/delete/{id}`
- `GET /api/bookings/create`, `GET /api/bookings/fetch`
- `POST /api/fooditems/create`, `GET /api/fooditems/all`, `PUT /api/fooditems/update/{id}`
- `POST /api/seats/create`, `GET /api/seats/all`, `PUT /api/seats/update/{id}`

## Getting Started

### Prerequisites
- Java 17+ (confirm your version)
- Maven
- Oracle Database (local instance)
- Node.js (for React frontend)

### Backend Setup
1. Clone the repository
2. Copy `src/main/resources/application.properties.example` to `application.properties`
3. Fill in your Oracle DB credentials and JWT secret
4. Run: `mvn spring-boot:run`

### Frontend Setup
1. Navigate to frontend folder
2. `npm install`
3. `npm start`

## Roadmap
- Add discount logic for food orders based on order timing relative to showtime
- Add cutoff enforcement for food orders near showtime
- Expand booking to include seat + showtime selection in a single flow
- Add unit tests (JUnit, Mockito)

## Author
Pavani Chinthalapudi