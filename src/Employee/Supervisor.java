package Employee;

import main.BaggageScanner.Supervision;

import java.text.ParseException;
import java.util.Date;

public class Supervisor extends Employee{
    private boolean isSenior;
    private boolean isExecutive;
    private Supervision supervision;

    public Supervisor(String name, String birthDate, boolean isSenior, boolean isExecutive) throws ParseException {
        super(name, birthDate);
        this.isSenior = isSenior;
        this.isExecutive = isExecutive;
        idCard = new IDCard(id, this, ProfileType.S);
        idCard.setType(IDCardType.STAFF);
    }
}
