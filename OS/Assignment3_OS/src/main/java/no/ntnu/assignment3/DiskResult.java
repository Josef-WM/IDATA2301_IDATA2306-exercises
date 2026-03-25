package no.ntnu.assignment3;
import java.util.List;

/**
 * Class representing the results.
 */
public class DiskResult {
  private final String algorithmName;
  private final List<Integer> serviceOrder;
  private final List<String> stepDetails;
  private final int totalHeadMovement;
  private final double averageSeekDistance;

  /**
   * Constructor for the Result class.
   *
   * @param algorithmName name of the algorithm
   * @param serviceOrder service order
   * @param stepDetails the step details
   * @param totalHeadMovement the total head movement
   * @param averageSeekDistance the average seek distance
   */
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

  /**
   * Method for getting the name of the algorithm.
   *
   * @return name of the algorithm.
   */
  public String getAlgorithmName() {
    return algorithmName;
  }

  /**
   * Method for getting the service order.
   *
   * @return a List-object of the services, in order.
   */
  public List<Integer> getServiceOrder() {
    return serviceOrder;
  }

  /**
   * Method for getting the step details.
   *
   * @return returns a List-object of the step details.
   */
  public List<String> getStepDetails() {
    return stepDetails;
  }

  /**
   * Method for getting the total head movement.
   *
   * @return int the total head movement.
   */
  public int getTotalHeadMovement() {
    return totalHeadMovement;
  }

  /**
   * Method for getting the average seek distance.
   *
   * @return double the average seek distance.
   */
  public double getAverageSeekDistance() {
    return averageSeekDistance;
  }
}