package FerderalPoliceOffice;

import HandBaggage.HandBaggage;
import HandBaggage.HandBaggagePiece;
import HandBaggage.Layer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Robot {
    private Remote remote;

    public Robot(Remote remote) {
        this.remote = remote;
    }

    public void destroyHandBaggage(HandBaggage handBaggage) {
        ArrayList<char[]> pieces = new ArrayList<>();

        //Extract 50 char pieces
        for (int i = 0; i < handBaggage.getLayers().length; i++) {
            Layer layer = handBaggage.getLayers()[i];
            char[] current = new char[50];
            for (int j = 0; j < layer.getCharacter().length; j++) {
                if (j % 50 == 0) {
                    current = new char[50];
                    pieces.add(current);
                }
                current[j % 50] = layer.getCharacter()[j];
            }
        }

        List<HandBaggagePiece> handBaggagePieces = pieces.stream().map((item) -> new HandBaggagePiece(item)).collect(Collectors.toList());
        System.out.println("Hand baggage destroyed");
    }

    public Remote getRemote() {
        return remote;
    }
}
