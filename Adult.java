public class Adult {
    Shop shop;

    public Adult (Shop shop) {
        this.shop = shop;
    }

    public void run() {
        try {
            shop.enterAdult(this);
            Thread.sleep(10 * 60 * 1000);
            shop.exit();
        } catch (InterruptedException e) {
            System.err.println("System error");
        }
    }
}


/*
    When the fire alarm goes off, calling .interrupt will force all the
    Adult thread to immediately stop what ever they are doing and the programmer
    has full control over what to do with the threads. Since the .sleep(), .wait() methods will
    interrupt immediately, and if the threads arent emplying these methods, it uses a status flag to
    .interrupted periodically check if its interrupted
*/
