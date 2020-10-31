package FerderalPoliceOffice;

import Employee.FederalPoliceOfficer;

public class Remote {
    private FederalPoliceOfficer federalPoliceOfficer;
    private Robot robot;

    public FederalPoliceOfficer getFederalPoliceOfficer() {
        return federalPoliceOfficer;
    }

    public void setFederalPoliceOfficer(FederalPoliceOfficer federalPoliceOfficer) {
        this.federalPoliceOfficer = federalPoliceOfficer;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }
}
