package no.ntnu.assignment3;
import java.util.Arrays;
import java.util.List;

/**
 * Starting point of the Java application.
 */
public class DiskSchedulingApp {

  // main method
  public static void main(String[] args) {
    DiskScheduler fcfs = new FCFS();
    DiskScheduler sstf = new SSTF();
    DiskScheduler scan = new SCAN();

    // Setting up the various cases. We did not implement
    // input from the user, as we were to implement already
    // specified test cases.

    // If we would like to have user input, we would import
    // the scanner class, and also error handle in case of
    // invalid/wrong input.

    // Setting up case 1
    int head1 = 53;
    String direction1 = "right";
    List<Integer> requests1 = Arrays.asList(98, 183, 37, 122, 14, 124, 65, 67);

    // Setting up case 2
    int head2 = 50;
    String direction2 = "right";
    List<Integer> requests2 = Arrays.asList(45, 48, 52, 90, 150, 160);

    // Setting up case 3
    int head3 = 15;
    String direction3 = "right";
    List<Integer> requests3 = Arrays.asList(10, 12, 14, 16, 100, 102);

    // Running all the cases
    runCase("Case1", head1, direction1, requests1, fcfs, sstf, scan);
    runCase("Case2", head2, direction2, requests2, fcfs, sstf, scan);
    runCase("Case3", head3, direction3, requests3, fcfs, sstf, scan);
  }

  /**
   * Method for running a 'case'.
   *
   * @param caseLabel label
   * @param initialHead initial head
   * @param direction the direction
   * @param requests request
   * @param fcfs 'first come first served'
   * @param sstf 'shortest seek time first'
   * @param scan scan
   */
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