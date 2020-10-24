package General;

import Configuration.Configuration;
import HandBaggage.HandBaggage;
import Passenger.Passenger;
import HandBaggage.Layer;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Application {
    public static void main(String... args) throws InterruptedException {
        Application application = new Application();
        application.startSecurityControl(application.generatePassengers());
    }

    public void startSecurityControl(ArrayList<Passenger> passengers){
        ArrayList<Passenger> passengerList= new ArrayList<>();
        passengerList = passengers;
        System.out.println("Passengers have been generated");
    }

    public ArrayList<Passenger> generatePassengers(){
        ArrayList<Passenger> passengers = new ArrayList<>();
        try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Configuration.instance.passengerDataPath)));
            while ((line = bufferedReader.readLine()) != null) {
                String[] passengerData = line.split(Configuration.instance.passengerDataDelimiter);
                String[] combinedName = passengerData[0].split(Configuration.instance.passengerNameDelimiter);
                String firstName = combinedName[0];
                String lastName = combinedName[1];
                int numberOfHandBaggage = Integer.parseInt(passengerData[1]);
                String hasForbiddenItem = passengerData[2];
                Passenger passenger = new Passenger(firstName, lastName);
                passenger.setHandBaggage(generateHandBaggage(numberOfHandBaggage, hasForbiddenItem));
                passengers.add(passenger);
            }

        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return passengers;
    }
    public ArrayList<HandBaggage> generateHandBaggage(int numberOfBaggage, String hasForbiddenItem){
        ArrayList<HandBaggage> handBaggage = new ArrayList<>();
        int numberOfForbiddenBaggage = 15;
        int numberOfForbiddenLayer = 15;
        String forbiddenItem = null;
        if(!hasForbiddenItem.contentEquals("-")){
            hasForbiddenItem = hasForbiddenItem.replace("[", "");
            hasForbiddenItem = hasForbiddenItem.replace("]", "");
            String[] dataHasForbiddenItem = hasForbiddenItem.split(",");
            numberOfForbiddenBaggage = Integer.parseInt(dataHasForbiddenItem[1]);
            numberOfForbiddenLayer = Integer.parseInt(dataHasForbiddenItem[2]);
            switch (dataHasForbiddenItem[0]){
                case "K":
                    forbiddenItem = Configuration.instance.forbiddenItems[0];
                    break;
                case "W":
                    forbiddenItem = Configuration.instance.forbiddenItems[1];
                    break;
                case "E":
                    forbiddenItem = Configuration.instance.forbiddenItems[2];
                    break;
            }
        }
        for(int i = 0; i<numberOfBaggage; i++){
            Layer[] layers = new Layer[5];
            for(int j = 0; j<5; j++){
                Layer layer = new Layer();
                if(numberOfForbiddenBaggage == i && numberOfForbiddenLayer == j){
                    layer = hideItemInLayer(layer, forbiddenItem);
                }
                layers[j] = layer;
            }
            HandBaggage handBaggage1 = new HandBaggage(layers);
            handBaggage.add(handBaggage1);
        }
        return handBaggage;
    }

    public Layer hideItemInLayer(Layer layer, String item){
        Random rand = new Random();
        int letterNumber = rand.nextInt(9999-item.length());
        Character[] temporaryCharacter = layer.getCharacter();
        for (int i = 0; i<item.length();i++){
            temporaryCharacter[letterNumber] = item.charAt(i);
            letterNumber++;
        }
        layer.setCharacter(temporaryCharacter);
        return layer;
    }
}
