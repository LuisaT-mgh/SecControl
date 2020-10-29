package Employee;

import java.text.ParseException;
import java.util.Date;
import Employee.IDCard;

public class HouseKeeping extends Employee{

    public HouseKeeping(String name, Date birthDate) throws ParseException {
        super(name, birthDate);
        idCard = new IDCard(id, this, ProfileType.K);
        idCard.setType(IDCardType.STAFF);
    }
}
