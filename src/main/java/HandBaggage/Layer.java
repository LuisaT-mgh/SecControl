package HandBaggage;

import java.util.Random;

public class Layer {
    private char[] character;

    public Layer() {
        character = new char[10000];
        for (int i = 0; i < 10000; i++) {
            Random rand = new Random();
            int letterNumber = (rand.nextInt(125) + 33);
            character[i] = ((char) letterNumber);
        }
    }

    public char[] getCharacter() {
        return character;
    }

    public void setCharacter(char[] character) {
        this.character = character;
    }
}
