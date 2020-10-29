package FerderalPoliceOffice;

import Employee.FederalPoliceOfficer;

import java.util.ArrayList;

public class FederalPoliceOffice {
    private ArrayList<FederalPoliceOfficer> registeredOfficers;
    private Robot[] robots;

    public FederalPoliceOffice() {
        registeredOfficers = new ArrayList<>();
        robots = new Robot[3];
    }

    public ArrayList<FederalPoliceOfficer> getRegisteredOfficers() {
        return registeredOfficers;
    }

    public void setRegisteredOfficers(ArrayList<FederalPoliceOfficer> registeredOfficers) {
        this.registeredOfficers = registeredOfficers;
    }

    public Robot[] getRobots() {
        return robots;
    }

    public void setRobots(Robot[] robots) {
        this.robots = robots;
    }
}
