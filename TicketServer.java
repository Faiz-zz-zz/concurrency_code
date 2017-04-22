public class TicketServer {
    ServerSocket listen;

    public static void main(String args[]) {
        listen = new ServerSocket(9999);

        try {
            while (true) {
                Socket socket = listen.accept();
                ServiceThread thread = new ServiceThread(socket);
                thread.start();
            }
        } catch (InterruptedException e) {
            System.err.print(e.stackTrace());
        }
    }
}
