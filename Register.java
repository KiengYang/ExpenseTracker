package ExpenseApp.User;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Register {

  static ArrayList<User> userList = new ArrayList<>();

  public static void Register(String tmpName, String tmpPassword) {
    Scanner sc = new Scanner(System.in);
    String filePath = "UserInfo.csv";

    String writingContent = tmpName + "," + tmpPassword;

    try (BufferedWriter bufferedWriter =
             new BufferedWriter(new FileWriter(filePath, true))) {
      bufferedWriter.write(writingContent);
      bufferedWriter.newLine();
      System.out.println("Registered successfully.");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      sc.close();
    }
  }

  public static void UserList() {
    String filePath = "UserInfo.csv";

    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] userInfo = line.split(",");
        User storedUser = new User(userInfo[0], userInfo[1]);
        userList.add(storedUser);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static boolean verify(String name) {
    UserList();

    boolean exit = false;
    for (User i : userList) {
      if (i.getuserName().equals(name)) {
        exit = true;
      }
    }
    if (exit == true) {
      System.out.println("Username has been taken!!!");
      return true;
    }
    return false;
  }
}
