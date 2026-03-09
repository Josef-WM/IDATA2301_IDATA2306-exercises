package no.ntnu.scheduling;

import java.util.List;

public class Results {
  public final List<Process> processes; // scheduled + computed
  public final double avgWT;
  public final double avgTAT;

  public Results(List<Process> processes, double avgWT, double avgTAT) {
    this.processes = processes;
    this.avgWT = avgWT;
    this.avgTAT = avgTAT;
  }
}