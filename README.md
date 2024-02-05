# Equipment Management System
## Overview
This Java-based project aims to enhance the equipment loaning processes for the Art Department at British International School.

### Features
- Streamlined equipment loaning processes for the Art Department
- Front-end GUI designed using Java Swing for students
- Database connectivity through Microsoft SQL Server Management Studio

### Requirements
- Java Development Kit (JDK)
- Microsoft SQL Server Management Studio

### Database Setup
Execute the SQL script script.sql using Microsoft SQL Server Management Studio to create the necessary database schema and tables.

### Database Configuration

To establish a connection with your SQL Server database, you need to update the `JavaConnectionDataBase.java` file located at `Equipment Management System/src/equipment/management/system/JavaConnectionDataBase.java`. Follow these steps:

1. Open the `JavaConnectionDataBase.java` file in a text editor.

2. Locate the following section of code:

   ```java
   // Update the following information based on your database configuration
   String dbUrl = "jdbc:sqlserver://YOUR_SERVER_NAME;databaseName=YourDatabaseName;user=YourUsername;password=YourPassword";
