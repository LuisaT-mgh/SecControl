package BaggageScanner;

import HandBaggage.HandBaggage;

public class TestStrip {
    private Character[][] surface;
    private HandBaggage handBaggage;

    public TestStrip() {
        surface = new Character[30][10];
        for(int i = 0; i<30; i++){
            for(int j = 0; j<10; j++){
                surface[i][j] = 'p';
            }
        }
    }


    public Character[][] getSurface() {
        return surface;
    }

    public void setSurface(Character[][] surface) {
        this.surface = surface;
    }
}
