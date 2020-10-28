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
    private ArrayList<Tray> trays;
    private Button powerButton;
    private Track[] tracks;
    private FederalPoliceOfficer federalPoliceOfficer;


    public BaggageScanner(Track[] tracks, Belt belt, ManualPostControl manualPostControl, OperatingStation operatingStation, RollerConveryor rollerConveryor, Scanner scanner, Supervision supervision, ArrayList<Tray> trays) {
        this.belt = belt;
        this.manualPostControl = manualPostControl;
        this.operatingStation = operatingStation;
        this.rollerConveryor = rollerConveryor;
        this.scanner = scanner;
        this.supervision = supervision;
        this.trays = trays;
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
    public void start(){
        status = Status.START;
        System.out.println("Baggage Scanner was started");
        status = Status.DEACTIVATED;
        System.out.println("Baggage Scanner is noch in status deactivated");
    }
    public void deactivate(){
        status = Status.SHUTDOWN;
        System.out.println("Baggage Scanner was shut down");
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

    public ArrayList<Tray> getTrays() {
        return trays;
    }

    public void setTrays(ArrayList<Tray> trays) {
        this.trays = trays;
    }

    public Button getPowerButton() {
        return powerButton;
    }

    public void setPowerButton(Button powerButton) {
        this.powerButton = powerButton;
    }

    public Track[] getTracks() {
        return tracks;
    }

    public void setTracks(Track[] tracks) {
        this.tracks = tracks;
    }

    public FederalPoliceOfficer getFederalPoliceOfficer() {
        return federalPoliceOfficer;
    }

    public void setFederalPoliceOfficer(FederalPoliceOfficer federalPoliceOfficer) {
        this.federalPoliceOfficer = federalPoliceOfficer;
    }

    @Override
    public void handleButtonPushed(Button sender) {
        //TODO implement function halndleButtonPushed
    }
}
