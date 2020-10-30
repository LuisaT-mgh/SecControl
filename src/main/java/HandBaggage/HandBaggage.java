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

    public Layer[] getLayers() {
        return layers;
    }

    public void setLayers(Layer[] layers) {
        this.layers = layers;
    }

    public Tray getTray() {
        return tray;
    }

    public void setTray(Tray tray) {
        this.tray = tray;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public TestStrip getTestStrip() {
        return testStrip;
    }

    public void setTestStrip(TestStrip testStrip) {
        this.testStrip = testStrip;
    }
}
