package main.BaggageScanner;

import Employee.FederalPoliceOfficer;

import java.util.ArrayList;

public class BaggageScanner implements IHasButton{
    private Belt belt;
    private ManualPostControl manualPostControl;
    private OperatingStation operatingStation;
    private RollerConveryor rollerConveryor;
    private Scanner scanner;
    private Status status;
    private Supervision supervision;
    private Tray tray;
    private Button powerButton;
    private ArrayList<Track> tracks;
    private FederalPoliceOfficer federalPoliceOfficer;


    public BaggageScanner(ArrayList<Track> tracks, Belt belt, ManualPostControl manualPostControl, OperatingStation operatingStation, RollerConveryor rollerConveryor, Scanner scanner, Supervision supervision, Tray tray) {
        this.belt = belt;
        this.manualPostControl = manualPostControl;
        this.operatingStation = operatingStation;
        this.rollerConveryor = rollerConveryor;
        this.scanner = scanner;
        this.supervision = supervision;
        this.tray = tray;
        this.tracks = tracks;
        powerButton = new Button();
        powerButton.setShape(ButtonShape.POWER_BUTTON_SHAPE);

        status = Status.SHUTDOWN;
    }

    public void moveBeltForward(){
    }
    public void moveBeltBackwards(){
    }
    public void scan(){

    }
    public void alarm(){

    }
    public void report(){

    }
    public void maintenance(){

    }

    public Belt getBelt() {
        return belt;
    }

    public void setBelt(Belt belt) {
        this.belt = belt;
    }

    public ManualPostControl getManualPostControl() {
        return manualPostControl;
    }

    public void setManualPostControl(ManualPostControl manualPostControl) {
        this.manualPostControl = manualPostControl;
    }

    public OperatingStation getOperatingStation() {
        return operatingStation;
    }

    public void setOperatingStation(OperatingStation operatingStation) {
        this.operatingStation = operatingStation;
    }

    public RollerConveryor getRollerConveryor() {
        return rollerConveryor;
    }

    public void setRollerConveryor(RollerConveryor rollerConveryor) {
        this.rollerConveryor = rollerConveryor;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
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

    public void setSupervision(Supervision supervision) {
        this.supervision = supervision;
    }

    public Tray getTray() {
        return tray;
    }

    public void setTray(Tray tray) {
        this.tray = tray;
    }

    @Override
    public void handleButtonPushed(Button sender) {
        //TODO implement function halndleButtonPushed
    }
}
