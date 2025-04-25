# Student_Management_System
**Purpose:**
This Java project is designed to manage student information for a specific batch. It allows users to add, view, update, and remove students dynamically via console interaction.

**Core Packages and Classes:**

**1. Entity Classes**

**i.Student.java**
Represents an individual student.

**Attributes:**

id: Integer representing the unique student ID.

name: Student's name.

gen: Student's gender ('m' or 'f').

Methods: Standard getters and setters.

**ii.Batch.java**
Represents a class batch.

**Attributes:**

batchCode: Unique identifier for the batch.

subject: Name of the subject.

trainer: Trainer's name.

students: A list of Student objects.

Methods: Getters and setters for all attributes.

**2. Controller Class**

**Controller.java**
Handles business logic and operations like:

Adding a single/multiple students.

Checking existing students.

Removing or updating a student.

Verifying student existence by ID.

**3. View Class**

**Driver.java**
Acts as the user interface (console-based).

**Functionality:**

Prompts the user to input batch details.

Displays menu options for managing students:

View students

Add one/multiple students

Remove or update student info

Ensures validation for inputs like gender and update options.


