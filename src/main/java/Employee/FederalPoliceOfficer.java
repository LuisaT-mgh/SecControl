package Employee;

import FerderalPoliceOffice.FederalPoliceOffice;
import BaggageScanner.BaggageScanner;
import Passenger.Passenger;

public class FederalPoliceOfficer extends Employee{
    private String grade;
    private BaggageScanner baggageScanner;
    private FederalPoliceOffice federalPoliceOffice;
    private String itemToTakeCareOf;

    public FederalPoliceOfficer(String name, String birthDate, String grade){
        super(name, birthDate);
        this.grade = grade;
        idCard = new IDCard(id, this, ProfileType.O);
        idCard.setType(IDCardType.EXTERNAL);

    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    public void arrestPassenger(){
        if(baggageScanner != null){
            baggageScanner.setCurrentPassenger(null);
            System.out.println("Passenger has been removed from airport");
        }
    }

    public String getItemToTakeCareOf() {
        return itemToTakeCareOf;
    }

    public void setItemToTakeCareOf(String itemToTakeCareOf) {
        this.itemToTakeCareOf = itemToTakeCareOf;
    }
}
