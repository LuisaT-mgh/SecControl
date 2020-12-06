package BaggageScanner;

import Employee.Inspector;

import java.util.LinkedList;
import java.util.Queue;

public class RollerConveyor {
    private Inspector inspector;
    private Queue<Tray> trays;
    private BaggageScanner baggageScanner;

    public RollerConveyor() {
        trays = new LinkedList<Tray>();
    }

    public Inspector getInspector() {
        return inspector;
    }

    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }

    public Queue<Tray> getTrays() {
        return trays;
    }

    public BaggageScanner getBaggageScanner() {
        return baggageScanner;
    }

    public void setBaggageScanner(BaggageScanner baggageScanner) {
        this.baggageScanner = baggageScanner;
    }
}
