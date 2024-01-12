# ExpenseTracker
#ExpenseTracker


ExpenseTracker is an Java base system that can track our daily spending. The system will store our data in our system and when the user want to view the spending, it will show the list of our spending and calculate our spending by month and by year.


## Features/Class

- [Authentication.java](https://github.com/KiengYang/ExpenseTracker/blob/main/Authenticate.java) run the main program of this project to allow the user to Register, log in, input or view the expense.
- [Login.java](https://github.com/KiengYang/ExpenseTracker/blob/main/Login.java) is validating user credentials during the login process and manages expense-related interactions after successful login.
- [Register.java](https://github.com/KiengYang/ExpenseTracker/blob/main/Register.java)  allow user to create a new account which is called registration option from [Authentication.java](https://github.com/KiengYang/ExpenseTracker/blob/main/Authenticate.java)
- [Userinfo.csv](https://github.com/KiengYang/ExpenseTracker/blob/main/UserInfo.csv) store new User data.
- [Expense.java](https://github.com/KiengYang/ExpenseTracker/blob/main/Expense.java) is handling the adding, viewing and calculating the expense for the User.
- [UpdateUserInfo.java](https://github.com/KiengYang/ExpenseTracker/blob/main/UpdateUserInfo.java) is a method that're called from [User.java](https://github.com/KiengYang/ExpenseTracker/blob/main/User.java) when the User want to change their Username or Their Password.



## Object-Oriented Features



### Inheritance

Inheritance is employed to create a hierarchy of classes. We have 1 Super classes:
Person serves as SuperClass, while User is the sub-class that inherit the constructor of Employee. In this case, Inheritance is used in this code to reuse code from the Person class, allowing the User class to inherit properties and methods. This promotes code reusability, method overriding, and an organized code structure.

### Polymorphism
#### Method overloading
Method overloading is used in the Expense class to provide multiple versions of the calculateExpenseByDate method with different parameter lists. Overloading allows the same method name to be used for calculations based on different criteria, providing flexibility and convenience. In this specific case:

[CalculateExpenseByDate](https://github.com/KiengYang/ExpenseTracker/blob/main/Expense.java) (User user, int month, int year):
Calculates the total expenses for a specific month and year.
[CalculateExpenseByDate](https://github.com/KiengYang/ExpenseTracker/blob/main/Expense.java) (User user, int year):
Calculates the total expenses for a specific year.

### Encapsulation

-Public: Used for providing controlled, read-only access to internal fields through getter methods, allowing external classes to retrieve information without direct modification.

    public String getUserName() { return userName; }
    public String getPassword() { return passWord; }

We use public for the getUserName() and getPassword() methods to allow external classes, including subclasses like User, to retrieve a person's username and password. This enables any class that creates a Person object to access these details without directly modifying the internal state of the Person class.

-Private: Used for encapsulation, data hiding, and restricting direct access to internal fields from outside the class.

    private String date;
    private double price;
    private String info;

We employ the "private" modifier on these fields as they are the class's properties. This ensures that their values can only be modified within the class, preventing any external interference.

-Protected: Used to allow access to fields or methods within the same package and by subclasses, promoting inheritance and code extension while maintaining restricted external access.

    protected String userName;
    protected String passWord;  

The protected modifier is employed for these methods to restrict their access to classes within the same package or subclasses. This prevents external classes from calling these methods.

### Exception
Exception handling is implemented to gracefully manage unexpected errors, ensuring the system can recover or terminate gracefully. We use 'try' and 'catch' to address issues such as file not found or mistyped input.

    try {
      BufferedReader reader = new BufferedReader(new FileReader(filePath));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] userInfo = line.split(",");
        if (userInfo.length >= 2 && userInfo[0].equals(username)) {
          userInfo[1] = newPassword; 
          line = String.join(",", userInfo);
        }
        fileContent.add(line);
      }
      reader.close();


      BufferedWriter writer =
          new BufferedWriter(new FileWriter(filePath, false));
      for (String content : fileContent) {
        writer.write(content);
        writer.newLine();
      }
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

 IOException: we use it to check weather or not the file we need to open exist.

### File I/O
We have 2 files:
UserInfo.csv: to store Username, password.
yang_expense.csv: to store date, price, and info of User.


We utilize these two files independently to store specific data, ensuring that reading each file won't create any issues.

### Static method

static method we use to access the class without creating an instance of the class. In the project, we use 14 static methods. We use the static method is for an easy way to call out the function in other class and also call in within class.

    public static void UserList() 
This function use as a static method to provide a function that can access to Userinfo.csv file to check whether the username and password is correct.
