public class Child extends Thread {
    Basket basket;
    public Child(Basket basket) {
        this.basket = basket;
    }

    public void run() {
        try {
            for(int i = 0; i < 500; i++) {
                Thread.sleep(30 * 1000);
                basket.putApple();
            }
        } catch (InterruptedException e) {
            System.err.println(e.stackTrace());
        }
    }
}
