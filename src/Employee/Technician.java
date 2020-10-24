package Employee;

import java.util.Date;

public class Technician extends Employee{
    public Technician(String name, Date birthDate) {
        super(name, birthDate);
        idCard.setType(IDCardType.EXTERNAL);
    }
}
