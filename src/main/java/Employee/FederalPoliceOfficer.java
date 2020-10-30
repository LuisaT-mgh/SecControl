package Employee;

import main.FerderalPoliceOffice.FederalPoliceOffice;
import main.BaggageScanner.BaggageScanner;

import java.text.ParseException;

public class FederalPoliceOfficer extends Employee{
    private String grade;
    private BaggageScanner baggageScanner;
    private FederalPoliceOffice federalPoliceOffice;

    public FederalPoliceOfficer(String name, String birthDate, String grade) throws ParseException {
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
}
