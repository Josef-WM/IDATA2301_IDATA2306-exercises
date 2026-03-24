package no.ntnu.assignment3;
import java.util.ArrayList;
import java.util.List;

public class SSTF implements DiskScheduler {

  @Override
  public String getName() {
    return "SSTF";
  }

  @Override
  public DiskResult schedule(int initialHead, String direction, List<Integer> requests) {
    List<Integer> remaining = new ArrayList<>(requests);
    List<Integer> serviceOrder = new ArrayList<>();
    List<String> stepDetails = new ArrayList<>();

    int currentHead = initialHead;
    int totalMovement = 0;

    while (!remaining.isEmpty()) {
      int closestIndex = 0;
      int closestDistance = Math.abs(remaining.get(0) - currentHead);

      for (int i = 1; i < remaining.size(); i++) {
        int distance = Math.abs(remaining.get(i) - currentHead);

        if (distance < closestDistance) {
          closestDistance = distance;
          closestIndex = i;
        } else if (distance == closestDistance) {
          // Tie-break: choose smaller cylinder number
          if (remaining.get(i) < remaining.get(closestIndex)) {
            closestIndex = i;
          }
        }
      }

      int nextRequest = remaining.remove(closestIndex);
      int movement = Math.abs(nextRequest - currentHead);
      totalMovement += movement;

      serviceOrder.add(nextRequest);
      stepDetails.add(currentHead + " -> " + nextRequest + " = " + movement);

      currentHead = nextRequest;
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