package BaggageScanner;

import Configuration.Configuration;
import Employee.IDCard;
import General.AES;

public class Reader {
    private OperatingStation operatingStation;
    private int denialCounter = 0;
    private IDCard lastUsedCard;

    public Reader() {
        lastUsedCard = null;
    }

    /**
     * Try to activate a BaggageScanner.
     *
     * @param card          The IDCard that has been read.
     * @param pinToActivate The PIN entered.
     * @return Boolean if the action was successful.
     */
    public boolean activateBaggageScanner(IDCard card, String pinToActivate) {
        if (operatingStation.getBaggageScanner().getStatus() != Status.LOCKED) {
            if (!validateAuthorisationInspector(card)) {
                System.out.println("Unauthorized access to baggage scanner request");
                return false;
            }
            if (denialCounter == 1) {
                System.out.println("Pin was entered wrong 3 times, baggage scanner locked");
                operatingStation.getBaggageScanner().setStatus(Status.LOCKED);
                card.setLocked(true);
                return false;
            } else {
                if (validatePin(card, pinToActivate)) {
                    operatingStation.getBaggageScanner().setStatus(Status.ACTIVATED);
                    System.out.println("Pin entered accepted, baggage scanner activated");
                    return true;
                } else {
                    if (lastUsedCard == null || !(lastUsedCard.getId().equals(card.getId()))) {
                        denialCounter = 0;
                        lastUsedCard = card;
                    } else {
                        denialCounter++;
                    }
                    System.out.println("Pin entered was false, please try again");
                }
            }
        } else {
            System.out.println("Baggage Scanner is locked");
        }
        return false;
    }

    /**
     * Try to unlock a locked BaggageScanner.
     *
     * @param card          The IDCard that has been read.
     * @param pinToActivate The PIN entered.
     * @return Boolean if the action was successful.
     */
    public boolean unlockBaggageScanner(IDCard card, String pinToActivate) {
        if (!validateAuthorisationSupervisor(card)) {
            System.out.println("Unauthorized access to baggage scanner request to unlock");
        } else {
            if (validatePin(card, pinToActivate)) {
                operatingStation.getBaggageScanner().setStatus(Status.ACTIVATED);
                System.out.println("Baggage Scanner is unlocked");
                denialCounter = 0;
                return true;
            }
        }
        return false;
    }

    private boolean validatePin(IDCard card, String pinToActivate) {
        String magnetStripe = card.getMagnetStripe();
        String decodedString = AES.decrypt(magnetStripe.substring(1), Configuration.instance.key);
        return decodedString.equals(pinToActivate);
    }

    private boolean validateAuthorisationInspector(IDCard card) {
        if (!card.isLocked()) {
            switch (card.getMagnetStripe().charAt(0)) {
                case 'S':
                case 'K':
                case 'O':
                case 'T':
                    return false;
                case 'I':
                    return true;
            }
        }
        return false;
    }

    private boolean validateAuthorisationSupervisor(IDCard card) {
        if (!card.isLocked()) {
            switch (card.getMagnetStripe().charAt(0)) {
                case 'K':
                case 'O':
                case 'T':
                case 'I':
                    return false;
                case 'S':
                    return true;
            }
        }
        return false;
    }

    public void setOperatingStation(OperatingStation operatingStation) {
        this.operatingStation = operatingStation;
    }

}
