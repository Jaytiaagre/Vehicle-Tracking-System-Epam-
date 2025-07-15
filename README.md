# 🚗 Vehicle Rental System - Java OOP Project

This is a simple **Java-based Vehicle Rental System** designed using key **Object-Oriented Programming** principles. It supports different vehicle types like Cars, Bikes, and Trucks, allowing users to rent, return, and calculate rental costs.

---

## 📌 Features

- Add vehicles to the system
- Rent and return vehicles
- Calculate rental cost based on number of days
- View current vehicle availability
- Easy to extend with new vehicle types

---

## 🧠 OOP Concepts Used

| Concept         | Implementation                                  |
|----------------|--------------------------------------------------|
| **Abstraction** | `Vehicle` abstract class                        |
| **Inheritance** | `Car`, `Bike`, and `Truck` extend `Vehicle`     |
| **Polymorphism**| Overridden `calculateRentalCost()` method       |
| **Encapsulation**| Private fields with proper accessors          |
| **Interface**   | `Rentable` interface implemented by all vehicles|
| **Composition** | `RentalService` manages vehicle objects         |

---

## 🛠️ Technologies Used

- Java (JDK 8+)
- Object-Oriented Design
- No external libraries (pure Java)

---

## 🚀 How to Run

1. Clone the repository  
   ```bash
   git clone https://github.com/your-username/vehicle-rental-system.git
   cd vehicle-rental-system
  Compile and run using any Java IDE or terminal:

## Compile and run using any Java IDE or terminal:
javac Main.java
java Main

## You will see outputs like
Car rented successfully.
Rental cost for 3 days: ₹4500.0

