package no.ntnu.scheduling;

import java.util.Comparator;
import java.util.List;

/**
 * Class for printing out the results.
 */
public class ResultsPrinter {

  /**
   * Method for printing the algorithm part of the table.
   *
   * @param algoName algorithm name.
   * @param ps process.
   */
  public static void printAlgorithmTable(String algoName, List<Process> ps) {
    ps.sort(Comparator.comparingInt(p -> p.order));

    System.out.println("\n--- " + algoName + " ---");
    System.out.printf("%-4s %-4s %-4s %-4s %-5s %-4s%n", "PID", "AT", "BT", "CT", "TAT", "WT");
    System.out.println("--------------------------------");

    for (Process p : ps) {
      System.out.printf("%-4s %-4d %-4d %-4d %-5d %-4d%n",
              p.pid, p.arrival, p.burst, p.completion, p.turnaround, p.waiting);
    }
  }

  /**
   * Method for calculating the averages.
   *
   * @param ps process
   * @return Results object of the averages.
   */
  public static Results computeAverages(List<Process> ps) {
    double sumWT = 0;
    double sumTAT = 0;
    for (Process p : ps) {
      sumWT += p.waiting;
      sumTAT += p.turnaround;
    }
    return new Results(ps, sumWT / ps.size(), sumTAT / ps.size());
  }

  /**
   * Method for printing the comparison parts of the table.
   *
   * @param caseLabel Label of the case
   * @param fcfs First Come First Served
   * @param sjf Shortest Job First
   * @param srtf Shortest Remaining Time first
   */
  public static void printComparisonTable(String caseLabel, Results fcfs, Results sjf, Results srtf) {
    System.out.println("\nPart B Comparison Table (Required)");
    System.out.println("Case     | Algo  | Avg WT | Avg TAT");
    System.out.println("------------------------------------");
    System.out.printf("%-8s | %-5s | %-6.2f | %-7.2f%n", caseLabel, "FCFS", fcfs.avgWT, fcfs.avgTAT);
    System.out.printf("%-8s | %-5s | %-6.2f | %-7.2f%n", caseLabel, "SJF",  sjf.avgWT,  sjf.avgTAT);
    System.out.printf("%-8s | %-5s | %-6.2f | %-7.2f%n", caseLabel, "SRTF", srtf.avgWT, srtf.avgTAT);
  }

  /**
   * Simple method for finalizing the times.
   *
   * @param ps process.
   */
  public static void finalizeTimes(List<Process> ps) {
    for (Process p : ps) {
      p.turnaround = p.completion - p.arrival; // TAT
      p.waiting = p.turnaround - p.burst;      // WT
    }
  }
}