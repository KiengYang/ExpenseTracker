package ExpenseApp.User;

import java.util.Objects;

public class Person {
  protected String userName;
  protected String passWord;

  public Person(String userName, String passWord) {
    this.userName = userName;
    this.passWord = passWord; // Fixed typo: Assign passWord correctly
  }

  public String getUserName() { return userName; }

  public String getPassword() { return passWord; }

  // Override toString() in the superclass
  @Override
  public String toString() {
    return "Username: " + userName + ", Password: " + passWord;
  }

  // Override equals() in the superclass
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Person person = (Person)obj;
    return Objects.equals(userName, person.userName) &&
        Objects.equals(passWord, person.passWord);
  }
}
