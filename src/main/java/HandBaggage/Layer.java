package HandBaggage;

import java.util.Random;

public class Layer {
    private char[] character;
    private HandBaggage handBaggage;
    public Layer()
    {
        character = new char[10000];
        for(int i = 0; i<10000; i++){
            Random rand = new Random();
            int letterNumber = (rand.nextInt(125)+33);
            character[i] = ((char) letterNumber);
        }
    }

    public char[] getCharacter() {
        return character;
    }

    public void setCharacter(char[] character) {
        this.character = character;
    }

    public HandBaggage getHandBaggage() {
        return handBaggage;
    }

    public void setHandBaggage(HandBaggage handBaggage) {
        this.handBaggage = handBaggage;
    }
}
