package no.ntnu.scheduling;

import java.util.List;

public class SJF implements Scheduler {

  @Override
  public String name() {
    return "SJF (non-preemptive)";
  }

  @Override
  public List<Process> schedule(List<Process> ps) {
    int n = ps.size();
    boolean[] done = new boolean[n];
    int finished = 0;
    int time = 0;

    while (finished < n) {
      int chosen = -1;

      for (int i = 0; i < n; i++) {
        Process p = ps.get(i);
        if (!done[i] && p.arrival <= time) {
          if (chosen == -1) chosen = i;
          else {
            Process c = ps.get(chosen);
            if (p.burst < c.burst
                    || (p.burst == c.burst && p.arrival < c.arrival)
                    || (p.burst == c.burst && p.arrival == c.arrival && p.order < c.order)) {
              chosen = i;
            }
          }
        }
      }

      if (chosen == -1) {
        // jump to next arrival if CPU is idle
        int nextArrival = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
          if (!done[i]) nextArrival = Math.min(nextArrival, ps.get(i).arrival);
        }
        time = nextArrival;
        continue;
      }

      Process run = ps.get(chosen);
      time += run.burst;   // non-preemptive: run to completion
      run.completion = time;

      done[chosen] = true;
      finished++;
    }

    ResultsPrinter.finalizeTimes(ps);
    return ps;
  }
}