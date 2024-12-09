import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;

public class TagReader {
  public static void checkTags(String filename) {
    try {
      File htmlFile = new File(filename);
      Scanner htmlScanner = new Scanner(htmlFile);
      while (htmlScanner.hasNextLine()) {
        String line = htmlScanner.nextLine();
        indexLine(line);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  public static void indexLine(String line) {
    // Divide the line using the ">" char
    

    // Place tags into an array


    // Check the tags array
      // Index the open tags
      // Index if we closed any open tags

  }
}