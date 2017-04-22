import java.util.*;
import java.net.*;


public class ServiceThread extends Thread {
    Socket socket;

    private static int nextTicketNumber = 1;

    public ServiceThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader from_client = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter to_client = new PrintWriter(socket.getOutputStream());
            Object _ = from_client.readLine();

            to_client.println("Ticket Number: " + nextTicketNumber);
            nextTicketNumber++;

            to_client.close();
            from_client.close();
            socket.close();
        } catch (InterruptedException e) {
            System.err.println(e.stackTrace());
        }
    }
}
