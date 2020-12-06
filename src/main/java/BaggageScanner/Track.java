package BaggageScanner;

import java.util.ArrayList;

public class Track {
    private int trackNumber;
    private ArrayList<Tray> trays;

    public Track(int trackNumber) {
        this.trackNumber = trackNumber;
        trays = new ArrayList<>();
    }

    public int getTrackNumber() {
        return trackNumber;
    }

    public ArrayList<Tray> getTrays() {
        return trays;
    }
}
