package BaggageScanner;

import java.util.ArrayList;

public class ExplosiveTraceDetector {
    private ArrayList<TestStrip> testStrips;

    public boolean checkTestStrip(TestStrip testStrip){
        for(int i = 0; i<30; i++){
            for (int j = 0; j<10; j++){
                if(testStrip.getSurface()[i][j] == 'e'){
                    if(testStrip.getSurface()[i][j+1] == 'x'){
                        if(testStrip.getSurface()[i][j+2] == 'p'){
                            System.out.println("Explosive trace detector detected explosives");
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
