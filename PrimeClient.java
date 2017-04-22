/*
    Author: Lord Faiz Batton
*/

public class PrimeClient {
    public static void main(String[] args){
        Socket socket = new ServerSocket(args[0], 9999);
        BufferedReader from_server = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter to_server = new PrintWriter(socket.getOutputStream());
        to_server.println("923829584985365893645873658734658375638756384562836492387429387424"); // Int overflow lmao
        to_server.flush();

        String answer = from_server.readLine();
        if(answer == "yes") {
            System.out.print("Party!!!!!");
        } else {
            System.out.print("Partyyyyy! why not");
        }
    }
}
