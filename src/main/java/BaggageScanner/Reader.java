package BaggageScanner;

import main.Employee.IDCard;

public class Reader {
    private OperatingStation operatingStation;
    private int denialCounter = 0;
    public void activateBaggageScanner(IDCard card, String pinToActivate){
        if(card.getMagnetStripe().charAt(0) != 'S' || card.getMagnetStripe().charAt(0) != 'I' || card.getMagnetStripe().charAt(0) != 'T'){
            System.out.println("Unauthorized access to baggage scanner request");
        }
        if(denialCounter == 2){
            operatingStation.getBaggageScanner().setStatus(Status.LOCKED);
            return;
        }
        else{
            if(validatePin(card, pinToActivate)){
                operatingStation.getBaggageScanner().setStatus(Status.ACTIVATED);
            }
            else{
                denialCounter++;
                activateBaggageScanner(card, pinToActivate);
            }
        }
    }
    public void unlockBaggageScanner(IDCard card, String pinToActivate){
        if(card.getMagnetStripe().charAt(0) != 'S'){
            System.out.println("Unauthorized access to baggage scanner request to unlock");
        }
        else{
            if(validatePin(card, pinToActivate)){
                operatingStation.getBaggageScanner().setStatus(Status.ACTIVATED);
            }
        }
        //TODO implementation
    }
    public boolean validatePin(IDCard card, String pinToActivate){
        return true;
    }
}
