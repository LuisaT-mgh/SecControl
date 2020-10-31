package BaggageScanner;

import Employee.IDCard;
import Employee.Inspector;
import Passenger.Passenger;

public class OperatingStation implements IHasButton {
    private Reader reader;
    private BaggageScanner baggageScanner;
    private Button buttonRight;
    private Button buttonLeft;
    private Button buttonRectangle;
    private Inspector inspector;
    private Passenger passengerManualPostControl;

    public OperatingStation() {
        buttonRight = new Button(this);
        buttonLeft = new Button(this);
        buttonRectangle = new Button(this);
        buttonRight.setShape(ButtonShape.ARROW_RIGHT);
        buttonLeft.setShape(ButtonShape.ARROW_LEFT);
        buttonRectangle.setShape(ButtonShape.RECTANGLE);
    }

    @Override
    public void handleButtonPushed(Button sender, IDCard idCard) {
        if(idCard.getId().equals(inspector.getId())) {
            switch (sender.getShape()) {
                case RECTANGLE:
                    baggageScanner.scan(inspector.getIdCard());
                case ARROW_LEFT:
                    baggageScanner.moveBeltForward(inspector.getIdCard());
                case ARROW_RIGHT:
                    baggageScanner.moveBeltBackwards(inspector.getIdCard());
            }
        }
        else{
            System.out.println("Unauthorised handling of baggage scanner");
        }
    }

    public Inspector getInspector() {
        return inspector;
    }

    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public BaggageScanner getBaggageScanner() {
        return baggageScanner;
    }


    public Button getButtonRight() {
        return buttonRight;
    }

    public void setButtonRight(Button buttonRight) {
        this.buttonRight = buttonRight;
    }

    public Button getButtonLeft() {
        return buttonLeft;
    }

    public void setButtonLeft(Button buttonLeft) {
        this.buttonLeft = buttonLeft;
    }

    public Button getButtonRectangle() {
        return buttonRectangle;
    }

    public void setButtonRectangle(Button buttonRectangle) {
        this.buttonRectangle = buttonRectangle;
    }

    public void setBaggageScanner(BaggageScanner baggageScanner) {
    }

    public Passenger getPassengerManualPostControl() {
        return passengerManualPostControl;
    }

    public void setPassengerManualPostControl(Passenger passengerManualPostControl) {
        this.passengerManualPostControl = passengerManualPostControl;
    }
}
