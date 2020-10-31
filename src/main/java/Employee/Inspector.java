package Employee;

import BaggageScanner.ManualPostControl;
import BaggageScanner.OperatingStation;
import BaggageScanner.RollerConveyor;
import BaggageScanner.Tray;
import HandBaggage.HandBaggage;
import HandBaggage.Layer;
import Passenger.Passenger;

import java.util.ArrayList;

public class Inspector extends Employee{
    private boolean isSenior;
    private RollerConveyor rollerConveyor;
    private ManualPostControl manualPostControl;
    private OperatingStation operatingStation;
    private ArrayList<HandBaggage> handBaggageToHandOver = new ArrayList<>();
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

    public void pushButtonRight(){
        if( operatingStation != null) {
            operatingStation.handleButtonPushed(operatingStation.getButtonRight(), idCard);
        }
        else{
            System.out.println("No operating station found in inspector");
        }
    }

    public void pushButtonRectangle(){
        if( operatingStation != null) {
            operatingStation.handleButtonPushed(operatingStation.getButtonRectangle(), idCard);
        }
        else{
            System.out.println("No operating station found in inspector");
        }
    }

    public void pushButtonLeft(){
        if( operatingStation != null) {
            operatingStation.handleButtonPushed(operatingStation.getButtonLeft(), idCard);
        }
        else{
            System.out.println("No operating station found in inspector");
        }
    }
    public void informManualPostControl(String itemFound, Tray tray){
        if(operatingStation != null){
            switch (itemFound){
                case "kn!fe":
                    operatingStation.getBaggageScanner().getManualPostControl().getInspector().initiateManualPostControlKnife();
                    break;
                case "exl|os!ve":
                    operatingStation.getBaggageScanner().alarm(idCard, "exl|os!ve");
                    break;
                case "glock|7":
                    operatingStation.getBaggageScanner().alarm(idCard, "glock|7");
                    break;
            }
            operatingStation.getBaggageScanner().getManualPostControl().setTrayWithBaggageInManualPostControl(tray);
        }
    }
    public void initiateManualPostControlKnife(){
        if(manualPostControl != null){
            for(Layer layer: manualPostControl.getTrayWithBaggageInManualPostControl().getHandBaggage().getLayers()){
                if(layer.getCharacter().toString().contains("kn!fe")) {
                    manualPostControl.setPassengerManualPostControl(operatingStation.getBaggageScanner().getCurrentPassenger());
                    System.out.println("Passenger is present for manual post control");
                    String content = layer.getCharacter().toString().replace("kn!fe", "00000");
                    layer.setCharacter(content.toCharArray());
                    System.out.println("kn!fe has been removed");
                    manualPostControl.getBaggageScanner().getBelt().getTrays().add(manualPostControl.getTrayWithBaggageInManualPostControl());
                    manualPostControl.setTrayWithBaggageInManualPostControl(null);
                    manualPostControl.getBaggageScanner().getOperatingStation().getInspector().recheckBag();
                    manualPostControl.setPassengerManualPostControl(null);
                }
            }
        }
    }
    public void recheckBag(){
        if(operatingStation != null){
            operatingStation.handleButtonPushed(operatingStation.getButtonLeft(), idCard);
            operatingStation.handleButtonPushed(operatingStation.getButtonRectangle(), idCard);
            System.out.println("Baggage will be rechecked");
        }
    }

    public void removeForbidden(Tray tray){
        for (Layer layer : tray.getHandBaggage().getLayers()) {
            if(layer.getCharacter().toString().contains("kn!fe")){
                layer.getCharacter().toString().replace("kn!fe", "00000");
            }
            else if(layer.getCharacter().toString().contains("exl|os!ve")){
                layer.getCharacter().toString().replace("exl|os!ve", "00000");
            }
            else if(layer.getCharacter().toString().contains("glock|7")){
                layer.getCharacter().toString().replace("glock|7", "00000");
            }
        }
        System.out.println("Fall forbidden items have been removed");
        handBaggageToHandOver.add(tray.getHandBaggage());
    }


    public ArrayList<HandBaggage> getHandBaggageToHandOver() {
        return handBaggageToHandOver;
    }

    public void setHandBaggageToHandOver(ArrayList<HandBaggage> handBaggageToHandOver) {
        this.handBaggageToHandOver = handBaggageToHandOver;
    }

    public void handOverBaggage(FederalPoliceOfficer federalPoliceOfficer){
        federalPoliceOfficer.setConfiscatedBaggage(handBaggageToHandOver);
        handBaggageToHandOver = null;
    }
}
