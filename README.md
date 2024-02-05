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

## Exporting the Project to JAR

To deploy the Equipment Management System as a JAR file, follow these steps using your preferred Integrated Development Environment (IDE):

### Using Eclipse:

1. Open Eclipse and navigate to your Equipment Management System project.

2. Right-click on the project in the Project Explorer.

3. Select "Export" from the context menu.

4. In the Export dialog, expand the "Java" category and select "Runnable JAR file." Click "Next."

5. Choose the launch configuration (main class) for your project. If it's not already selected, use the dropdown to find and select the main class (e.g., `Main`).

6. Choose the export destination for your JAR file.

7. Select "Package required libraries into generated JAR" or choose another option based on your preference.

8. Click "Finish" to export the JAR file.

### Using IntelliJ IDEA:

1. Open IntelliJ IDEA and navigate to your Equipment Management System project.

2. Go to "File" > "Project Structure."

3. In the Project Structure dialog, go to "Artifacts" and click the "+" icon to add a new artifact.

4. Choose "JAR" > "From modules with dependencies."

5. Select the main class (e.g., `Main`) and click "OK."

6. Configure the JAR settings, such as specifying the output directory and selecting "Extract to the target JAR." Click "OK."

7. Go to "Build" > "Build Artifacts" and choose "Build" to build the JAR file.

8. The JAR file will be generated in the specified output directory.
