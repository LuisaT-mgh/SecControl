package FerderalPoliceOffice;

import Employee.FederalPoliceOfficer;

import java.util.ArrayList;

public class FederalPoliceOffice {
    private ArrayList<FederalPoliceOfficer> registeredOfficers;
    private Robot[] robots;

    public FederalPoliceOffice() {
        registeredOfficers = new ArrayList<>();
        robots = new Robot[3];
        for (int i = 0; i < 3; i++) {
            Remote remote = new Remote();
            robots[i] = new Robot(remote);
            remote.setRobot(robots[i]);
        }
    }

    public ArrayList<FederalPoliceOfficer> getRegisteredOfficers() {
        return registeredOfficers;
    }

    public Robot[] getRobots() {
        return robots;
    }
}
