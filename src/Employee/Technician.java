package Employee;

import java.text.ParseException;
import java.util.Date;

public class Technician extends Employee{
    public Technician(String name, String birthDate) throws ParseException {
        super(name, birthDate);
        idCard = new IDCard(id, this, ProfileType.T);
        idCard.setType(IDCardType.EXTERNAL);
    }
}
