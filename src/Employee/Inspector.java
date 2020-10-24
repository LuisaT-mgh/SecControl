package Employee;

import main.BaggageScanner.ManualPostControl;
import main.BaggageScanner.OperatingStation;
import main.BaggageScanner.RollerConveryor;

import java.util.Date;

public class Inspector extends Employee{
    private boolean isSenior;
    private RollerConveryor rollerConveryor;
    private ManualPostControl manualPostControl;
    private OperatingStation operatingStation;
    public Inspector(String name, Date birthDate, boolean isSenior) {
        super(name, birthDate);
        this.isSenior = isSenior;
        idCard.setType(IDCardType.STAFF);
    }
    public void pushTrays(){
        //TODO implement function
    }
}
