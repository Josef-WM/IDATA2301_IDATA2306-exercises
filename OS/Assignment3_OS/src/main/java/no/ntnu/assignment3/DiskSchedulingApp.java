package no.ntnu.assignment3;
import java.util.Arrays;
import java.util.List;

public class DiskSchedulingApp {

  public static void main(String[] args) {
    DiskScheduler fcfs = new FCFS();
    DiskScheduler sstf = new SSTF();
    DiskScheduler scan = new SCAN();

    // Case 1
    int head1 = 53;
    String direction1 = "right";
    List<Integer> requests1 = Arrays.asList(98, 183, 37, 122, 14, 124, 65, 67);

    // Case 2
    int head2 = 50;
    String direction2 = "right";
    List<Integer> requests2 = Arrays.asList(45, 48, 52, 90, 150, 160);

    // Case 3
    int head3 = 15;
    String direction3 = "right";
    List<Integer> requests3 = Arrays.asList(10, 12, 14, 16, 100, 102);

    // Run all cases
    runCase("Case1", head1, direction1, requests1, fcfs, sstf, scan);
    runCase("Case2", head2, direction2, requests2, fcfs, sstf, scan);
    runCase("Case3", head3, direction3, requests3, fcfs, sstf, scan);
  }

  private static void runCase(String caseLabel,
                              int initialHead,
                              String direction,
                              List<Integer> requests,
                              DiskScheduler fcfs,
                              DiskScheduler sstf,
                              DiskScheduler scan) {

    System.out.println("\n==================================================");
    System.out.println(caseLabel);
    System.out.println("Requests: " + requests);
    System.out.println("==================================================");

    DiskResult fcfsResult = fcfs.schedule(initialHead, direction, requests);
    DiskResult sstfResult = sstf.schedule(initialHead, direction, requests);
    DiskResult scanResult = scan.schedule(initialHead, direction, requests);

    ResultsPrinter.printDetailedResult(caseLabel, initialHead, direction, fcfsResult);
    ResultsPrinter.printDetailedResult(caseLabel, initialHead, direction, sstfResult);
    ResultsPrinter.printDetailedResult(caseLabel, initialHead, direction, scanResult);

    ResultsPrinter.printComparisonHeader();
    ResultsPrinter.printComparisonRow(caseLabel, fcfsResult);
    ResultsPrinter.printComparisonRow(caseLabel, sstfResult);
    ResultsPrinter.printComparisonRow(caseLabel, scanResult);
  }
}