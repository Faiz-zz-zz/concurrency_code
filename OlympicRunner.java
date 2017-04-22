public class Runner extends Thread {

    private String name;
    private RaceControl raceControl;
    private int position;

    public void OlympicRunner(String name, RaceControl raceControl) {
        this.name = name;
        this.raceControl = raceControl;
    }

    public setPosition(int position) {
        this.position = position;
    }

    public void run() {
        System.out.print(name + " waiting for start\n");
        raceControl.waitForGun();
        raceControl.startRunning();
        raceControl.recordPosition();
    }
}
