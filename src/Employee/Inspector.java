package Employee;

import java.util.Date;

public class Inspector extends Employee{
    private boolean isSenior;
    public Inspector(String name, Date birthDate, IDCard idCard, boolean isSenior) {
        super(name, birthDate, idCard);
        this.isSenior = isSenior;
    }
}
