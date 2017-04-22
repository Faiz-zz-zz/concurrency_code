public class RaceControl {
    private volatile boolean gun = false;
    private int position = 1;

    public synchronized void waitForGun() throws InterruptedException {
        while (!gun) wait();
    }

    public void fireGun() {
        gun = true;
        notifyAll();
    }

    public synchronized void startRunning() throws InterruptedException {
        Random random = new Random();
        Thread.sleep((random.nextInt(10) + 10) * 1000);
    }

    public int recordPosition() {
        return position++;
    }

    public static void main(String args[]) {
        OlympicRunner runners[] = new OlympicRunner[10];
        for(int i=0; i<10; i++) {
            runners[i] = new OlympicRunner(i, this);
        }
        for(OlympicRunner runner: runners) {
            runner.start();
        }
        fireGun();
        }
}


/*
    Take the synced code out of this.
    We use ReentrantLock as a mechanism to lock instead of synchronized keyword
    end of the line will unlocking the functions.
*/
