public class Shop {
    private int people = 0;
    private int capacity = 10;
    private int children = 0;
    private int childrenCapacity = 5;

    public synchronized void childEnter(Child child) {
        while (children >= childrenCapacity || people >= capacity) wait();
        children++;
        people++;
        notifyAll();
    }

    public synchronized void adultEnter(Adult adult) {
        while (people >= capacity) wait();
        people++;
        notifyAll();
    }

    public synchronized void exitChildren(Child child) {
        while (children <= 0) wait();
        children--;
        people--;
        notifyAll();
    }

    public synchronized void exitAdult(Adult adult) {
        while (people <= 0) wait();
        people--;
        notifyAll();
    }
}
