package Employee;

import BaggageScanner.*;
import HandBaggage.HandBaggage;
import HandBaggage.Layer;
import Passenger.Passenger;

import java.util.ArrayList;
import java.util.Random;

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
            while (rollerConveyor.getTrays().size() != 0) {
                Tray tray = rollerConveyor.getTrays().remove();
                rollerConveyor.getBaggageScanner().getBelt().getTrays().add(tray);
            }
            System.out.println("Tray have been pushed on belt by inspector");
        }
        else{
            System.out.println("No roller conveyor found in inspector");
        }
    }

    public void pushButtonRight(){
        if( operatingStation != null) {
            System.out.println("Button right pushed");
            operatingStation.handleButtonPushed(operatingStation.getButtonRight(), idCard);
        }
        else{
            System.out.println("No operating station found in inspector");
        }
    }

    public void pushButtonRectangle(){
        if( operatingStation != null) {
            System.out.println("Button rectangle pushed");
            operatingStation.handleButtonPushed(operatingStation.getButtonRectangle(), idCard);
        }
        else{
            System.out.println("No operating station found in inspector");
        }
    }

    public void pushButtonLeft(){
        if( operatingStation != null) {
            System.out.println("Button left pushed");
            operatingStation.handleButtonPushed(operatingStation.getButtonLeft(), idCard);
        }
        else{
            System.out.println("No operating station found in inspector");
        }
    }
    public void informManualPostControl(String itemFound, Tray tray){
        if(operatingStation != null){
            operatingStation.getBaggageScanner().getManualPostControl().setTrayWithBaggageInManualPostControl(tray);
            switch (itemFound){
                case "kn!fe":
                    System.out.println("kn!fe found");
                    operatingStation.getBaggageScanner().getManualPostControl().getInspector().initiateManualPostControlKnife();
                    break;
                case "exl|os!ve":
                    System.out.println("exl|os!ve found");
                    operatingStation.getBaggageScanner().alarm(idCard, "exl|os!ve");
                    break;
                case "glock|7":
                    System.out.println("glock|7 found");
                    operatingStation.getBaggageScanner().alarm(idCard, "glock|7");
                    break;
            }
        }
    }
    public void initiateManualPostControlKnife(){
        if(manualPostControl != null){
            for(Layer layer: manualPostControl.getTrayWithBaggageInManualPostControl().getHandBaggage().getLayers()){
                String charactersOfLayer = new String(layer.getCharacter());
                if(charactersOfLayer.contains("kn!fe")) {
                    manualPostControl.setPassengerManualPostControl(manualPostControl.getBaggageScanner().getCurrentPassenger());
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
            System.out.println("Baggage will be rechecked");
            operatingStation.handleButtonPushed(operatingStation.getButtonLeft(), idCard);
            operatingStation.handleButtonPushed(operatingStation.getButtonRectangle(), idCard);
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
        System.out.println("All forbidden items have been removed");
        handBaggageToHandOver.add(tray.getHandBaggage());
    }

    public boolean swipe(){
        if(manualPostControl != null) {
            TestStrip testStrip = new TestStrip();
            System.out.println("Inspector swipes test strip over suspicious baggage");
            TestStrip usedTeststrip = useTeststrip(testStrip);
            return manualPostControl.getBaggageScanner().getManualPostControl().getExplosiveTraceDetector().checkTestStrip(usedTeststrip);
        }
        return false;
    }

    public TestStrip useTeststrip(TestStrip testStrip){
        Random random = new Random();
        System.out.println("Test strip is applied");
        String positiveOutcome = "exp";
        int row = random.nextInt(30);
        int column = random.nextInt(10-3);
        for(int i = 0; i<3; i++){
            testStrip.getSurface()[row][column+i] = positiveOutcome.charAt(i);
        }
        return testStrip;
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

    public RollerConveyor getRollerConveyor() {
        return rollerConveyor;
    }

    public void setRollerConveyor(RollerConveyor rollerConveyor) {
        this.rollerConveyor = rollerConveyor;
    }

    public ManualPostControl getManualPostControl() {
        return manualPostControl;
    }

    public void setManualPostControl(ManualPostControl manualPostControl) {
        this.manualPostControl = manualPostControl;
    }

    public OperatingStation getOperatingStation() {
        return operatingStation;
    }

    public void setOperatingStation(OperatingStation operatingStation) {
        this.operatingStation = operatingStation;
    }
}
