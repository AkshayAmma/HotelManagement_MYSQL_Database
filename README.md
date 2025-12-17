**Hotel Management System**

A simple Java-based **Hotel Management System** to manage rooms, customers, and bookings using JDBC with a relational database.

## Features

* **Customer Management**

  * Add, update, and view customers
  * Retrieve customer details by ID
  * List all customers

* **Room Management**

  * Add, update, and remove rooms
  * Search rooms by type or capacity
  * Mark rooms as booked or available
  * List available rooms

* **Booking Management**

  * Make and cancel bookings
  * Track booking details (check-in, check-out, total price)
  * Calculate total income from bookings

---

## Technologies

* Java 17 (or higher)
* JDBC
* MySQL / H2 / any relational database
* Console-based interface

---

## Project Structure


HotelManagement/
│
├─ controller/
│   ├─ CustomerController.java
│   ├─ RoomController.java
│
├─ model/
│   ├─ Customer.java
│   ├─ Room.java
│   ├─ Booking.java
│
├─ repository/
│   ├─ CustomerRepository.java
│   ├─ RoomRepository.java
│   ├─ BookingRepository.java
│
├─ service/
│   ├─ CustomerService.java
│   ├─ RoomService.java
│   ├─ BookingService.java
│
├─ util/
│   ├─ DatabaseUtil.java
│   ├─ InputUtil.java
│
└─ Main.java

---

## Setup

1. **Clone the repository**


git clone <repository-url>
cd HotelManagement


2. **Database Setup**

   * Create a database named `hotel_management`.
   * Run the following SQL script:

sql
CREATE TABLE customer (
    CustomerId INT AUTO_INCREMENT PRIMARY KEY,
    CustomerName VARCHAR(100),
    Email VARCHAR(100),
    PhoneNumber VARCHAR(20),
    Address VARCHAR(255),
    IdProof VARCHAR(50)
);

CREATE TABLE rooms (
    RoomId INT AUTO_INCREMENT PRIMARY KEY,
    RoomNumber VARCHAR(20),
    RoomType VARCHAR(50),
    PricePerNight DOUBLE,
    IsBooked BOOLEAN,
    Capacity INT,
    FloorNumber INT
);

CREATE TABLE booking (
    BookingId INT AUTO_INCREMENT PRIMARY KEY,
    CustomerId INT,
    RoomId INT,
    CheckInDate DATE,
    CheckOutDate DATE,
    BookingStatus VARCHAR(20),
    TotalPrice DOUBLE,
    FOREIGN KEY (CustomerId) REFERENCES customer(CustomerId),
    FOREIGN KEY (RoomId) REFERENCES rooms(RoomId)
);

3. **Configure Database Connection**

   * Edit DatabaseUtil.java to set your database URL, username, and password.

java
private static final String URL = "jdbc:mysql://localhost:3306/hotel_management";
private static final String USER = "root";
private static final String PASSWORD = "password";

4. **Build and Run**

   * Compile all .java files.
   * Run Main.java to start the console interface.

---

## Usage

* The console interface allows navigating through:

  * Customer Management
  * Room Management
  * Booking Management
* Example workflow:

  1. Add a customer
  2. Add a room
  3. Make a booking for a customer in an available room
  4. View bookings and income

---

## Database Schema

* **Customer**

  * CustomerId, CustomerName, Email, PhoneNumber, Address, IdProof
* **Room**

  * RoomId, RoomNumber, RoomType, PricePerNight, IsBooked, Capacity, FloorNumber
* **Booking**

  * BookingId, CustomerId, RoomId, CheckInDate, CheckOutDate, BookingStatus, TotalPrice


