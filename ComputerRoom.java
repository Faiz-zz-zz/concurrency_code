/*
    Author: hahahaahahahahaahahaha who tf cares
*/



//

import java.util.*;

public class ComputerRoom {
    private int computers = 20;
    private int studentsWaiting = 0;

    public synchronized void enter(Student student) {
        try {
            if (studentsWaiting < 5) {
                while (computers == 0) {
                    studentsWaiting++;
                    wait();
                    studentsWaiting--;
                }
                computers--;
                notifyAll();
            } else {
                student.interrupt();
            }
        } catch (InterruptedException e) {
            System.out.println(student.toString() + " left the room");
        }
    }

    public synchronized void exit(Student student) {
        while (computers == 20) {
            wait();
        }
        computers++;
        notifyAll();
    }
}
