package BaggageScanner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Record {
    private UUID id;
    private String timeStamp;
    private String result;
    private String hiddenItem;
    private int position;

    public Record(String hiddenItem, int position) {
        id = UUID.randomUUID();
        DateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy hh:mm:ss,SSS");
        timeStamp = dateFormat.format(System.currentTimeMillis());
        if(position == -1){
            this.result = "clean";
        }
        else{
            System.out.println("prohibited item "+hiddenItem+" detected at position "+String.valueOf(position));
            this.result = "prohibited item "+hiddenItem+" detected at position "+String.valueOf(position);
        }
    }
}
