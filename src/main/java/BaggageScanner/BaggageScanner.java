package BaggageScanner;

import Employee.FederalPoliceOfficer;
import Employee.IDCard;
import Employee.ProfileType;
import Passenger.Passenger;

import java.util.ArrayList;
import java.util.Stack;

public class BaggageScanner implements IHasButton {
    private Belt belt;
    private ManualPostControl manualPostControl;
    private OperatingStation operatingStation;
    private RollerConveyor rollerConveyor;
    private Scanner scanner;
    private Status status;
    private Supervision supervision;
    private Stack<Tray> trays;
    private Button powerButton;
    private Track[] tracks;
    private FederalPoliceOfficer federalPoliceOfficer;
    private ArrayList<Record> records;
    private Passenger currentPassenger;

    public BaggageScanner(Track[] tracks, Belt belt, ManualPostControl manualPostControl, OperatingStation operatingStation, RollerConveyor rollerConveyor, Scanner scanner, Supervision supervision, Stack<Tray> trays) {
        this.belt = belt;
        this.manualPostControl = manualPostControl;
        this.operatingStation = operatingStation;
        this.rollerConveyor = rollerConveyor;
        this.scanner = scanner;
        this.supervision = supervision;
        this.trays = trays;
        this.tracks = tracks;
        powerButton = new Button(this);
        powerButton.setShape(ButtonShape.POWER_BUTTON_SHAPE);
        records = new ArrayList<Record>();

        status = Status.SHUTDOWN;
    }

    public boolean moveBeltForward(IDCard idCard) {
        if (validateAuthorisationInspector(idCard)) {
            System.out.println("Tray has been moved to entrance of scanner");
            return true;
        } else {
            System.out.println("Unauthorised call of move belt forward");
            return false;
        }
    }

    public boolean moveBeltBackwards(IDCard idCard) {
        if (validateAuthorisationInspector(idCard)) {
            System.out.println("MoveBeltBackwards has been called");
            return true;
        } else {
            System.out.println("Unauthorised call of moveBeltBackwards");
            return false;
        }
    }

    public boolean scan(IDCard idCard) {
        status = Status.IN_USE;
        System.out.println("Baggage scanner in use");
        String itemFound = null;
        if (validateAuthorisationInspector(idCard)) {
            itemFound = scanner.scan();
        } else {
            System.out.println("Unauthorised call of scan");
            return false;
        }
        if (itemFound == null) {
            status = Status.ACTIVATED;
            System.out.println("Baggage scanner activated");
        }
        return true;
    }

    public boolean alarm(IDCard idCard, String itemFound) {
        if (validateAuthorisationInspector(idCard)) {
            System.out.println("Alarm has been called");
            status = Status.LOCKED;
            System.out.println("Baggage scanner is now locked");
            federalPoliceOfficer.setItemToTakeCareOf(itemFound);
            return true;
        } else {
            System.out.println("Unauthorised call of alarm");
            return false;
        }
    }

    public boolean report(IDCard idCard) {
        if (String.valueOf(idCard.getMagnetStripe().charAt(0)).equals(String.valueOf(ProfileType.S))) {
            System.out.println("Report has been called");
            return true;
        } else {
            System.out.println("Unauthorised call of report");
            return false;
        }
    }

    public boolean maintenance(IDCard idCard) {
        if (String.valueOf(idCard.getMagnetStripe().charAt(0)).equals(String.valueOf(ProfileType.T))) {
            System.out.println("BaggageScanner is maintained");
            return true;
        } else {
            System.out.println("Unauthorised maintenance try");
            return false;
        }
    }

    public void start(IDCard idCard) {
        if (String.valueOf(idCard.getMagnetStripe().charAt(0)).equals(String.valueOf(ProfileType.S))) {
            status = Status.START;
            System.out.println("Baggage Scanner was started");
            status = Status.DEACTIVATED;
            System.out.println("Baggage Scanner is still in status deactivated");
        } else {
            System.out.println("Unauthorised attempt to start baggage scanner");
        }
    }

    public void deactivate(IDCard idCard) {
        if (String.valueOf(idCard.getMagnetStripe().charAt(0)).equals(String.valueOf(ProfileType.S))) {
            status = Status.SHUTDOWN;
            System.out.println("Baggage Scanner was shut down");
        } else {
            System.out.println("Unauthorised attempt to shut down baggage scanner");
        }
    }

    private boolean validateAuthorisationInspector(IDCard card) {
        if (!card.isLocked()) {
            switch (card.getMagnetStripe().charAt(0)) {
                case 'S':
                case 'K':
                case 'O':
                case 'T':
                    return false;
                case 'I':
                    return true;
            }
        }
        return false;
    }

    @Override
    public void handleButtonPushed(Button sender, IDCard idCard) {
        operatingStation.getReader().activateBaggageScanner(idCard, idCard.getEmployee().getPinThatIsRemembered());
    }

    public Belt getBelt() {
        return belt;
    }

    public ManualPostControl getManualPostControl() {
        return manualPostControl;
    }

    public OperatingStation getOperatingStation() {
        return operatingStation;
    }

    public RollerConveyor getRollerConveyor() {
        return rollerConveyor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Supervision getSupervision() {
        return supervision;
    }

    public Stack<Tray> getTrays() {
        return trays;
    }

    public Button getPowerButton() {
        return powerButton;
    }

    public Track[] getTracks() {
        return tracks;
    }

    public FederalPoliceOfficer getFederalPoliceOfficer() {
        return federalPoliceOfficer;
    }

    public void setFederalPoliceOfficer(FederalPoliceOfficer federalPoliceOfficer) {
        this.federalPoliceOfficer = federalPoliceOfficer;
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    public Passenger getCurrentPassenger() {
        return currentPassenger;
    }

    public void setCurrentPassenger(Passenger currentPassenger) {
        this.currentPassenger = currentPassenger;
    }
}
