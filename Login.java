package ExpenseTracker.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Login {

  static ArrayList<User> userList = new ArrayList<User>();

  public static void UserList() {
    String filePath = "UserInfo.txt";

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] userInfo = line.split("/");
        User storedUser = new User(userInfo[0], userInfo[1]);
        userList.add(storedUser);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static boolean Verify(String name) {

    UserList();

    boolean exit = false;
    for (User i : userList) {
      if (i.getUsername().equals(name)) {
        exit = true;
      }
    }
    if (exit == true) {
      System.out.println("Username has been taken!");
      return true;
    }
    return false;
  }
  public static void loginUser(User loginUser) {
    UserList();

    boolean exit = false;

    for (User i : userList) {
      if (i.equals(loginUser)) {
        exit = true;
      }
    }
    if (exit == true) {
      System.out.println("Login complete");
      System.out.println(" ");
    } else {
      System.out.println("User doesnt exist");
    }
  }
}
