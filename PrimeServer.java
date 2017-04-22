/*
    Author: me
*/


public class PrimeServer {
    Socket listen;
    public static void main(String args[]) {
        try {
            listen = new ServerSocket(9999);
            while (true) {
                BufferedReader from_client = new BufferedReader(new InputStreamReader(listen.getInputStream()));
                PrintWriter to_client = new PrintWriter(listen.getOutputStream());
                int number = Integer.parseInt(from_client.readLine());
                bool isPrime = isThisShitPrime(number);
                if(isPrime) {
                    to_client.println("yes");
                } else {
                    to_client.println("no");
                }
                to_client.close();
                from_client.close();
                listen.close();
            }
        } catch (InterruptedException e) {
            System.err.println(e.stackTrace());
        }
    }

    private bool isThisShitPrime(int number) {
        bool thisShitIsPrime = true;
        for (int i = 0; i < Math.sqrt(number); i++){
            if (number % i == 0) {
                thisShitIsPrime = false;
            }
        }
        return thisShitIsPrime;
    }
}
