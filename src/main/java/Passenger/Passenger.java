package Passenger;

import HandBaggage.HandBaggage;

import java.util.ArrayList;

public class Passenger {
    private ArrayList<HandBaggage> handBaggage;
    private String fistName;
    private String lastName;

    public Passenger(String fistName, String lastName) {
        this.fistName = fistName;
        this.lastName = lastName;
    }

    public void handOverBaggage(){
        handBaggage = new ArrayList<HandBaggage>();
        //TODO implement function
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
}
