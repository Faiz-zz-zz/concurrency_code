public class CountingSemaphore {
    int count = 0;
    public CountingSemaphore (int count) {
        this.count = count;
    }

    public synchronized void up () {
        count++;
        notifyAll();
    }

    public synchronized void down() throws InterruptedException {
        if (count == 0) wait();
        count++;
        notifyAll();
    }

    public int getValue() {
        return this.count;
    }
}
