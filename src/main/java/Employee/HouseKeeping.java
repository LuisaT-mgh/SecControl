package Employee;

import java.text.ParseException;

public class HouseKeeping extends Employee{

    public HouseKeeping(String name, String birthDate) throws ParseException {
        super(name, birthDate);
        idCard = new IDCard(id, this, ProfileType.K);
        idCard.setType(IDCardType.STAFF);
    }
}
