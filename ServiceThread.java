import java.util.*;
import java.net.*;


public class ServiceThread extends Thread {
    Socket socket;

    // Static integer is not thread-safe http://stackoverflow.com/questions/7442559/thread-safety-for-static-variables
    private static AtomicInteger nextTicketNumber = new AtomicInteger(1);

    public ServiceThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader from_client = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter to_client = new PrintWriter(socket.getOutputStream());
            Object _ = from_client.readLine();

            to_client.println("Ticket Number: " + nextTicketNumber.incrementAndGet());

            to_client.close();
            from_client.close();
            socket.close();
        } catch (InterruptedException e) {
            System.err.println(e.stackTrace());
        }
    }
}
