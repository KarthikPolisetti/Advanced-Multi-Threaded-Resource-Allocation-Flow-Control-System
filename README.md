# OOP Concepts Projects

A collection of Java sample applications demonstrating object-oriented programming principles through small, hands-on projects.

## Overview

This workspace is organized as several independent Java demos that illustrate:

- interfaces and polymorphism
- constructor validation and encapsulation
- immutable object design with `final`
- functional interfaces and lambda expressions
- collection usage and data modeling
- simple application structure and execution flow

## Workspace Projects

- `Main.java`
  - Root-level demo using a functional interface (`UserAction`) and a lambda expression.
  - Sends a notification-style message to each `User` through `NotificationEngine`.

- `BusTransitStation/`
  - A transit station example illustrating class organization and Java application structure.
  - Includes `Main.java` for running the transit demo.

- `collectionFrameworks/`
  - Demonstrates Java collection concepts.
  - Includes `Product.java` and `Main.java` for working with collections and models.

- `oopsProjects/`
  - `Discount.java` defines a discount strategy interface.
  - `Ecommerce.java` implements `PercentDiscount` and `FlatRateDiscount` to compute final product prices.
  - Emphasizes business logic separation, validation, and simple pricing workflows.

- `RestaurantKitchen/`
  - Models a restaurant kitchen workflow and order ticket processing.
  - Demonstrates thread-safe ticket claiming and ledger export support.

- `SmartHomeApp/`
  - Models smart home devices with battery validation.
  - Uses `NotificationChannel` implementations for email and SMS alerts.
  - Includes a safety check engine that triggers alerts when battery is low.

- `high_capacity_report.txt`
  - A workspace report file included for reference.

## How to Compile and Run

From the workspace root, compile and run the Java files as needed.

### Compile a single file

```powershell
javac Main.java
javac SmartHomeApp\SmartHomeApp.java
javac oopsProjects\Ecommerce.java
```

### Run the compiled class

```powershell
java Main
java SmartHomeApp.SmartHomeApp
java oopsProjects.Ecommerce
```

### Compile and run a package demo

```powershell
cd "k:\Java Full Stack\oopsConceptsProjects"
javac SmartHomeApp\*.java
java SmartHomeApp.SmartHomeApp
```

### Compile all Java files recursively

```powershell
Get-ChildItem -Recurse -Filter *.java | ForEach-Object { javac $_.FullName }
```

## Project Highlights

- `oopsProjects/Ecommerce.java`
  - Validates product price and applies discount strategies.
  - Shows how different discount rules can be implemented through a common interface.

- `SmartHomeApp/SmartHomeApp.java`
  - Constructs `SmartDevice` objects with validated battery levels.
  - Uses `EmailAlert` and `SmsAlert` to notify about low battery conditions.

- `RestaurantKitchen/README.md`
  - Contains a detailed description of the kitchen ticket workflow, chef task simulation, and ledger export.

## Notes

This workspace is designed for learning Java OOP fundamentals. You can extend it by adding new discount rules, new smart home alert channels, richer order ticket workflows, or more collection-based examples.
