/*
    Author: me
*/


public class Hospital {
    int numberOfPatients = 0;
    int numberOfDoctors;
    Patient[] patients;
    int currIndex = 0;

    public Hospital (int numberOfDoctors) {
        this.numberOfDoctors = numberOfDoctors;
        // syntax is horribly wrong lmao
        patients = new Patient[numberOfDoctors]<null>;
    }

    public synchronized void enterPatient(Patient patient) {
        while (numberOfPatients >= numberOfDoctors) wait();
        numberOfPatients++;
        currIndex = (currIndex + 1) % numberOfDoctors;
        patients[currIndex] = patient;
        notifyAll();
    }

    public synchronized void nextPatient() {
        while (numberOfPatients == 0) wait();
        numberOfPatients--;
        return patients[currIndex];
    }
}
