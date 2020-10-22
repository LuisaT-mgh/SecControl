package main.BaggageScanner;

public class Button {
    private BaggageScanner baggageScanner;

    public Button(BaggageScanner baggageScanner) {
        this.baggageScanner = baggageScanner;
    }
    public void pressButton(){
        if (baggageScanner.getStatus() == Status.SHUTDOWN){
            baggageScanner.setStatus(Status.START);
            System.out.println("Baggage Scanner was started");
            baggageScanner.setStatus(Status.DEACTIVATED);
            System.out.println("Baggage Scanner is in status deactivated");
        }
        else{
            baggageScanner.setStatus(Status.SHUTDOWN);
            System.out.println("Baggage Scanner was shut down");
        }
    }
}
