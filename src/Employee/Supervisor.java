package Employee;

import main.BaggageScanner.Supervision;

import java.util.Date;

public class Supervisor extends Employee{
    private boolean isSenior;
    private boolean isExecutive;
    private Supervision supervision;

    public Supervisor(String name, Date birthDate, boolean isSenior, boolean isExecutive) {
        super(name, birthDate);
        this.isSenior = isSenior;
        this.isExecutive = isExecutive;
        idCard.setType(IDCardType.STAFF);
    }
}
