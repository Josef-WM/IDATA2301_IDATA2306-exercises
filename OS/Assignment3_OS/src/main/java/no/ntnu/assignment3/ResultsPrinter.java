package no.ntnu.assignment3;
import java.util.List;

/**
 * Class for printing out the results.
 */
public class ResultsPrinter {

  /**
   * Method for printing out a detailed results table.
   *
   * @param caseName the name of the case (e.g. case1, case2, case3)
   * @param initialHead the initial head
   * @param direction the direction
   * @param result the result
   */
  public static void printDetailedResult(String caseName, int initialHead, String direction, DiskResult result) {
    System.out.println("\n--- " + result.getAlgorithmName() + " | " + caseName + " ---");
    System.out.println("Initial head: " + initialHead);
    System.out.println("Direction: " + direction);

    System.out.print("Service order: ");
    printServiceOrder(initialHead, result.getServiceOrder());

    System.out.println("Step-by-step movement:");
    for (String step : result.getStepDetails()) {
      System.out.println("  " + step);
    }

    System.out.println("Total head movement: " + result.getTotalHeadMovement());
    System.out.printf("Average seek distance: %.2f%n", result.getAverageSeekDistance());
  }

  /**
   * Method for printing the service order.
   *
   * @param initialHead the initial head
   * @param serviceOrder the service order
   */
  public static void printServiceOrder(int initialHead, List<Integer> serviceOrder) {
    StringBuilder sb = new StringBuilder();
    sb.append(initialHead);

    for (int request : serviceOrder) {
      sb.append(" -> ").append(request);
    }

    System.out.println(sb);
  }

  /**
   * Simple method for printing a comparison header for the tables.
   */
  public static void printComparisonHeader() {
    System.out.println("\n==============================================================");
    System.out.println("Case   | Algorithm | Total Head Movement | Average Seek Dist.");
    System.out.println("--------------------------------------------------------------");
  }

  /**
   * The method for printing the comparisons in a row, to be used in the tables.
   * @param caseLabel
   * @param result
   */
  public static void printComparisonRow(String caseLabel, DiskResult result) {
    System.out.printf("%-6s | %-9s | %-19d | %-18.2f%n",
            caseLabel,
            result.getAlgorithmName(),
            result.getTotalHeadMovement(),
            result.getAverageSeekDistance());
  }
}