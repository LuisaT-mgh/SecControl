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
}
