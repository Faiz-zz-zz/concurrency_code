/*
    Author: hahahaahahahahaahahaha who tf cares
*/


public class Car extends Thread {
    private int weight;
    private Bridge bridge;

    public Car (int weight, Bridge bridge) {
        this.weight = weight;
        this.bridge = bridge;
    }

    public void run () {
        try {
            bridge.enterA(this);
            Random random = new Random();
            Thread.sleep(random.nextInt(2) * 60);
            bridge.exitA(this);
        } catch (InterruptedException e) {
            System.out.err(e.stackTrace());
        }
    }

    public int getWeight(){
        return this.weight;
    }
}
