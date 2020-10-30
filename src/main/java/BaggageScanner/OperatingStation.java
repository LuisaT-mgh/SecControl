package BaggageScanner;

import Employee.IDCard;
import Employee.Inspector;

public class OperatingStation implements IHasButton {
    private Reader reader;
    private BaggageScanner baggageScanner;
    private Button[] buttons;
    private Inspector inspector;

    public OperatingStation() {
        buttons = new Button[3];
        buttons[0] = new Button(this);
        buttons[1] = new Button(this);
        buttons[2] = new Button(this);
        buttons[0].setShape(ButtonShape.ARROW_RIGHT);
        buttons[1].setShape(ButtonShape.ARROW_LEFT);
        buttons[2].setShape(ButtonShape.RECTANGLE);
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

    public void setBaggageScanner(BaggageScanner baggageScanner) {
        this.baggageScanner = baggageScanner;
    }

    public Button[] getButtons() {
        return buttons;
    }

    public void setButtons(Button[] buttons) {
        this.buttons = buttons;
    }
}
