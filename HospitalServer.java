/*
    Author: Me again
*/


public class HospitalServer {
    int uniqueNumber = 0;

    SeverSocket listen = null;

    public static void main(String args[]) {
        try {
            listen = new ServerSocket(9999);

            while(true) {
                Socket socket = listen.accept();
                BufferedReader from_client = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter to_client = new PrintWriter(socket.getOutputStream());

                int temperature = Integer.parseInt(from_client.readLine());

                if (temperature > 40) {
                    to_client.prinln(uniqueNumber);
                    uniqueNumber++;
                } else {
                    to_client.println("Not swine flu");
                }
                to_client.close();
                from_client.close();
                socket.close();
            } catch (Exception e) {
                System.err.println(e.stackTrace());

                try {
                    if (listen != null) listen.close();
                } catch (Exception e) {
                    System.err.println(e.stackTrace());
                }
            }
        }
    }
}
