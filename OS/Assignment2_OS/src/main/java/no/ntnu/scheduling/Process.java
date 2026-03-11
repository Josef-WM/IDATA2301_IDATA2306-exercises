package no.ntnu.scheduling;

/**
 * Class representing a Process object.
 */
public class Process {
  public final String pid;
  public final int arrival;
  public final int burst;
  public final int order;      // original input order (tie-break)

  // Computed:
  public int completion;
  public int turnaround;
  public int waiting;

  // For SRTF:
  public int remaining;

  /**
   * Constructor for Process object.
   *
   * @param pid process id.
   * @param arrival arrival time.
   * @param burst burst time.
   * @param order order.
   */
  public Process(String pid, int arrival, int burst, int order) {
    this.pid = pid;
    this.arrival = arrival;
    this.burst = burst;
    this.order = order;
    this.remaining = burst;
  }

  /**
   * Method for copying process
   *
   * @return copied Process.
   */
  public Process copy() {
    return new Process(pid, arrival, burst, order);
  }
}