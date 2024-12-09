import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.Stack;

public class TagReader {
  public static void main(String[] args) {
    checkTags("index.html");
  }

  public static void checkTags(String filename) {
    boolean filePassed = true;

    try {
      File htmlFile = new File(filename);
      Scanner htmlScanner = new Scanner(htmlFile);
      while (htmlScanner.hasNextLine()) {
        String line = htmlScanner.nextLine();
        filePassed = indexLine(line);
      }
    } catch (FileNotFoundException e) {
      System.out.println("No file called " + filename + " found.");
      System.exit(0);
    }

    // Basic output depending on linePassed
    if (filePassed) {
      System.out.println("All tags in the given file are closed correctly.");
    } else {
      System.out.println("A tag in your file doesnt close. Double check your tags");
    }
    System.exit(0);
  }

  public static boolean indexLine(String line) {
    Stack<String> tagStack = new Stack<String>();
    // Splitting the line via the given space
    String[] tags = line.split(" ");

    for (String tag : tags) {
      // Checking to make sure the element is an actual tag
      if ((tag.startsWith("<")) && (tag.endsWith(">"))) {
        // Opening tag and closing tag logic
        if (!tag.startsWith("</")) { // If opening tag:
          if (!tag.equals("<br>")) {
            tagStack.push(tag);
          }
        } else { // If closing tag:
          // Check to see if there is a tag in the stack
          String closingTag = tag.substring(2, tag.length() - 1);

          if (tagStack.isEmpty()) {
            return false;
          }

          // Since there are tags in the stack, we take the first one and check to see that they match
          String openingTag = tagStack.pop();
          String expectedTag = openingTag.substring(1, openingTag.length() - 1);

          if (!expectedTag.equals(closingTag)) {
            return false;
          }
        }
      }
    }

    return tagStack.isEmpty();
  }
}