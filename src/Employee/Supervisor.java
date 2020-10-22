package Employee;

import java.util.Date;

public class Supervisor extends Employee{
    private boolean isSenior;
    private boolean isExecutive;

    public Supervisor(String name, Date birthDate, IDCard idCard, boolean isSenior, boolean isExecutive) {
        super(name, birthDate, idCard);
        this.isSenior = isSenior;
        this.isExecutive = isExecutive;
    }
}
