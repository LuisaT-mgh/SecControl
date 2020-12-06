package BaggageScanner;

import java.util.LinkedList;
import java.util.Queue;

public class Belt {
    private Queue<Tray> trays;

    public Belt() {
        trays = new LinkedList<Tray>();
    }

    public Queue<Tray> getTrays() {
        return trays;
    }
}
