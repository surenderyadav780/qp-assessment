# qp-assessment

This is a Java-based application designed for managing grocery items. 

# Features

# Admin Role
- Add new grocery items to the system.
- View a list of all grocery items.
- Update details (name, price, quantity) of existing grocery items.
- Remove grocery items from the inventory.
- Manage inventory levels.

# User Role
- View the list of available grocery items.
- Book multiple grocery items in a single order.

# Technology Stack

- Java: Programming language
- Spring Boot: Framework for building the application
- H2 Database: Embedded database for data storage
- Maven: Build and dependency management tool
- Docker: Containerization for easy deployment and scaling

# Getting Started

# Prerequisites

- Java 17 or higher
- Maven
- Docker (for containerization)

# Installation

1. Clone the repository:
   
2. Build the project using Maven:
   mvn clean install
3. To run the application local:
   mvn spring-boot:run


# Running with Docker

1. Build the Docker image:
   docker build -t qp-assessment .
2.  Run the Docker container:
    docker run -p 8080:8080 qp-assessment

# Access Api:  http://localhost:8080/api/grocery
   # Basic Auth: Credentials for admin  admin/admin
   # API Endpoints
1.     GET /api/grocery: Retrieve the list of grocery items.
2.     POST /api/grocery/admin/addItem: Add a new grocery item.
     Request Body: e.g.
        {
           "name": "Apple",
           "price": 1.20,
           "quantity": 100
        }

4.     PUT /api/grocery/admin/{id}: Update an existing grocery item by ID.
5.     DELETE /api/grocery/admin/{id}: Remove a grocery item by ID.

# Users to Place orders and get Orders 
  #   Basic Auth: Credentials for users  user/user
1.    GET /api/grocery: Retrieve the list of grocery items.

2. Place order:   
        http://localhost:8080/api/grocery/placeOrder
        Request Body:
   {
   "userId": 1,
   "groceryIds": [1, 2, 4] // IDs of the grocery items being ordered
   }

3. Get All users Orders:
     http://localhost:8080/api/grocery/orders
