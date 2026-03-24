package no.ntnu.assignment3;
import java.util.ArrayList;
import java.util.List;

public class FCFS implements DiskScheduler {

  @Override
  public String getName() {
    return "FCFS";
  }

  @Override
  public DiskResult schedule(int initialHead, String direction, List<Integer> requests) {
    List<Integer> serviceOrder = new ArrayList<>();
    List<String> stepDetails = new ArrayList<>();

    int currentHead = initialHead;
    int totalMovement = 0;

    for (int request : requests) {
      int movement = Math.abs(request - currentHead);
      totalMovement += movement;

      serviceOrder.add(request);
      stepDetails.add(currentHead + " -> " + request + " = " + movement);

      currentHead = request;
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