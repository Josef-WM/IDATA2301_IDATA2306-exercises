package no.ntnu.assignment3;
import java.util.List;

public class DiskResult {
  private final String algorithmName;
  private final List<Integer> serviceOrder;
  private final List<String> stepDetails;
  private final int totalHeadMovement;
  private final double averageSeekDistance;

  public DiskResult(String algorithmName,
                    List<Integer> serviceOrder,
                    List<String> stepDetails,
                    int totalHeadMovement,
                    double averageSeekDistance) {
    this.algorithmName = algorithmName;
    this.serviceOrder = serviceOrder;
    this.stepDetails = stepDetails;
    this.totalHeadMovement = totalHeadMovement;
    this.averageSeekDistance = averageSeekDistance;
  }

  public String getAlgorithmName() {
    return algorithmName;
  }

  public List<Integer> getServiceOrder() {
    return serviceOrder;
  }

  public List<String> getStepDetails() {
    return stepDetails;
  }

  public int getTotalHeadMovement() {
    return totalHeadMovement;
  }

  public double getAverageSeekDistance() {
    return averageSeekDistance;
  }
}