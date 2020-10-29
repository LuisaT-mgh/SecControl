package Employee;

import java.util.Date;

public class HouseKeeping extends Employee{

    public HouseKeeping(String name, String birthDate) {
        super(name, birthDate);
        idCard.setType(IDCardType.EXTERNAL);
    }
}
