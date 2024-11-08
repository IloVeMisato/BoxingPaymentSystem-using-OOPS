# BoxingPaymentSystem-using-OOPS
A simple Java-based payroll management system for a boxing gym. This program allows you to manage different types of staff members (Veterans, Rookies, Trainers, and CutMan) by adding, displaying, and releasing them, as well as calculating total payroll expenses.
Introduction
The Boxing Gym Payroll System is designed for gym managers who need an organized way to manage payrolls for different types of boxing staff members. Each staff type has unique payment calculation methods based on their attributes.

Features
Add Staff Members: Add Veteran Boxers, Rookie Boxers, Trainers, and CutMen to the payroll.
Display All Active Staff: View the list of all active staff members.
Calculate Total Payroll: Calculate the total payroll expense including bonuses.
Release Staff by ID: Remove staff from the active payroll list by their unique ID.
User-friendly Interface: Console-based interface to navigate through options.
Classes
The system is organized with the following classes:

Main: The main entry point where the user interacts with the console-based menu.
PayrollSystem: Manages the list of staff members, calculates payroll, displays staff, and releases staff.
Veteran: Represents experienced boxers with fixed monthly payment and a bonus percentage.
Rookie: Represents beginner boxers with payment based on minutes lasted and bonus per minute.
Trainer: Staff responsible for training, paid based on hourly rate and hours worked.
CutMan: Support staff paid a fixed monthly salary.

Prerequisites:
Java Development Kit (JDK) 8 or later.
IDE (like IntelliJ IDEA, Eclipse, or Visual Studio Code) or a terminal for running Java files.

Upon running the program, you will see a menu with the following options:

Add Veteran Boxer: Enter the veteran boxer's ID, name, monthly payment, and bonus percentage.
Add Rookie Boxer: Enter the rookie boxer's ID, name, matches played, minutes lasted, and performance bonus per minute.
Add Trainer: Enter the trainer's ID, name, hours worked, and hourly rate.
Add CutMan: Enter the CutMan's ID, name, and monthly salary.
Display All Active Staff: Lists all currently active staff members.
Calculate Total Payroll: Calculates the total payroll including all bonuses.
Release Staff by ID: Removes a staff member from the system based on their ID.
Exit: Exits the program.


