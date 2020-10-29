package Employee;

import FerderalPoliceOffice.FederalPoliceOffice;
import main.BaggageScanner.BaggageScanner;

import java.util.Date;

public class FederalPoliceOfficer extends Employee{
    private String grade;
    private BaggageScanner baggageScanner;
    private FederalPoliceOffice federalPoliceOffice;

    public FederalPoliceOfficer(String name, String birthDate, String grade) {
        super(name, birthDate);
        this.grade = grade;
        idCard.setType(IDCardType.EXTERNAL);
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
