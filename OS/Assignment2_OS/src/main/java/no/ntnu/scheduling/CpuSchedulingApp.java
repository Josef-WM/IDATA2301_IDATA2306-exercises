package no.ntnu.scheduling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CpuSchedulingApp {

  static void main() {

    List<Process> case1 = Arrays.asList(
            new Process("P1", 0, 8, 0),
            new Process("P2", 0, 4, 1),
            new Process("P3", 0, 2, 2),
            new Process("P4", 0, 6, 3),
            new Process("P5", 0, 3, 4)
    );

    List<Process> case2 = Arrays.asList(
            new Process("P1", 0, 20, 0),
            new Process("P2", 1, 2, 1),
            new Process("P3", 2, 2, 2),
            new Process("P4", 3, 1, 3),
            new Process("P5", 4, 3, 4)
    );

    List<Process> case3 = Arrays.asList(
            new Process("P1", 0, 20, 0),
            new Process("P2", 1, 2, 1),
            new Process("P3", 2, 2, 2),
            new Process("P4", 3, 2, 3),
            new Process("P5", 4, 2, 4),
            new Process("P6", 5, 2, 5)
    );

    runCase("Case1", "CASE 1 (all AT=0)", case1);
    runCase("Case2", "CASE 2 (long job then short arrivals)", case2);
    runCase("Case3", "CASE 3 (starvation risk)", case3);
  }

  private static void runCase(String label, String title, List<Process> base) {
    System.out.println("\n==================================================");
    System.out.println(title);
    System.out.println("==================================================");

    Scheduler fcfs = new FCFS();
    Scheduler sjf = new SJF();
    Scheduler srtf = new SRTF();

    List<Process> outFCFS = fcfs.schedule(copy(base));
    List<Process> outSJF  = sjf.schedule(copy(base));
    List<Process> outSRTF = srtf.schedule(copy(base));

    ResultsPrinter.printAlgorithmTable(fcfs.name(), outFCFS);
    ResultsPrinter.printAlgorithmTable(sjf.name(), outSJF);
    ResultsPrinter.printAlgorithmTable(srtf.name(), outSRTF);

    Results r1 = ResultsPrinter.computeAverages(outFCFS);
    Results r2 = ResultsPrinter.computeAverages(outSJF);
    Results r3 = ResultsPrinter.computeAverages(outSRTF);

    ResultsPrinter.printComparisonTable(label, r1, r2, r3);
  }

  private static List<Process> copy(List<Process> base) {
    List<Process> out = new ArrayList<>();
    for (Process p : base) out.add(p.copy());
    return out;
  }
}