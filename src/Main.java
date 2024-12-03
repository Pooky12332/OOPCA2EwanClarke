import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    flightMenu();
  }

  public static void flightMenu() {
    Scanner kb = new Scanner(System.in);
    Airport airport = new Airport();
    System.out.print("> ");
    String input = kb.nextLine();;

    if (input.contains("takeoff")) {
      airport.takeoff(input.substring(8));
    } else if (input.contains("land")) {
      airport.land(input.substring(5));
    } else if (input.equals("next")) {
      airport.next();
    } else if (input.equals("quit")) {
      System.exit(0);
    }

    System.out.print("\n");
    flightMenu();
  }
}