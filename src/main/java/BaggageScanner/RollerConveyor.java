package BaggageScanner;

import Employee.Inspector;

import java.util.Queue;

public class RollerConveyor {
    private Inspector inspector;
    private Queue<Tray> trays;
    private BaggageScanner baggageScanner;

    public Inspector getInspector() {
        return inspector;
    }

    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }

    public Queue<Tray> getTrays() {
        return trays;
    }

    public void setTrays(Queue<Tray> trays) {
        this.trays = trays;
    }

    public BaggageScanner getBaggageScanner() {
        return baggageScanner;
    }

    public void setBaggageScanner(BaggageScanner baggageScanner) {
        this.baggageScanner = baggageScanner;
    }
}
