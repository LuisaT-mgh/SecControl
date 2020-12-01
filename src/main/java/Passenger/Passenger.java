package Passenger;

import BaggageScanner.BaggageScanner;
import HandBaggage.HandBaggage;
import BaggageScanner.Tray;

import java.util.ArrayList;

public class Passenger {
    private ArrayList<HandBaggage> handBaggage;
    private String fistName;
    private String lastName;
    private BaggageScanner baggageScanner;

    public Passenger(String fistName, String lastName) {
        this.fistName = fistName;
        this.lastName = lastName;
    }

    public void handOverBaggage(){
        for ( HandBaggage handBaggagePart: handBaggage) {
            Tray tray = baggageScanner.getTrays().pop();
            tray.setHandBaggage(handBaggagePart);
            baggageScanner.getRollerConveyor().getTrays().add(tray);
        }
        System.out.println("Hand baggage put on tray and on roller conveyor by passanger");
    }

    public static Passenger getTestPassenger(){
        return new Passenger("Max", "Mustermann");
    }

    public ArrayList<HandBaggage> getHandBaggage() {
        return handBaggage;
    }

    public void setHandBaggage(ArrayList<HandBaggage> handBaggage) {
        this.handBaggage = handBaggage;
    }

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BaggageScanner getBaggageScanner() {
        return baggageScanner;
    }

    public void setBaggageScanner(BaggageScanner baggageScanner) {
        this.baggageScanner = baggageScanner;
    }
}
