package Passenger;

import BaggageScanner.BaggageScanner;
import BaggageScanner.Tray;
import HandBaggage.HandBaggage;

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

    public void handOverBaggage() {
        for (HandBaggage handBaggagePart : handBaggage) {
            Tray tray = baggageScanner.getTrays().pop();
            tray.setHandBaggage(handBaggagePart);
            baggageScanner.getRollerConveyor().getTrays().add(tray);
        }
        System.out.println("Hand baggage put on tray and on roller conveyor by passanger");
    }

    public static Passenger getTestPassenger() {
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

    public String getLastName() {
        return lastName;
    }

    public void setBaggageScanner(BaggageScanner baggageScanner) {
        this.baggageScanner = baggageScanner;
    }
}
