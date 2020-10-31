package Employee;

import FerderalPoliceOffice.FederalPoliceOffice;
import BaggageScanner.BaggageScanner;
import HandBaggage.HandBaggage;
import HandBaggage.Layer;
import Passenger.Passenger;

import java.util.ArrayList;

public class FederalPoliceOfficer extends Employee{
    private String grade;
    private BaggageScanner baggageScanner;
    private FederalPoliceOffice federalPoliceOffice;
    private String itemToTakeCareOf;
    private String weapon;
    private ArrayList<HandBaggage> confiscatedBaggage;

    public FederalPoliceOfficer(String name, String birthDate, String grade){
        super(name, birthDate);
        this.confiscatedBaggage = new ArrayList<>();
        this.grade = grade;
        idCard = new IDCard(id, this, ProfileType.O);
        idCard.setType(IDCardType.EXTERNAL);

    }
    public void arrestPassenger(){
        if(baggageScanner != null){
            baggageScanner.setCurrentPassenger(null);
            System.out.println("Passenger has been removed from airport");
        }
    }
    public String handlingWeapon(){
        return getSupervisorPassengerRemoveWeapon();
    }
    public String getSupervisorPassengerRemoveWeapon(){
        baggageScanner.getManualPostControl().setPassengerManualPostControl(baggageScanner.getCurrentPassenger());
        baggageScanner.getManualPostControl().setSupervisorForWeaponFound(baggageScanner.getSupervision().getSupervisor());
        System.out.println("Passenger and supervisor have been summoned");
        for(Layer layer: baggageScanner.getManualPostControl().getTrayWithBaggageInManualPostControl().getHandBaggage().getLayers()) {
            String content = layer.getCharacter().toString();
            if(content.contains("glock|7")){
                content.replace("glock|7", "00000");
            }
            layer.setCharacter(content.toCharArray());
            return "glock|7";
        }
        return null;
    }

    public String getItemToTakeCareOf() {
        return itemToTakeCareOf;
    }

    public void setItemToTakeCareOf(String itemToTakeCareOf) {
        this.itemToTakeCareOf = itemToTakeCareOf;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public ArrayList<HandBaggage> getConfiscatedBaggage() {
        return confiscatedBaggage;
    }

    public void setConfiscatedBaggage(ArrayList<HandBaggage> confiscatedBaggage) {
        this.confiscatedBaggage = confiscatedBaggage;
    }
}
