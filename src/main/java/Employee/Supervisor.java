package Employee;

import BaggageScanner.Supervision;

import java.text.ParseException;

public class Supervisor extends Employee{
    private boolean isSenior;
    private boolean isExecutive;
    private Supervision supervision;

    public Supervisor(String name, String birthDate, boolean isSenior, boolean isExecutive){
        super(name, birthDate);
        this.isSenior = isSenior;
        this.isExecutive = isExecutive;
        idCard = new IDCard(id, this, ProfileType.S);
        idCard.setType(IDCardType.STAFF);
    }
}
