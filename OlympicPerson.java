/*
    Author: Me
*/


public class OlympicPerson {
    OlympicStadium stadium;

    public OlympicPerson (OlympicStadium stadium) {
        this.stadium = stadium;
    }

    public void run() {
        try {
            this.stadium.enterWest(this);
            Random random = new Random();
            Thread.sleep(random.nextInt(10, 60) * 1000);
            this.stadium.exitWest(this);
        } catch (InterruptedException e) {
            System.err.println(e.stackTrace());
        }
    }
}
