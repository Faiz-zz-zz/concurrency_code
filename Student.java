/*
    Author: hahahaahahahahaahahaha who tf cares
*/


public class Student extends Thread {
    public int id;
    Random rand = new Random();
    ComputerRoom room;

    public Student (ComputerRoom room, int id) {
        this.room = room;
        this.id = id;
    }
    public void run() {
        try {
            Thread.sleep((long) rand.nextInt(2)*1000);
            room.enter(this);
            if (interrupted()) throw new InterruptedException();
            Thread.sleep(10000);
            room.exit();
        } catch (InterruptedException e) {
            System.out.println("poor guy left, ucl get your things right");
        }

    }
}
