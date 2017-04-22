/*
    Author: me
    Restaurent Server
*/

public class ServiceSocket {
    public static void main(String args[]) {

        ServerSocket listen = null;

        try {

            listen = new ServerSocket(9999);

            while (true) {
                Socket socket = listen.accept();
                BufferedReader from_client = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter to_client = new PrintWriter(socket.getOutputStream());
                int request = Integer.parseInt(from_client.readLine());

                if (request == 0) {
                    String response = "";
                    for (int i = 0; i < 5; i++) {
                        if (seats[i]) {
                            response += (i + 1) + ", ";
                        }
                    }
                    if (response.length() > 0) {
                        response = response.substring(0, response.length() - 2); // strip last comma
                    }
                } else if (request < 6 && request > 0) {
                    if (seats[request - 1]) {
                        seats[request - 1] = false;
                        to_client.println("yes");
                    } else {
                        to_client.println("no");
                    }
                } else {
                    to_client.println("Invalid Request");
                }

                to_client.close();
                from_client.close();
                socket.close();
            }
        } catch (Exception e) {
            System.err.println(e);

            try {
                if (listen != null) listen.close();
            } catch (IOException except) {
                System.err.println("Exception trying to close socket: " + except);
            }
        }
    }
}
