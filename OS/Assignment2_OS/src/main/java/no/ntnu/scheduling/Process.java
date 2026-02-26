package no.ntnu.scheduling;

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

    public Process(String pid, int arrival, int burst, int order) {
        this.pid = pid;
        this.arrival = arrival;
        this.burst = burst;
        this.order = order;
        this.remaining = burst;
    }

    public Process copy() {
        return new Process(pid, arrival, burst, order);
    }
}