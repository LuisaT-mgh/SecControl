package Employee;

import BaggageScanner.ManualPostControl;
import BaggageScanner.OperatingStation;
import BaggageScanner.RollerConveryor;

import java.text.ParseException;

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
