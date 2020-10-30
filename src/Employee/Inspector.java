package Employee;

import main.BaggageScanner.ManualPostControl;
import main.BaggageScanner.OperatingStation;
import main.BaggageScanner.RollerConveryor;
import Employee.IDCard;

import java.text.ParseException;
import java.util.Date;

public class Inspector extends Employee{
    private boolean isSenior;
    private RollerConveryor rollerConveryor;
    private ManualPostControl manualPostControl;
    private OperatingStation operatingStation;
    public Inspector(String name, String birthDate, boolean isSenior) throws ParseException {
        super(name, birthDate);
        this.isSenior = isSenior;
        idCard = new IDCard(id, this, ProfileType.I);
        idCard.setType(IDCardType.STAFF);
    }
    public void pushTrays(){
        //TODO implement function
    }
}
