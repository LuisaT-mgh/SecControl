package Employee;

import java.text.ParseException;

public class Technician extends Employee{
    public Technician(String name, String birthDate){
        super(name, birthDate);
        idCard = new IDCard(id, this, ProfileType.T);
        idCard.setType(IDCardType.EXTERNAL);
    }
}
