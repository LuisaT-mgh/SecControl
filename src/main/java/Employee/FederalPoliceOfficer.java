package Employee;

import BaggageScanner.BaggageScanner;
import FerderalPoliceOffice.Remote;
import HandBaggage.HandBaggage;
import HandBaggage.Layer;

import java.util.ArrayList;

public class FederalPoliceOfficer extends Employee {
    private String grade;
    private BaggageScanner baggageScanner;
    private String itemToTakeCareOf;
    private String weapon;
    private ArrayList<HandBaggage> confiscatedBaggage;
    private Remote remote;

    public FederalPoliceOfficer(String name, String birthDate, String grade) {
        super(name, birthDate);
        this.confiscatedBaggage = new ArrayList<>();
        this.grade = grade;
        idCard = new IDCard(id, this, ProfileType.O);
        idCard.setType(IDCardType.EXTERNAL);

    }

    public void arrestPassenger() {
        if (baggageScanner != null) {
            baggageScanner.setCurrentPassenger(null);
            System.out.println("Passenger has been arrested and removed from airport");
        }
    }

    public String handlingWeapon() {
        return getSupervisorPassengerRemoveWeapon();
    }

    public String getSupervisorPassengerRemoveWeapon() {
        baggageScanner.getManualPostControl().setPassengerManualPostControl(baggageScanner.getCurrentPassenger());
        baggageScanner.getManualPostControl().setSupervisorForWeaponFound(baggageScanner.getSupervision().getSupervisor());
        System.out.println("Passenger and supervisor have been summoned");
        for (Layer layer : baggageScanner.getManualPostControl().getTrayWithBaggageInManualPostControl().getHandBaggage().getLayers()) {
            String content = new String(layer.getCharacter());
            if (content.contains("glock|7")) {
                content.replace("glock|7", "00000");
                System.out.println("glock|7 was removed from baggage");
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

    public Remote getRemote() {
        return remote;
    }

    public void setRemote(Remote remote) {
        this.remote = remote;
    }

    public void setBaggageScanner(BaggageScanner baggageScanner) {
        this.baggageScanner = baggageScanner;
    }
}
