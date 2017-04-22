public class RestaurentClient {

    public static void main(String[] args) {
        try {
            String host = args[0];
            String filename = args[1];

            Socket socket = new Socket(host, 9999);
            BufferedReader from_server = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter to_server = new PrintWriter(socket.getOutputStream());

            to_server.println("0");
            to_server.flush();

            String line;

            while ((line = from_server.readLine()) != null) {
                System.out.println(line);
            }

            socket.close();
        } catch (Exception e) {
            System.err.println(e);
        }
    }

}
