package BaggageScanner;

import HandBaggage.HandBaggage;

public class Tray {
    private Track track;
    private HandBaggage handBaggage;
    private RollerConveyor rollerConveyor;

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public HandBaggage getHandBaggage() {
        return handBaggage;
    }

    public void setHandBaggage(HandBaggage handBaggage) {
        this.handBaggage = handBaggage;
    }

    public RollerConveyor getRollerConveyor() {
        return rollerConveyor;
    }

    public void setRollerConveyor(RollerConveyor rollerConveyor) {
        this.rollerConveyor = rollerConveyor;
    }
}
