import java.io.*;
import java.util.*;

public class ReadFromFile {
  public static void readFromFile() {
    try {
      System.setIn(new FileInputStream("input.txt"));
      System.setOut(new PrintStream(new FileOutputStream("output.txt")));
    } catch (Exception e) {
      System.err.println("Error while reading from the file");
    }
  }

}