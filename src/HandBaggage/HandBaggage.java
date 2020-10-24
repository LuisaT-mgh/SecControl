package HandBaggage;

import Passenger.Passenger;
import main.BaggageScanner.TestStrip;
import main.BaggageScanner.Tray;

import java.util.ArrayList;

public class HandBaggage {
    private Layer[] layers;
    private Tray tray;
    private Passenger passenger;
    private TestStrip testStrip;

    public HandBaggage(Layer[] layers) {
        layers = new Layer[5];
        this.layers = layers;
    }
}
