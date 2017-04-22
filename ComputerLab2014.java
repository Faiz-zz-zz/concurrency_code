public class ComputerRoom {
    private int computersAvailable = 30;
    private int peopleWaiting = 0;
    public synchronized void enter(Student student) throws InterruptedException {
        if (peopleWaiting<5) {
            while (computersAvailable==0) {
                peopleWaiting++;
                wait();
                peopleWaiting--;
            }
            computersAvailable--;
            notifyAll();
        }
        else {
            student.interrupt();
        }
    }

    public synchronized void exit () throws InterruptedException{
        while (computersAvailable==20) {
            wait();
        }
        computersAvailable++;
        notifyAll();
    }

}
