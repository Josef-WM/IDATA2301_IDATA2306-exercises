package no.ntnu.assignment3;
import java.util.List;

public interface DiskScheduler {
  String getName();
  DiskResult schedule(int initialHead, String direction, List<Integer> requests);
}