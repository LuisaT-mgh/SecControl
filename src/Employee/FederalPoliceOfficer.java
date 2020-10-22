package Employee;

import java.util.Date;

public class FederalPoliceOfficer extends Employee{
    private String grade;
    private

    public FederalPoliceOfficer(String name, Date birthDate, IDCard idCard, String grade) {
        super(name, birthDate, idCard);
        this.grade = grade;
    }
}
