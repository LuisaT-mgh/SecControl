package HandBaggage;

import BaggageScanner.Tray;
import Configuration.Configuration;

import java.util.ArrayList;
import java.util.Random;

public class HandBaggage {
    private Layer[] layers;
    private Tray tray;

    //For debugging only
    private String contains = "";

    public HandBaggage(Layer[] layers) {
        this.layers = layers;
    }

    public static ArrayList<HandBaggage> generateRandomHandBaggages(String itemsToHide) {
        int numBaggages = Configuration.instance.r.nextInt(2) + 1;
        if (itemsToHide.equals("")) return generateHandBaggages(numBaggages, new String[]{"-"});
        String[] hiddenItems = new String[itemsToHide.length()];
        for (int i = 0; i < itemsToHide.length(); i++) {
            char current = itemsToHide.charAt(i);
            int numberToHide = 1;
            int layerToHide = Configuration.instance.r.nextInt(5) + 1;
            hiddenItems[i] = current + "," + numberToHide + "," + layerToHide + "]";
        }
        return generateHandBaggages(numBaggages, hiddenItems);
    }

    public static ArrayList<HandBaggage> generateHandBaggages(int numberOfBaggage, String[] hiddenItems) {
        ArrayList<HandBaggage> handBaggage = new ArrayList<>();
        ArrayList<Integer> numberOfForbiddenBaggage = new ArrayList<>();
        ArrayList<Integer> numberOfForbiddenLayer = new ArrayList<>();
        ArrayList<String> forbiddenItems = new ArrayList<>();
        String illegalChars = "";
        if (!hiddenItems[0].contentEquals("-")) {
            for (String hiddenItem : hiddenItems) {
                hiddenItem = hiddenItem.replace("]", "");
                String[] dataHasForbiddenItem = hiddenItem.split(",");
                numberOfForbiddenBaggage.add(Integer.parseInt(dataHasForbiddenItem[1]));
                numberOfForbiddenLayer.add(Integer.parseInt(dataHasForbiddenItem[2]));
                switch (dataHasForbiddenItem[0]) {
                    case "K":
                        forbiddenItems.add(Configuration.instance.forbiddenItems[0]);
                        illegalChars += "K";
                        break;
                    case "W":
                        forbiddenItems.add(Configuration.instance.forbiddenItems[1]);
                        illegalChars += "W";
                        break;
                    case "E":
                        forbiddenItems.add(Configuration.instance.forbiddenItems[2]);
                        illegalChars += "E";
                        break;
                }
            }
        }
        for (int i = 0; i < numberOfBaggage; i++) {
            Layer[] layers = new Layer[5];
            for (int j = 0; j < 5; j++) {
                Layer layer = new Layer();
                for (int determineCounter = 0; determineCounter < numberOfForbiddenBaggage.size(); determineCounter++) {
                    if (numberOfForbiddenBaggage.get(determineCounter) == (i + 1)) {
                        if (numberOfForbiddenLayer.get(determineCounter).equals(j + 1)) {
                            layer = hideItemInLayer(layer, forbiddenItems.get(determineCounter));
                        }
                    }
                }
                layers[j] = layer;
            }
            HandBaggage handBaggage1 = new HandBaggage(layers);
            handBaggage1.contains = illegalChars;
            handBaggage.add(handBaggage1);
        }
        return handBaggage;
    }

    private static Layer hideItemInLayer(Layer layer, String item) {
        Random rand = new Random();
        int letterNumber = rand.nextInt(9999 - item.length());
        char[] temporaryCharacter = layer.getCharacter();
        for (int i = 0; i < item.length(); i++) {
            temporaryCharacter[letterNumber] = item.charAt(i);
            letterNumber++;
        }
        layer.setCharacter(temporaryCharacter);
        return layer;
    }

    public Layer[] getLayers() {
        return layers;
    }

    public Tray getTray() {
        return tray;
    }

    public void setTray(Tray tray) {
        this.tray = tray;
    }
}
