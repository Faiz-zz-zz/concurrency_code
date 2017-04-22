/*
    Author: ME
*/


// something is wrong with this code. cba to check it soz

public class Doctor {
    Hospital hospital;

    public Doctor (Hospital hospital) {
        this.hospital = hospital;
    }

    public void run() {
        try {
            while (true) {
                Random random = new Random();
                Patient patient = hospital.nextPatient();
                Thread.sleep(random.nextInt(2) * 1000);
                int temperature = patient.getTemperature();
                if (temperature > 40) {
                    patient.prescribe("Tamiflu");
                } else {
                    patient.prescribe("General painkiler")
                }
            }
        } catch (InterruptedException e) {
            System.err.println(e.stackTrace());
        }
    }
}
