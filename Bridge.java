public class Bridge {
    int weigthA = 0;
    int weightB = 0;
    int differenceCap = 2000;
    int capacity = 5000;

    public synchronized void enterA (Car car) throws InterruptedException {
        int carWeight = car.getWeight();
        while (weightA + weightB + carWeight > capacity || Math.abs(totalA - totalB) > differenceCap) wait();
        weightA += carWeight;
        notifyAll();
    }

    public synchronized void enterB(Car car) throws InterruptedException {
        int carWeight = car.getWeight();
        while (weightA + weightB + carWeight > capacity || Math.abs(totalA - totalB) > differenceCap) wait();
        weightB += carWeight;
        notifyAll();
    }

    public synchronized void exitA(Car car) throws InterruptedException {
        int carWeight = car.getWeight();
        while (Math.abs((weightA - carWeight) - weightB) > differenceCap) wait();
        weightA -= carWeight;
        notifyAll();
    }

    public synchronized void exitB(Car car) throws InterruptedException {
        int carWeight = car.getWeight();
        while (Math.abs(weightA - (weightB - carWeight)) > differenceCap) wait();
        weightB -= carWeight;
        notifyAll();
    }
}
