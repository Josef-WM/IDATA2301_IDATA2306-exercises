package no.ntnu.assignment1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// this is the multi-threaded server
public class MultiThreadedServer {

  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(5050)) {
      System.out.println("Multithreaded server started on port 5050...");

      while (true) {
        Socket clientSocket = serverSocket.accept(); // BLOCKING
        new Thread(new ClientHandler(clientSocket)).start();
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static class ClientHandler implements Runnable {
    private final Socket socket;

    ClientHandler(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {
      try (
              BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
              PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
      ) {
        String input = in.readLine(); // BLOCKING (only this thread)
        System.out.println("[" + Thread.currentThread().getName() + "] Received: " + input);

        String[] parts = input.split(" ");
        double a = Double.parseDouble(parts[0]);
        char op = parts[1].charAt(0);
        double b = Double.parseDouble(parts[2]);

        double result = calculate(a, b, op);
        // now we add Thread.sleep and see the difference
        Thread.sleep(2000);
        out.println(result);

      } catch (Exception e) {
        e.printStackTrace();
      } finally {
        try { socket.close(); } catch (IOException ignored) {}
      }
    }

    private double calculate(double a, double b, char op) {
      return switch (op) {
        case 'A' -> a + b;
        case 'S' -> a - b;
        case 'M' -> a * b;
        case 'D' -> a / b;
        default -> throw new IllegalArgumentException("Unknown operator: " + op);
      };
    }
  }
}
