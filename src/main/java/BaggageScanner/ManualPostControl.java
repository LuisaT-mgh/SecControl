package BaggageScanner;

import Employee.Inspector;
import Employee.Supervisor;
import HandBaggage.HandBaggage;
import Passenger.Passenger;
import BaggageScanner.Tray;

import java.util.ArrayList;

public class ManualPostControl {
    private Inspector inspector;
    private Passenger passengerManualPostControl;
    private Supervisor supervisorForWeaponFound;
    private Tray trayWithBaggageInManualPostControl;
    private ArrayList<HandBaggage> confiscatedHandBaggage = new ArrayList<>();
    private BaggageScanner baggageScanner;
    private boolean hasToBeConfiscated = false;
    private ExplosiveTraceDetector explosiveTraceDetector;

    public Inspector getInspector() {
        return inspector;
    }

    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }

    public Passenger getPassengerManualPostControl() {
        return passengerManualPostControl;
    }

    public void setPassengerManualPostControl(Passenger passengerManualPostControl) {
        this.passengerManualPostControl = passengerManualPostControl;
    }

    public Supervisor getSupervisorForWeaponFound() {
        return supervisorForWeaponFound;
    }

    public void setSupervisorForWeaponFound(Supervisor supervisorForWeaponFound) {
        this.supervisorForWeaponFound = supervisorForWeaponFound;
    }


    public Tray getTrayWithBaggageInManualPostControl() {
        return trayWithBaggageInManualPostControl;
    }

    public void setTrayWithBaggageInManualPostControl(Tray trayWithBaggageInManualPostControl) {
        this.trayWithBaggageInManualPostControl = trayWithBaggageInManualPostControl;
    }

    public BaggageScanner getBaggageScanner() {
        return baggageScanner;
    }

    public void setBaggageScanner(BaggageScanner baggageScanner) {
        this.baggageScanner = baggageScanner;
    }

    public ArrayList<HandBaggage> getConfiscatedHandBaggage() {
        return confiscatedHandBaggage;
    }

    public void setConfiscatedHandBaggage(ArrayList<HandBaggage> confiscatedHandBaggage) {
        this.confiscatedHandBaggage = confiscatedHandBaggage;
    }

    public boolean isHasToBeConfiscated() {
        return hasToBeConfiscated;
    }

    public void setHasToBeConfiscated(boolean hasToBeConfiscated) {
        this.hasToBeConfiscated = hasToBeConfiscated;
    }

    public ExplosiveTraceDetector getExplosiveTraceDetector() {
        return explosiveTraceDetector;
    }

    public void setExplosiveTraceDetector(ExplosiveTraceDetector explosiveTraceDetector) {
        this.explosiveTraceDetector = explosiveTraceDetector;
    }
}
