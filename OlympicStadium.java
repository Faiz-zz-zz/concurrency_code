/*
    Author: Me
*/


public class OlympicStadium {
    private int westSeats = 0;
    private int eastSeats = 0;
    final int maxSeats = 9000;

    public synchronized void enterWest(Person person) {
        if (westSeats >= 5000 || (westSeats + eastSeats) >= maxSeats) wait();
        westSeats++;
        notifyAll();
    }

    public synchronized void enterEast(Person person) {
        if (eastSeats >= 5000 || (westSeats + eastSeats) >= maxSeats) wait();
        eastSeats++;
        notifyAll();
    }

    public synchronized void exitEast(Person person) {
        if (eastSeats <= 0) wait();
        eastSeats--;
        notifyAll();
    }

    public synchronized void exitWest(Person person) {
        if (westSeats <= 0) wait();
        westSeats--;
        notifyAll();
    }
}


/*
    In case of fire. just run

    make a boolean isFire and declare it volatile. and all the enter method should check if its true
    and if it is, dont let anyone in. Save all the people who enter in some sort of list,
    remove them from the list as soon as they leave. when evecuate() method is called,
    iterate through all the people and call .interrupt on them.
    Cheers! Shanice gets 10/10
*/
