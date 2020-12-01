package General;

import Configuration.Configuration;
import Employee.Supervisor;
import Employee.Inspector;
import Employee.FederalPoliceOfficer;
import Employee.Technician;
import FerderalPoliceOffice.FederalPoliceOffice;
import Employee.HouseKeeping;
import FerderalPoliceOffice.Remote;
import HandBaggage.HandBaggage;
import Passenger.Passenger;
import HandBaggage.Layer;
import BaggageScanner.*;
import BaggageScanner.Reader;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

public class Application {
    public BaggageScanner baggageScanner;
    public Technician technician;
    public HouseKeeping houseKeeping;
    public ArrayList<FederalPoliceOfficer> federalPoliceOfficers = new ArrayList<>();
    public ArrayList<Passenger> passengers;
    public FederalPoliceOffice federalPoliceOffice;

    public static void main(String... args) {
        Application application = new Application();
        application.generateSecurityControl();
        application.prepareSecurityControl();
        application.processPassengers();
    }

    public void generateSecurityControl() {
        passengers = generatePassengers();
        System.out.println("Passengers with Baggage and hidden Items have been generated");

        this.baggageScanner = generateBaggageScanner(passengers.size());

        federalPoliceOffice = new FederalPoliceOffice();
        FederalPoliceOfficer federalPoliceOfficer01 = new FederalPoliceOfficer("Toto", "01/01/1969", "officer");
        FederalPoliceOfficer federalPoliceOfficer02 = new FederalPoliceOfficer("Harry", "01/01/1969", "officer");
        federalPoliceOffice.getRegisteredOfficers().add(federalPoliceOfficer01);
        federalPoliceOffice.getRegisteredOfficers().add(federalPoliceOfficer02);
        federalPoliceOffice.getRegisteredOfficers().add(baggageScanner.getFederalPoliceOfficer());
        System.out.println("All officers have been registered in the federal police office");

        technician = new Technician("Jasom Stratham", "19/03/1955");
        houseKeeping = new HouseKeeping("Json Clark", "17/07/1969");
        System.out.println("All additional Employees have been created");
    }

    public void prepareSecurityControl() {
        baggageScanner.getOperatingStation().getReader().activateBaggageScanner(baggageScanner.getOperatingStation().getInspector().getIdCard(), baggageScanner.getOperatingStation().getInspector().getPinThatIsRemembered());
    }

    public void processPassengers() {
        //TODO passagiere abarbeiten;
        for (Passenger passenger : passengers) {
            passenger.setBaggageScanner(baggageScanner);
            baggageScanner.setCurrentPassenger(passenger);
            System.out.println("current passenger:: "+baggageScanner.getCurrentPassenger().getFistName() + baggageScanner.getCurrentPassenger().getLastName());
            passenger.handOverBaggage();
            baggageScanner.getRollerConveyor().getInspector().pushTrays();
            baggageScanner.getOperatingStation().getInspector().pushButtonRight();
            baggageScanner.getOperatingStation().getInspector().pushButtonRectangle();
            if (baggageScanner.getStatus() == Status.LOCKED) {
                federalPoliceOfficers.addAll(federalPoliceOffice.getRegisteredOfficers());
                System.out.println("Additional police officers called");
                if (baggageScanner.getFederalPoliceOfficer().getItemToTakeCareOf().equals("glock|7")) {
                    federalPoliceOfficers.get(1).setWeapon(baggageScanner.getFederalPoliceOfficer().handlingWeapon());
                    System.out.println("Weapon has been handed to officer 3");
                    baggageScanner.getManualPostControl().setHasToBeConfiscated(true);
                    baggageScanner.getOperatingStation().getInspector().pushButtonRight();
                    baggageScanner.getOperatingStation().getInspector().pushButtonRectangle();
                    System.out.println("Remaining baggage of passenger has been scanned");
                    baggageScanner.getManualPostControl().setHasToBeConfiscated(false);
                    if (baggageScanner.getManualPostControl().getInspector().getHandBaggageToHandOver() != null) {
                        baggageScanner.getManualPostControl().getInspector().handOverBaggage(federalPoliceOfficers.get(1));
                        System.out.println("Remaining baggage of passenger has been handed to officer 3");
                    }
                    baggageScanner.getFederalPoliceOfficer().arrestPassenger();
                    federalPoliceOfficers = null;
                    System.out.println("Police officers have left airport with passenger");
                } else if (baggageScanner.getFederalPoliceOfficer().getItemToTakeCareOf().equals("exl|os!ve")) {
                    Random random = new Random();
                    int randomChoice = random.nextInt(2);
                    federalPoliceOffice.getRobots()[randomChoice].getRemote().setFederalPoliceOfficer(federalPoliceOfficers.get(0));
                    federalPoliceOfficers.get(0).setRemote(federalPoliceOffice.getRobots()[randomChoice].getRemote());
                    System.out.println("Robot has been called");
                    if (baggageScanner.getManualPostControl().getInspector().swipe()) {
                        federalPoliceOfficers.get(0).getRemote().destroyHandBaggage(baggageScanner.getManualPostControl().getTrayWithBaggageInManualPostControl().getHandBaggage());
                        baggageScanner.getManualPostControl().setTrayWithBaggageInManualPostControl(null);
                    }
                }
                baggageScanner.getSupervision().getSupervisor().unlockBaggageScanner();
                System.out.println("Return to normal procedure");
            }
        }
    }

    private ArrayList<Passenger> generatePassengers() {
        ArrayList<Passenger> passengers = new ArrayList<>();
        try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Configuration.instance.passengerDataPath)));
            while ((line = bufferedReader.readLine()) != null) {
                String[] generalData = line.split("\\[");
                if (generalData.length >= 2) {
                    String[] hiddenItems = generalData[1].split(";");
                }
                String passengerData[] = generalData[0].split(";");
                String[] combinedName = passengerData[0].split(Configuration.instance.passengerNameDelimiter);
                String firstName = combinedName[0];
                String lastName = combinedName[1];
                int numberOfHandBaggage = Integer.parseInt(passengerData[1]);
                String[] hiddenItems;
                if (generalData.length >= 2) {
                    hiddenItems = generalData[1].split(";");
                } else {
                    hiddenItems = new String[]{passengerData[2]};
                }
                Passenger passenger = new Passenger(firstName, lastName);
                passenger.setHandBaggage(HandBaggage.generateHandBaggages(numberOfHandBaggage, hiddenItems));
                passengers.add(passenger);
            }

        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return passengers;
    }

    public BaggageScanner generateBaggageScanner(int numberOfPassengers) {
        OperatingStation operatingStation = new OperatingStation();
        Reader reader = new Reader();
        operatingStation.setReader(reader);
        reader.setOperatingStation(operatingStation);
        RollerConveyor rollerConveyor = new RollerConveyor();
        Belt belt = new Belt();
        Scanner scanner = new Scanner();
        ManualPostControl manualPostControl = new ManualPostControl();
        Supervision supervision = new Supervision();
        Track[] tracks = {new Track(), new Track()};
        Stack<Tray> trays = new Stack<Tray>();
        for (int i = 0; i < numberOfPassengers * 3; i++) {
            trays.push(new Tray());
        }
        BaggageScanner baggageScanner = new BaggageScanner(tracks, belt, manualPostControl, operatingStation, rollerConveyor, scanner, supervision, trays);
        System.out.println("A baggage Scanner has been created");
        Inspector inspector01 = new Inspector("Clint Eastwood", "31/05/1930", true);
        inspector01.setRollerConveyor(rollerConveyor);
        Inspector inspector02 = new Inspector("Natalie Portman", "09/06/1981", false);
        inspector02.setOperatingStation(operatingStation);
        Inspector inspector03 = new Inspector("Bruce Willis", "19/03/1955", true);
        inspector03.setManualPostControl(manualPostControl);
        Supervisor supervisor = new Supervisor("Jodie Foster", "19/11/1962", false, false);
        supervisor.setSupervision(supervision);
        FederalPoliceOfficer federalPoliceOfficer = new FederalPoliceOfficer("Wesley Snipes", "31/07/1962", "officer");
        baggageScanner.getRollerConveyor().setInspector(inspector01);
        baggageScanner.getOperatingStation().setInspector(inspector02);
        baggageScanner.getManualPostControl().setInspector(inspector03);
        baggageScanner.getSupervision().setSupervisor(supervisor);
        baggageScanner.setFederalPoliceOfficer(federalPoliceOfficer);
        operatingStation.setBaggageScanner(baggageScanner);
        manualPostControl.setBaggageScanner(baggageScanner);
        supervision.setBaggageScanner(baggageScanner);
        rollerConveyor.setBaggageScanner(baggageScanner);
        scanner.setBaggageScanner(baggageScanner);
        federalPoliceOfficer.setBaggageScanner(baggageScanner);
        manualPostControl.setExplosiveTraceDetector(new ExplosiveTraceDetector());
        System.out.println("Employees have been assigned to baggage scanner");
        return baggageScanner;
    }
}
