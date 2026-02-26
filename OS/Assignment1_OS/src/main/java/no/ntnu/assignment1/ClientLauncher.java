package no.ntnu.assignment1;

import java.util.Random;

public class ClientLauncher {

  private static final char[] OPS = {'A', 'S', 'M', 'D'};

  public static void main(String[] args) throws InterruptedException {
    int n = 10;                 // number of simultaneous clients
    Random rng = new Random();

    Thread[] clients = new Thread[n];

    long start = System.currentTimeMillis();
    // we run calculations 10 times
    for (int i = 0; i < n; i++) {
      final int id = i;

      clients[i] = new Thread(() -> {
        // Random numbers
        int a = rng.nextInt(1, 101);      // 1..100
        int b = rng.nextInt(1, 101);      // 1..100 (never 0)
        char op = OPS[rng.nextInt(OPS.length)];

        // Extra safety: division should never divide by 0 (already avoided)
        if (op == 'D' && b == 0) b = 1;

        // Build request format: "a OP b"
        String[] requestArgs = {String.valueOf(a), String.valueOf(op), String.valueOf(b)};

        System.out.println("[Client " + id + "] Sending: " + a + " " + op + " " + b);
        Client.main(requestArgs);
      });

      clients[i].start();
    }

    // Wait until all finish
    for (Thread t : clients) {
      t.join();
    }

    long end = System.currentTimeMillis();
    System.out.println("Total time for " + n + " clients: " + (end - start) + " ms");
  }
}
