import java.util.LinkedList;
import java.util.Queue;

public class Airport {
  static Queue<String> takeOffQueue = new LinkedList<>();
  static Queue<String> landQueue = new LinkedList<>();

  // Function to add to the takeoff queue
  public static void takeoff(String flightCode) {
    takeOffQueue.add(flightCode);
    System.out.println("[+] Added flight " + flightCode + " to takeoff queue");
  }

  // Function to add to the land queue
  public static void land(String flightCode) {
    landQueue.add(flightCode);
    System.out.println("[+] Added flight " + flightCode + " to land queue");
  }

  // Function to do the next resonable action
  public static void next() {
    if (!landQueue.isEmpty()) {
      String landed = landQueue.poll();
      System.out.println("[N] Flight " + landed + " has landed");
    } else if (!takeOffQueue.isEmpty()) {
      String tookOff = takeOffQueue.poll();
      System.out.println("[N] Flight " + tookOff + " has taken off");
    } else {
      System.out.println("[N] Queue's are empty");
    }
  }
}
