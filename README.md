# 💰 Finance Backend System (Spring Boot)

A robust backend application built using **Spring Boot** to manage financial records, user roles, and dashboard analytics with secure authentication.

---

## 🚀 Features

### 👤 User & Role Management

* Create and manage users
* Role-based access control (RBAC)
* Roles:

  * **ADMIN** → Full access
  * **ANALYST** → View records & analytics
  * **VIEWER** → View dashboard only
* Activate/Deactivate users

---

### 💰 Financial Records Management

* Create financial records (income/expense)
* View all records
* Delete records
* Categorize transactions (salary, food, etc.)
* Store date and notes for each record

---

### 📊 Dashboard Analytics

* Total Income
* Total Expenses
* Net Balance
* Category-wise breakdown
* Recent transactions

---

### 🔐 Security (JWT Authentication)

* Token-based authentication using JWT
* Secure API endpoints
* Role-based authorization using Spring Security

---

### ⚠️ Validation & Error Handling

* Input validation using annotations
* Global exception handling
* Clean and meaningful error responses

---

## 🛠️ Tech Stack

* **Java 17**
* **Spring Boot**
* **Spring Security**
* **Spring Data JPA**
* **H2 Database (In-Memory)**
* **JWT (JSON Web Token)**

---

## 📂 Project Structure

```
com.finance.financebackend
│
├── controller      # REST APIs
├── service         # Business logic
├── repository      # Database access
├── entity          # Database models
├── dto             # Request/Response models
├── config          # Security configuration
├── security        # JWT handling
├── exception       # Global error handling
```

---

## ⚙️ Setup & Run

### 1️⃣ Clone the repository

```bash
https://github.com/Pkmr-work/Finance-Data-Processing-and-Access-Control-Backend.git
```

### 2️⃣ Run the application

Using IDE:

* Open project
* Run `FinanceBackendApplication.java`

---

### 3️⃣ Access APIs

```
http://localhost:8080
```

---

### 4️⃣ H2 Database Console

```
http://localhost:8080/h2-console
```

* JDBC URL: `jdbc:h2:mem:finance_db`
* Username: `sa`
* Password: *(leave empty)*

---

## 🔑 Authentication (JWT)

### Login API

```
POST /auth/login
```

#### Request:

```json
{
  "username": "admin"
}
```

#### Response:

```json
{
  "token": "your-jwt-token"
}
```

---

### Use Token in Requests

Add header:

```
Authorization: Bearer <your-token>
```

---

## 📌 Sample APIs

### 👤 User APIs

* `POST /users` → Create user (ADMIN only)
* `GET /users` → Get all users

---

### 💰 Record APIs

* `POST /records` → Create record (ADMIN)
* `GET /records` → View records (ADMIN, ANALYST)
* `DELETE /records/{id}` → Delete record (ADMIN)

---

### 📊 Dashboard API

* `GET /dashboard` → View analytics (All roles)

---

## 🧠 Key Concepts Demonstrated

* RESTful API design
* Layered architecture (Controller → Service → Repository)
* Role-based authorization
* JWT authentication
* Data validation & error handling
* Aggregation logic using Java Streams

---

## 🎯 Future Improvements

* Pagination & filtering
* Search functionality
* Soft delete support
* Rate limiting
* Unit & integration testing
* Swagger API documentation

---

## 👨‍💻 Author

**Pushpender**
Aspiring Backend Developer

---

## ⭐ If you like this project

Give it a star on GitHub ⭐
