package no.ntnu.assignment1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

// this is the single-threaded server.
public class SingleThreadedServer {

  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(5050)) {
      System.out.println("Single-threaded server started on port 5050...");

      while (true) {
        Socket clientSocket = serverSocket.accept(); // BLOCKING
        handleClient(clientSocket);
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void handleClient(Socket socket) {
    try (
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
    ) {
      String input = in.readLine(); // BLOCKING
      System.out.println("Received: " + input);

      String[] parts = input.split(" ");
      double a = Double.parseDouble(parts[0]);
      char op = parts[1].charAt(0);
      double b = Double.parseDouble(parts[2]);

      double result = calculate(a, b, op);
      out.println(result);

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try { socket.close(); } catch (IOException ignored) {}
    }
  }

  private static double calculate(double a, double b, char op) {
    return switch (op) {
      case 'A' -> a + b;
      case 'S' -> a - b;
      case 'M' -> a * b;
      case 'D' -> a / b;
      default -> throw new IllegalArgumentException("Unknown operator: " + op);
    };
  }
}
