package Employee;

import BaggageScanner.ManualPostControl;
import BaggageScanner.OperatingStation;
import BaggageScanner.RollerConveyor;
import BaggageScanner.Tray;
import HandBaggage.HandBaggage;

public class Inspector extends Employee{
    private boolean isSenior;
    private RollerConveyor rollerConveyor;
    private ManualPostControl manualPostControl;
    private OperatingStation operatingStation;
    public Inspector(String name, String birthDate, boolean isSenior){
        super(name, birthDate);
        this.isSenior = isSenior;
        idCard = new IDCard(id, this, ProfileType.I);
        idCard.setType(IDCardType.STAFF);
    }
    public void pushTrays(){
        if( rollerConveyor != null) {
            while (rollerConveyor.getBaggageScanner().getRollerConveyor().getTrays().size() != 0) {
                Tray tray = rollerConveyor.getBaggageScanner().getRollerConveyor().getTrays().remove();
                rollerConveyor.getBaggageScanner().getBelt().getTrays().add(tray);
            }
        }
        else{
            System.out.println("No roller conveyor found in inspector");
        }
    }
}
