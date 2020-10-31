package FerderalPoliceOffice;

import Employee.FederalPoliceOfficer;
import HandBaggage.HandBaggage;

public class Remote {
    private FederalPoliceOfficer federalPoliceOfficer;
    private Robot robot;

    public void destroyHandBaggage(HandBaggage handBaggage){
        robot.destroyHandBaggage(handBaggage);
    }

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
