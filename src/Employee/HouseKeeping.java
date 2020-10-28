package Employee;

import java.util.Date;

public class HouseKeeping extends Employee{

    public HouseKeeping(String name, Date birthDate) {
        super(name, birthDate);
        idCard.setType(IDCardType.EXTERNAL);
    }
}
