package ExpenseApp.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UpdateUserInfo {

  public static void updatePassword(String username, String oldPassword,
                                    String newPassword, String filePath) {
    List<String> fileContent = new ArrayList<>();

    try {
      BufferedReader reader = new BufferedReader(new FileReader(filePath));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] userInfo = line.split(",");
        if (userInfo.length >= 2 && userInfo[0].equals(username)) {
          userInfo[1] = newPassword; // Updating the password field
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

  public static void updateUsername(String oldUsername, String oldPassword,
                                    String newUsername, String filePath) {
    List<String> fileContent = new ArrayList<>();

    try {
      BufferedReader reader = new BufferedReader(new FileReader(filePath));
      String line;
      while ((line = reader.readLine()) != null) {
        String[] userInfo = line.split(",");
        if (userInfo.length >= 2 && userInfo[0].equals(oldUsername) &&
            userInfo[1].equals(oldPassword)) {
          userInfo[0] = newUsername; // Updating the username field
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
}
