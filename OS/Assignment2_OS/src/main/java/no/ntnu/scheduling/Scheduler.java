package no.ntnu.scheduling;

import java.util.List;

public interface Scheduler {
  String name();
  List<Process> schedule(List<Process> processes);
}