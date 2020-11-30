package BaggageScanner;

import Configuration.Configuration;
import General.BoyerMoore;
import General.ISearchAlgorithm;
import General.KnuthMorrisPratt;
import HandBaggage.Layer;

public class Scanner {
    private BaggageScanner baggageScanner;
    public String scan(){
        Tray tray = baggageScanner.getBelt().getTrays().poll();
        ISearchAlgorithm iSearchAlgorithm = null;
        if(Configuration.instance.searchAlgorithm.toUpperCase().equals("BOYERMOORE")) {
            iSearchAlgorithm = new BoyerMoore();
        }
        else if(Configuration.instance.searchAlgorithm.toUpperCase().equals("KNUTMORRISPRATT")) {
            iSearchAlgorithm = new KnuthMorrisPratt();
        }
        if(!baggageScanner.getManualPostControl().isHasToBeConfiscated()) {
            for (Layer layer : tray.getHandBaggage().getLayers()) {
                for (String item : Configuration.instance.forbiddenItems) {
                    int position = iSearchAlgorithm.search(layer.getCharacter(), item.toCharArray());
                    if (position != -1) {
                        Record record = new Record(item, position);
                        baggageScanner.getRecords().add(record);
                        baggageScanner.getOperatingStation().getInspector().informManualPostControl(item, tray);
                        return item;
                    }
                }
            }
        }
        else{
            baggageScanner.getManualPostControl().getInspector().removeForbidden(tray);
        }
        Record record = new Record("no", -1);
        baggageScanner.getRecords().add(record);
        baggageScanner.getTracks()[1].getTrays().add(tray);
        System.out.println("No forbidden Item has been found");
        return null;
    }

    public BaggageScanner getBaggageScanner() {
        return baggageScanner;
    }

    public void setBaggageScanner(BaggageScanner baggageScanner) {
        this.baggageScanner = baggageScanner;
    }
}
