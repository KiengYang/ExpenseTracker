#ExpenseTracker


ExpenseTracker is an Java base system that can track our daily spending. 


## Features

- [Authentication.java](https://github.com/KiengYang/ExpenseTracker/blob/main/Authenticate.java) run the main program of this project to allow the user to Register, log in, input or view the expense.
- [Login.java](https://github.com/KiengYang/ExpenseTracker/blob/main/Login.java) is validating user credentials during the login process and manages expense-related interactions after successful login.
- [Register.java](https://github.com/KiengYang/ExpenseTracker/blob/main/Register.java)  allow user to create a new account which is called registration option from [Authentication.java](https://github.com/KiengYang/ExpenseTracker/blob/main/Authenticate.java)
- [Userinfo.csv](https://github.com/KiengYang/ExpenseTracker/blob/main/UserInfo.csv) store new User data.
- [Expense.java](https://github.com/KiengYang/ExpenseTracker/blob/main/Expense.java) is handling the adding, viewing and calculating the expense for the User.
- [UpdateUserInfo.java](https://github.com/KiengYang/ExpenseTracker/blob/main/UpdateUserInfo.java) is a method that're called from [User.java](https://github.com/KiengYang/ExpenseTracker/blob/main/User.java) when the User want to change their Username or Their Password.



## Classes & Objects

Classes & Objects
In the application, classes serve as templates that define the properties and behaviors of objects. For instance:

1. [Person.java](https://github.com/KiengYang/ExpenseTracker/blob/main/Person.java):
   - Classes & Objects:
     - Demonstrates the creation of the [Person.java](https://github.com/KiengYang/ExpenseTracker/blob/main/Person.java) class.
     - [Person.java](https://github.com/KiengYang/ExpenseTracker/blob/main/Person.java) class is used as a base class for [User](https://github.com/KiengYang/ExpenseTracker/blob/main/User.java).

2. [User.java](https://github.com/KiengYang/ExpenseTracker/blob/main/User.java):
   - Inheritance:
     - Extends the [Person.java](https://github.com/KiengYang/ExpenseTracker/blob/main/Person.java) class, demonstrating inheritance.
     - Utilizes superclass constructor through super(userName, passWord).
     - Encapsulation:
       - Uses access modifiers (private, public) to encapsulate fields.
     - Abstraction:
       - Inherits from [Person.java](https://github.com/KiengYang/ExpenseTracker/blob/main/Person.java), providing a level of abstraction for user information.
       - Implements abstract methods from the superclass (equals, toString).
       - File I/O:
       - Utilizes UpdateUserInfo for file operations, fulfilling file I/O requirement.
       - Stores user-related information in the file ([Userinfo.csv](https://github.com/KiengYang/ExpenseTracker/blob/main/UserInfo.csv)).
       - Exception Handling:
       - No explicit exception handling in this class; exceptions are delegated to UpdateUserInfo.

3. [Userinfo.csv](https://github.com/KiengYang/ExpenseTracker/blob/main/UserInfo.csv) :
   - File I/O:
     - Performs file operations for updating user information ([Userinfo.csv](https://github.com/KiengYang/ExpenseTracker/blob/main/UserInfo.csv)).
     - Contains methods (updatePassword, updateUsername) to update user credentials in the file.

4. [Authentication.java](https://github.com/KiengYang/ExpenseTracker/blob/main/Authenticate.java):
   - Classes & Objects:
     - Demonstrates the creation of the [Authentication.java](https://github.com/KiengYang/ExpenseTracker/blob/main/Authenticate.java) class.
     - Uses the [User.java](https://github.com/KiengYang/ExpenseTracker/blob/main/User.java) class to manage user authentication.
     - Exception Handling:
       - Handles exceptions related to input (non-integer input).
     - File I/O:
       - Uses Register class to store user information in the file ([Userinfo.csv](https://github.com/KiengYang/ExpenseTracker/blob/main/UserInfo.csv)).

5. [Register.java](https://github.com/KiengYang/ExpenseTracker/blob/main/Register.java):
   - Classes & Objects:
     - Demonstrates the creation of the [Register.java](https://github.com/KiengYang/ExpenseTracker/blob/main/Register.java) class.
     - Uses the [User.java](https://github.com/KiengYang/ExpenseTracker/blob/main/User.java) class to manage user registration.
     - File I/O:
       - Stores user information in the file ([Userinfo.csv](https://github.com/KiengYang/ExpenseTracker/blob/main/UserInfo.csv)).
     - Encapsulation:
       - Uses access modifiers (private, public) to encapsulate fields and methods.

6. [Expense.java](https://github.com/KiengYang/ExpenseTracker/blob/main/Expense.java):
   - Classes & Objects:
     - Demonstrates the creation of the [Expense.java](https://github.com/KiengYang/ExpenseTracker/blob/main/Expense.java) class.
     - Uses the [User.java](https://github.com/KiengYang/ExpenseTracker/blob/main/User.java) class to manage user expenses.
     - File I/O:
       - Writes and reads user expenses to/from a file (_expenses.csv).
       - Exception Handling:
         - Handles exceptions related to parsing and reading expenses from the file.
       - Polymorphism:
         - Overrides toString method to provide a custom string representation.

7. [Login.java](https://github.com/KiengYang/ExpenseTracker/blob/main/Login.java):
   - Classes & Objects:
     - Demonstrates the creation of the Login class.
     - Uses the [User.java](https://github.com/KiengYang/ExpenseTracker/blob/main/User.java) class to manage user login and expense handling.
     - Exception Handling:
       - Handles exceptions related to invalid input.
       - File I/O:
         - Reads user information from [Userinfo.csv](https://github.com/KiengYang/ExpenseTracker/blob/main/UserInfo.csv).

In summary, each file has specific responsibilities contributing to the overall functionality of the expense management application. They collectively fulfill requirements related to classes and objects, inheritance, encapsulation, abstraction, exception handling, file I/O, and polymorphism.
