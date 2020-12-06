package Employee;

public class HouseKeeping extends Employee {

    public HouseKeeping(String name, String birthDate) {
        super(name, birthDate);
        idCard = new IDCard(id, this, ProfileType.K);
        idCard.setType(IDCardType.STAFF);
    }
}
