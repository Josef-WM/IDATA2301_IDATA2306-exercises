package no.ntnu.assignment3;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class implementing the SCAN algorithm (elevator algorithm, goes up and down)
 */
public class SCAN implements DiskScheduler {

  private static final int DISK_MIN = 0;
  private static final int DISK_MAX = 199;

  /**
   * Method for returning the name.
   *
   * @return the name
   */
  @Override
  public String getName() {
    return "SCAN";
  }

  /**
   * Method scheduling and returning the DiskResult.
   *
   * @param initialHead the initial head
   * @param direction the direction
   * @param requests requests
   * @return a DiskResult-object
   */
  @Override
  public DiskResult schedule(int initialHead, String direction, List<Integer> requests) {
    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();

    for (int request : requests) {
      if (request < initialHead) {
        left.add(request);
      } else {
        right.add(request);
      }
    }

    Collections.sort(left);
    Collections.sort(right);

    List<Integer> serviceOrder = new ArrayList<>();
    List<String> stepDetails = new ArrayList<>();

    int currentHead = initialHead;
    int totalMovement = 0;

    if ("right".equalsIgnoreCase(direction)) {
      // Serve right side ascending
      for (int request : right) {
        int movement = Math.abs(request - currentHead);
        totalMovement += movement;
        serviceOrder.add(request);
        stepDetails.add(currentHead + " -> " + request + " = " + movement);
        currentHead = request;
      }

      // Move to disk end if not already there
      if (currentHead != DISK_MAX) {
        int movement = Math.abs(DISK_MAX - currentHead);
        totalMovement += movement;
        stepDetails.add(currentHead + " -> " + DISK_MAX + " = " + movement + " (disk end)");
        currentHead = DISK_MAX;
      }

      // Reverse: serve left descending
      for (int i = left.size() - 1; i >= 0; i--) {
        int request = left.get(i);
        int movement = Math.abs(request - currentHead);
        totalMovement += movement;
        serviceOrder.add(request);
        stepDetails.add(currentHead + " -> " + request + " = " + movement);
        currentHead = request;
      }

    } else if ("left".equalsIgnoreCase(direction)) {
      // Serve left side descending
      for (int i = left.size() - 1; i >= 0; i--) {
        int request = left.get(i);
        int movement = Math.abs(request - currentHead);
        totalMovement += movement;
        serviceOrder.add(request);
        stepDetails.add(currentHead + " -> " + request + " = " + movement);
        currentHead = request;
      }

      // Move to disk start if not already there
      if (currentHead != DISK_MIN) {
        int movement = Math.abs(DISK_MIN - currentHead);
        totalMovement += movement;
        stepDetails.add(currentHead + " -> " + DISK_MIN + " = " + movement + " (disk end)");
        currentHead = DISK_MIN;
      }

      // Reverse: serve right ascending
      for (int request : right) {
        int movement = Math.abs(request - currentHead);
        totalMovement += movement;
        serviceOrder.add(request);
        stepDetails.add(currentHead + " -> " + request + " = " + movement);
        currentHead = request;
      }

    } else {
      throw new IllegalArgumentException("Direction must be 'left' or 'right'");
    }

    double averageSeekDistance = requests.isEmpty() ? 0.0 : (double) totalMovement / requests.size();

    return new DiskResult(
            getName(),
            serviceOrder,
            stepDetails,
            totalMovement,
            averageSeekDistance
    );
  }
}