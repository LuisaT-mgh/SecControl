package HandBaggage;

import Passenger.Passenger;
import BaggageScanner.TestStrip;
import BaggageScanner.Tray;

public class HandBaggage {
    private Layer[] layers;
    private Tray tray;
    private Passenger passenger;
    private TestStrip testStrip;

    public HandBaggage(Layer[] layers) {
        this.layers = layers;
    }
}
