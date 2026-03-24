package no.ntnu.assignment3;
import java.util.List;

public class ResultsPrinter {

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

  public static void printServiceOrder(int initialHead, List<Integer> serviceOrder) {
    StringBuilder sb = new StringBuilder();
    sb.append(initialHead);

    for (int request : serviceOrder) {
      sb.append(" -> ").append(request);
    }

    System.out.println(sb);
  }

  public static void printComparisonHeader() {
    System.out.println("\n==============================================================");
    System.out.println("Case   | Algorithm | Total Head Movement | Average Seek Dist.");
    System.out.println("--------------------------------------------------------------");
  }

  public static void printComparisonRow(String caseLabel, DiskResult result) {
    System.out.printf("%-6s | %-9s | %-19d | %-18.2f%n",
            caseLabel,
            result.getAlgorithmName(),
            result.getTotalHeadMovement(),
            result.getAverageSeekDistance());
  }
}