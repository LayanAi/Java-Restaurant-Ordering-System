# Java Restaurant Ordering System

A simple Java project that simulates an online restaurant ordering system using object‑oriented programming concepts.

The system allows the restaurant to store menu items, create customer orders, add or remove items, calculate totals using recursion, and prepare meals and drinks.

The program also demonstrates inheritance, interfaces, abstract classes, aggregation, and composition.

## Features

- Add, search, and remove menu items
- Create new orders with unique IDs
- Add meals or drinks to an order (deep copy)
- Remove items from an order
- Search for items inside an order
- Display full order details
- Calculate total price using recursion
- Prepare all items in the order
- Menu‑driven console interface

## Classes Overview:

### **MenuItem (Abstract Class)**

Base class for all menu items.
Handles name, price, availability, and defines abstract methods for preparation and price calculation.

### **Meal**

Represents a general meal with meal type (Lunch/Dinner/Breakfast) and calories.
Calculates price based on type and calorie level.

### **MainMeal**

Extends Meal and supports adding up to five extras.
Final price increases based on number of extras.

### **Drink**

Represents a drink with size (Small/Medium/Large).
Price is calculated based on drink size.

### **Order**

Stores multiple MenuItem objects using deep copy.
Supports adding, removing, searching, printing, preparing, and recursive total calculation.

### **Restaurant**

Stores menu items (aggregation) and orders (composition).
Allows adding, searching, removing menu items and orders.
Prints menu recursively.

### **TestSystem (Main Class)**

Handles user interaction, menu navigation, input validation, and calling all system functions.

## How Ordering Works

The restaurant stores menu items such as meals and drinks.
When the user selects an item to add to the order:

- The system searches for the item in the menu
- Creates a **deep copy** of the item
- Adds it to the order

Removing or searching items is done by name.
The total price is calculated using a recursive method that sums the price of each item.

Preparing the order calls the “prepare() “ method for each item, which prints custom preparation steps.

## Example Usage

- Adding “Chicken Alfredo” to the order creates a new MainMeal object with its own extras list.
- Adding “Coca‑Cola” creates a Drink object with size‑based pricing.
- Calculating the total prints the sum of all item prices using recursion.
- Preparing the order prints steps such as:

Preparing Chicken Alfredo – Creamy Alfredo sauce
Adding extra: Cheese
Pouring drink: Coca‑Cola (Large)

## Purpose

This project is designed for practicing:

- Java basics
- Object‑oriented programming
- Inheritance and interfaces
- Aggregation and composition
- Recursion
- Input validation
- Working with multiple interacting classes
