package no.ntnu.scheduling;

import java.util.List;

/**
 * Interface class representing the Scheduler.
 */
public interface Scheduler {
  String name();
  List<Process> schedule(List<Process> processes);
}