# Inventory Management CLI

![Java](https://img.shields.io/badge/Java-JDK%2025-orange)
![Console App](https://img.shields.io/badge/Application-Console-blue)
![OOP](https://img.shields.io/badge/Concepts-OOP-success)

---

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Functionality](#functionality)
- [Tech Stack](#tech-stack)
- [Setup Instructions](#setup-instructions)
- [Why I Built This](#why-i-built-this)
- [Future Improvements](#future-improvements)

---

## Overview

The **Inventory Management CLI** is a **Java console application** that allows users to manage products, track sales, apply discounts, and monitor stock levels.

The application demonstrates **core Java principles**, including object-oriented design, Factory and Strategy patterns, collections, and CLI-based user interaction.

It also includes a **Dockerfile** for containerized deployment.

---

## Features

- Add new products with type validation
- Sell products and automatically update stock
- Add stock to existing products
- View inventory and low-stock alerts
- Apply discounts:
  - Student discount (10% on books)
  - Bulk discount (15% on 5+ items)
  - No discount
- View inventory statistics
- CLI menu for interactive user experience
- Unit tests using JUnit 5
- Dockerized deployment for portability

---

## Functionality

- **Add Product**  
  Register a new product with ID, name, type, price, and quantity. Books have a minimum price validation.

- **Sell Product**  
  Sell a product, automatically applying any relevant discounts.

- **Add Stock**  
  Increase the quantity of existing products in inventory.

- **View Inventory**  
  Display all products with ID, name, type, price, and quantity.

- **View Statistics**  
  Show total products, total inventory value, and low-stock products.

---

## Tech Stack

- **Java (JDK 25)**
- Console-based application
- Design patterns:
  - Factory Pattern
  - Strategy Pattern
- JUnit 5 for unit testing
- Docker for containerized deployment

---

## Setup Instructions

1. **Clone the repository:**

```bash
git clone https://github.com/SkanderGasmi/inventory-management-cli.git
cd inventory-management-cli
````

2. **Build the project with Maven:**

```bash
mvn clean package
```

This creates the JAR file: `target/simple-inventory-1.0.0.jar`.

3. **Run locally without Docker:**

```bash
mvn exec:java
```

or directly with Java:

```bash
java -jar target/simple-inventory-1.0.0.jar
```

4. **Build the Docker image:**

```bash
docker build -t simple-inventory .
```

5. **Run the Docker container:**

```bash
docker run -it simple-inventory
```

The CLI menu will appear in the container for interactive use.

---

## Why I Built This

I built this project to strengthen my understanding of **object-oriented programming**, **Java design patterns** (Factory & Strategy), and **collection handling**.

It also provided hands-on experience with **unit testing**, **CLI design**, and **containerized deployment** using Docker.

---

## Future Improvements

* Add user authentication and roles (admin vs regular user)
* Persist inventory data in a database (e.g., MySQL or PostgreSQL)
* Add more complex discount rules and promotions
* Convert the CLI application to a GUI or REST-based web application
* Generate PDF/CSV reports for inventory and sales

