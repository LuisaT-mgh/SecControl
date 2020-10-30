package General;

import Configuration.Configuration;
import Employee.Supervisor;
import Employee.Inspector;
import Employee.FederalPoliceOfficer;
import Employee.Technician;
import FerderalPoliceOffice.FederalPoliceOffice;
import Employee.HouseKeeping;
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

        FederalPoliceOffice federalPoliceOffice = new FederalPoliceOffice();
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
        for (Passenger passenger: passengers) {
            passenger.handOverBaggage();

        }
    }

    private ArrayList<Passenger> generatePassengers() {
        ArrayList<Passenger> passengers = new ArrayList<>();
        try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Configuration.instance.passengerDataPath)));
            while ((line = bufferedReader.readLine()) != null) {
                String[] passengerData = line.split(Configuration.instance.passengerDataDelimiter);
                String[] combinedName = passengerData[0].split(Configuration.instance.passengerNameDelimiter);
                String firstName = combinedName[0];
                String lastName = combinedName[1];
                int numberOfHandBaggage = Integer.parseInt(passengerData[1]);
                String hasForbiddenItem = passengerData[2];

                Passenger passenger = new Passenger(firstName, lastName);
                passenger.setHandBaggage(generateHandBaggage(numberOfHandBaggage, hasForbiddenItem));
                passengers.add(passenger);
            }

        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        return passengers;
    }

    private ArrayList<HandBaggage> generateHandBaggage(int numberOfBaggage, String hasForbiddenItem) {
        ArrayList<HandBaggage> handBaggage = new ArrayList<>();
        int numberOfForbiddenBaggage = 15;
        int numberOfForbiddenLayer = 15;
        String forbiddenItem = null;
        if (!hasForbiddenItem.contentEquals("-")) {
            hasForbiddenItem = hasForbiddenItem.replace("[", "");
            hasForbiddenItem = hasForbiddenItem.replace("]", "");
            String[] allForbiddenItems = hasForbiddenItem.split(";");
            for (String item : allForbiddenItems) {
                String[] dataHasForbiddenItem = item.split(",");
                numberOfForbiddenBaggage = Integer.parseInt(dataHasForbiddenItem[1]);
                numberOfForbiddenLayer = Integer.parseInt(dataHasForbiddenItem[2]);
                switch (dataHasForbiddenItem[0]) {
                    case "K":
                        forbiddenItem = Configuration.instance.forbiddenItems[0];
                        break;
                    case "W":
                        forbiddenItem = Configuration.instance.forbiddenItems[1];
                        break;
                    case "E":
                        forbiddenItem = Configuration.instance.forbiddenItems[2];
                        break;
                }
            }
        }
        for (int i = 0; i < numberOfBaggage; i++) {
            Layer[] layers = new Layer[5];
            for (int j = 0; j < 5; j++) {
                Layer layer = new Layer();
                if (numberOfForbiddenBaggage == i && numberOfForbiddenLayer == j) {
                    layer = hideItemInLayer(layer, forbiddenItem);
                }
                layers[j] = layer;
            }
            HandBaggage handBaggage1 = new HandBaggage(layers);
            handBaggage.add(handBaggage1);
        }
        return handBaggage;
    }

    private Layer hideItemInLayer(Layer layer, String item) {
        Random rand = new Random();
        int letterNumber = rand.nextInt(9999 - item.length());
        Character[] temporaryCharacter = layer.getCharacter();
        for (int i = 0; i < item.length(); i++) {
            temporaryCharacter[letterNumber] = item.charAt(i);
            letterNumber++;
        }
        layer.setCharacter(temporaryCharacter);
        return layer;
    }


    public BaggageScanner generateBaggageScanner(int numberOfPassengers) {
        OperatingStation operatingStation = new OperatingStation();
        Reader reader = new Reader();
        operatingStation.setReader(reader);
        operatingStation.getReader().setOperatingStation(operatingStation);
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
        Inspector inspector02 = new Inspector("Natalie Portman", "09/06/1981", false);
        Inspector inspector03 = new Inspector("Bruce Willis", "19/03/1955", true);
        Supervisor supervisor = new Supervisor("Jodie Foster", "19/03/1955", false, false);
        FederalPoliceOfficer federalPoliceOfficer = new FederalPoliceOfficer("Wesley Snipes", "19/03/1955", "officer");
        baggageScanner.getRollerConveyor().setInspector(inspector01);
        baggageScanner.getOperatingStation().setInspector(inspector02);
        baggageScanner.getManualPostControl().setInspector(inspector03);
        baggageScanner.getSupervision().setSupervisor(supervisor);
        baggageScanner.setFederalPoliceOfficer(federalPoliceOfficer);
        operatingStation.setBaggageScanner(baggageScanner);
        System.out.println("Employees have been assigned to baggage scanner");
        return baggageScanner;
    }
}
