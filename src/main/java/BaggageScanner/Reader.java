package BaggageScanner;

import Configuration.Configuration;
import Employee.IDCard;
import General.AES;

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
                System.out.println("Pin entered accepted, baggage scanner activated");
            }
            else{
                denialCounter++;
                System.out.println("Pin entered was false");
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
                System.out.println("Baggage Scanner is unlocked");
                denialCounter = 0;
            }
        }
    }
    public boolean validatePin(IDCard card, String pinToActivate){
        String magnetStripe = card.getMagnetStripe();
        String decodedString = AES.decrypt(magnetStripe.substring(1), Configuration.instance.key);
        return decodedString.equals(pinToActivate);
    }
}
