package HandBaggage;

import java.util.Random;

public class Layer {
    private Character[] character;
    private HandBaggage handBaggage;
    public Layer()
    {
        character = new Character[10000];
        for(int i = 0; i<10000; i++){
            Random rand = new Random();
            int letterNumber = (rand.nextInt(125)+33);
            character[i] = ((char) letterNumber);
        }
    }

    public Character[] getCharacter() {
        return character;
    }

    public void setCharacter(Character[] character) {
        this.character = character;
    }

    public HandBaggage getHandBaggage() {
        return handBaggage;
    }

    public void setHandBaggage(HandBaggage handBaggage) {
        this.handBaggage = handBaggage;
    }
}
