package BaggageScanner;

import Configuration.Configuration;
import Employee.IDCard;
import General.AES;

public class Reader {
    private OperatingStation operatingStation;
    private int denialCounter = 0;

    /** Try to activate a BaggageScanner.
     *
     * @param card The IDCard that has been read.
     * @param pinToActivate The PIN entered.
     * @return Boolean if the action was successful.
     */
    public boolean activateBaggageScanner(IDCard card, String pinToActivate){
        //TODO This should check against the list in the config, instead of a char. Maybe in the same way the Pin is validated.
        if(card.getMagnetStripe().charAt(0) != 'S' || card.getMagnetStripe().charAt(0) != 'I' || card.getMagnetStripe().charAt(0) != 'T'){
            System.out.println("Unauthorized access to baggage scanner request");
        }
        if(denialCounter == 2){
            operatingStation.getBaggageScanner().setStatus(Status.LOCKED);
            return false;
        }
        else{
            if(validatePin(card, pinToActivate)){
                operatingStation.getBaggageScanner().setStatus(Status.ACTIVATED);
                System.out.println("Pin entered accepted, baggage scanner activated");
                return true;
            }
            else{
                denialCounter++;
                System.out.println("Pin entered was false");
                //TODO doesnt this lock the BaggageScanner after one wrong Pin? Cause it continues to try to unlock it with the same Pin.
                activateBaggageScanner(card, pinToActivate);
            }
        }
        return false;
    }

    /** Try to unlock a locked BaggageScanner.
     *
     * @param card The IDCard that has been read.
     * @param pinToActivate The PIN entered.
     * @return Boolean if the action was successful.
     */
    public boolean unlockBaggageScanner(IDCard card, String pinToActivate){
        //TODO This should check against the list in the config, instead of a char.
        if(card.getMagnetStripe().charAt(0) != 'S'){
            System.out.println("Unauthorized access to baggage scanner request to unlock");
        }
        else{
            if(validatePin(card, pinToActivate)){
                operatingStation.getBaggageScanner().setStatus(Status.ACTIVATED);
                System.out.println("Baggage Scanner is unlocked");
                denialCounter = 0;
                return true;
            }
        }
        return false;
    }

    private boolean validatePin(IDCard card, String pinToActivate){
        String magnetStripe = card.getMagnetStripe();
        String decodedString = AES.decrypt(magnetStripe.substring(1), Configuration.instance.key);
        return decodedString.equals(pinToActivate);
    }
}
