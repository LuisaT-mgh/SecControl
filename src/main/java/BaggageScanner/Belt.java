package BaggageScanner;

import java.util.Queue;

public class Belt {
    private Queue<Tray> trays;

    public Queue<Tray> getTrays() {
        return trays;
    }

    public void setTrays(Queue<Tray> trays) {
        this.trays = trays;
    }
}
