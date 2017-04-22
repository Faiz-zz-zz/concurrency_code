/*
    Author: Me
*/

public class OlympicServer {
    ServerSocket listen = null;

    private static volatile ArrayList<boolean> seats;

    public static void main (String args[]) {
        try {
            listen = new ServerSocket(9999);

            while (true) {
                Socket socket = listen.accept();
                BufferedReader from_client = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter to_client = new PrintWriter(socket.getOutputStream());

                int seatRequested = Integer.parseInt(from_client.readLine());

                if (seatRequested < 1 || seatRequested > 9000) to_client.println('failure');

                if (!seats[seatRequested - 1]) {
                    to_client.println('yes');
                    seats[seatRequested - 1] = true;
                } else {
                    to_client('no');
                }

                from_client.close();
                to_client.close();
                socket.close();
            }
        } catch (Exception e) {
            System.out.print(e.stackTrace());

            try {
                if (listen != null) listen.close();
            } catch (InterruptedException e) {
                System.err.println("error haha");
            }
        }
    }
}
