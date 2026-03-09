package no.ntnu.scheduling;

import java.util.List;

public class SRTF implements Scheduler {

  @Override
  public String name() {
    return "SRTF (preemptive)";
  }

  @Override
  public List<Process> schedule(List<Process> ps) {
    int n = ps.size();
    int finished = 0;
    int time = 0;

    // init remaining
    for (Process p : ps) p.remaining = p.burst;

    while (finished < n) {
      int chosen = -1;

      for (int i = 0; i < n; i++) {
        Process p = ps.get(i);
        if (p.arrival <= time && p.remaining > 0) {
          if (chosen == -1) chosen = i;
          else {
            Process c = ps.get(chosen);
            if (p.remaining < c.remaining
                    || (p.remaining == c.remaining && p.arrival < c.arrival)
                    || (p.remaining == c.remaining && p.arrival == c.arrival && p.order < c.order)) {
              chosen = i;
            }
          }
        }
      }

      if (chosen == -1) {
        time++; // CPU idle for one unit
        continue;
      }

      Process run = ps.get(chosen);
      run.remaining--;
      time++;

      if (run.remaining == 0) {
        run.completion = time;
        finished++;
      }
    }

    ResultsPrinter.finalizeTimes(ps);
    return ps;
  }
}