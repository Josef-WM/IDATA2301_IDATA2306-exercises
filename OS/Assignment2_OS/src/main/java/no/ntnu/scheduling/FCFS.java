package no.ntnu.scheduling;

import java.util.Comparator;
import java.util.List;

/**
 * Class implementing the (F)irst (C)ome (F)irst (S)erved 'algorithm'.
 */
public class FCFS implements Scheduler {

  /**
   * Method for returning the name.
   *
   * @return the name
   */
  @Override
  public String name() {
    return "FCFS (non-preemptive)";
  }

  /**
   * Method scheduling and returning process
   */
  @Override
  public List<Process> schedule(List<Process> ps) {
    ps.sort(Comparator.comparingInt((Process p) -> p.arrival).thenComparingInt(p -> p.order));

    int time = 0;
    for (Process p : ps) {
      if (time < p.arrival) time = p.arrival; // CPU idle
      time += p.burst;
      p.completion = time;
    }

    ResultsPrinter.finalizeTimes(ps);
    return ps;
  }
}