package ExpenseTracker.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Register {

  public static void registerUser(String tmpName, String tmpPassword) {
    Scanner sc = new Scanner(System.in);
    String filePath = "UserInfo.csv";

    // Format the user information as CSV format
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

}

