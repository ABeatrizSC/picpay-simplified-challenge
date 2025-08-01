<p align="center">
  <img src="https://img.shields.io/badge/Status-In%20Progress-yellow?style=for-the-badge&logo=headspace&logoColor=orange&color=yellow" alt="repo-status" />
</p>


<p align="center">
  <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java" />
  <img src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white" alt="Spring" />
</p>

</br>

# PicPay Simplified Challenge
This repository contains the solution to the PicPay Back-end technical challenge – "PicPay Simplified". For study purposes, I chose to implement the application following Clean Architecture principles.

You can find the full challenge description in the repository above:
[https://github.com/PicPay/picpay-desafio-backend?tab=readme-ov-file](https://github.com/PicPay/picpay-desafio-backend?tab=readme-ov-file)
</br>

# Technologies Used
* **Java 17**: A high-level, object-oriented programming language widely used for building server-side applications, web services, and Android applications.

* **Spring Boot 3.5.3**: A framework that simplifies the development of Java applications by providing built-in features for dependency injection, configuration, and microservices support.

* **Spring Retry**: Spring Retry is a module within the Spring framework that provides declarative retry support for Spring applications. Its primary purpose is to automatically re-invoke a failed operation, making applications more resilient to transient failures.

* **H2 Database**: H2 is an open-source lightweight Java database. It can be embedded in Java applications or run in the client-server mode.

* **Jakarta Bean Validation**: A standard framework for declaring and validating constraints on Java objects using annotations, commonly used to enforce business rules and input validation in a clean and declarative way.

* **JPA**: The Java Persistence API, a specification that provides object-relational mapping (ORM) to manage relational data in Java applications.

* **Lombok 1.18.28**: A Java library that reduces boilerplate code by generating common methods like getters, setters, constructors, and more through annotations.

* **Postman**: A tool used for API testing and development, enabling users to send HTTP requests, inspect responses, and automate API tests.

</br>

# Requirements
To run the project on your machine, the following tools must be installed and configured beforehand:

- Java Development Kit (JDK) 17;
- Git;
- Postman (Optional for local development or testing).

</br>

# Installation guide
Follow the steps below to download, configure, and run the project in your environment:

1. **Clone the repository**
```bash
git clone https://github.com/ABeatrizSC/picpay-simplified-challenge.git
 ```

2. **Navigate to the project directory**

```bash
cd picpay-simplified-challenge
 ```

3. **Run the aplication**

 ```bash
mvn spring-boot:run
 ```

</br>

# API Endpoints
## Users
### **GET** `/api/v1/users`
- Deposits an amount to the user.

#### Success Response Body
- `List<UserResponseDto>`

```json
[
  {
    "fullName": "John",
    "userType": "CUSTOMER",
    "email": "john@example.com"
  },
  {
    "fullName": "Alice",
    "userType": "MERCHANT",
    "email": "alice@example.com"
  }
]
```

### **POST** `/api/v1/users`
- Create a new user.

#### Request Body
- `UserCreateDto`

```json
{
  "fullName": "New user",
  "userType": "CUSTOMER", //user type: CUSTOMER or MERCHANT
  "document": "123.456.789-12",
  "email": "newuser@email.com",
  "password": "12345678"
}
```

#### Success Response Body
- `201 CREATED`

### **POST** `/api/v1/users/deposits`
- Deposits an amount to the user.

#### Request Body
- `DepositFundsRequestDto`

```json
{
  "userId": "421b2925...",
  "amount": 50.0
}
```

#### Success Response Body
- `User`
```json
{
  "id": "421b2925..",
  "fullName": "New user",
  "userType": "CUSTOMER",
  "document": "123.456.789-12",
  "email": "newuser@email.com",
  "password": "12345678",
  "balance": 50.00
}
```

## Transactions
### **POST** `/api/v1/transactions`
- Performs a transaction of values from one user to another.

#### Request Body
- `TransactionRequestDto`

```json
{
  "amount": 50.0,
  "sender": "421...",
  "receiver": "cfe..."
}
```

#### Success Response Body
- `201 CREATED`

## Errors handled
### Field validation error (`MethodArgumentNotValidException`)
```json
{
  "status": 400,
  "error": "BAD_REQUEST",
  "message": "The field 'email' must not be blank."
}
```

### Business rule violation (`BusinessException`)
- `InsufficientBalanceException`
- `UnauthorizedTransactionException`: Merchants are not allowed to perform transfers.

```json
{
  "status": 500,
  "error": "INTERNAL_SERVER_ERROR",
  "message": "The available balance is insufficient to complete the transfer." //Variable
}
```

### Transaction processing error (`TransactionErrorException`)
```json
{
  "status": 500,
  "error": "INTERNAL_SERVER_ERROR",
  "message": "An error occurred during the transaction. Please try again."
}
```

### Notification sending failure (`NotificationSendException`)
```json
{
  "status": 500,
  "error": "INTERNAL_SERVER_ERROR",
  "message": "An error occurred while attempting to send the notification."
}
```

### User not found (`UserNotFoundException`)
```json
{
  "status": 404,
  "error": "NOT_FOUND",
  "message": "User not found." //Variable
}
```


# Contact
* GitHub: [ABeatrizSC](https://github.com/ABeatrizSC)
* Linkedin: [Ana Beatriz Santucci Carmoni](www.linkedin.com/in/ana-carmoni)
* Email: [anabeatrizscarmoni@gmail.com](mailto:anabeatrizscarmoni@gmail.com)
