public class Basket {
    private int capacity = 1000;
    private Farmer farmer;

    public Basket(Farmer farmer) {
        this.farmer = farmer;
    }

    public synchronized void putApple() throws InterruptedException {
        while (capacity == 0) wait();
        if (capacity == 1) farmer.wakeup();
        capacity--;
        notifyAll();
    }

    public synchronized  void emptyBasket() {
        while (capacity != 0) wait();
        this.capacity = 1000;
        notifyAll();
    }
}
