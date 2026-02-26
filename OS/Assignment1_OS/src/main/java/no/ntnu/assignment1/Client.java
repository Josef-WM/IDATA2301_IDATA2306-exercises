package no.ntnu.assignment1;

import java.io.*;
import java.net.Socket;

public class Client {

  public static void main(String[] args) {
    // Allow custom request from args, or use default
    String request = (args.length >= 3)
            ? args[0] + " " + args[1] + " " + args[2]
            : "10 A 5";

    try (Socket socket = new Socket("localhost", 5050);
         PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
         BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

      out.println(request);
      String response = in.readLine();
      System.out.println("Request: " + request + " => Result: " + response);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
