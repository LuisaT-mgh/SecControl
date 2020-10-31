package BaggageScanner;

import Employee.Supervisor;

public class Supervision {
    private Supervisor supervisor;
    private BaggageScanner baggageScanner;

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public BaggageScanner getBaggageScanner() {
        return baggageScanner;
    }

    public void setBaggageScanner(BaggageScanner baggageScanner) {
        this.baggageScanner = baggageScanner;
    }
}
