package BaggageScanner;

import Configuration.Configuration;
import Employee.IDCard;
import General.AES;
import BaggageScanner.OperatingStation;

public class Reader {
    private OperatingStation operatingStation;
    private int denialCounter = 0;
    private IDCard lastUsedCard;

    /** Try to activate a BaggageScanner.
     *
     * @param card The IDCard that has been read.
     * @param pinToActivate The PIN entered.
     * @return Boolean if the action was successful.
     */
    public void activateBaggageScanner(IDCard card, String pinToActivate){
        if(!validateAuthorisationInspector(card)){
            System.out.println("Unauthorized access to baggage scanner request");
            return;
        }
        if(denialCounter == 2){
            operatingStation.getBaggageScanner().setStatus(Status.LOCKED);
            return;
        }
        else{
            if(validatePin(card, pinToActivate)){
                operatingStation.getBaggageScanner().setStatus(Status.ACTIVATED);
                System.out.println("Pin entered accepted, baggage scanner activated");
                return;
            }
            else{
                if(lastUsedCard == null || !(lastUsedCard.getId().equals(card.getId()))) {
                    denialCounter = 0;
                }
                else {
                    denialCounter++;
                }
                System.out.println("Pin entered was false, please try again");
                //TODO doesnt this lock the BaggageScanner after one wrong Pin? Cause it continues to try to unlock it with the same Pin.
            }
        }
        return;
    }

    /** Try to unlock a locked BaggageScanner.
     *
     * @param card The IDCard that has been read.
     * @param pinToActivate The PIN entered.
     * @return Boolean if the action was successful.
     */
    public boolean unlockBaggageScanner(IDCard card, String pinToActivate){
        //TODO This should check against the list in the config, instead of a char.
        if(!validateAuthorisationSupervisor(card )){
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
    private boolean validateAuthorisationInspector(IDCard card){
        switch (card.getMagnetStripe().charAt(0)){
            case 'S':
            case 'K':
            case 'O':
            case 'T':
                return false;
            case 'I':
                return true;
        }
        return false;
    }

    private boolean validateAuthorisationSupervisor(IDCard card){
        switch (card.getMagnetStripe().charAt(0)){
            case 'K':
            case 'O':
            case 'T':
            case 'I':
                return false;
            case 'S':
                return true;
        }
        return false;
    }

    public OperatingStation getOperatingStation() {
        return operatingStation;
    }

    public void setOperatingStation(OperatingStation operatingStation) {
        this.operatingStation = operatingStation;
    }

    public int getDenialCounter() {
        return denialCounter;
    }

    public void setDenialCounter(int denialCounter) {
        this.denialCounter = denialCounter;
    }
}
