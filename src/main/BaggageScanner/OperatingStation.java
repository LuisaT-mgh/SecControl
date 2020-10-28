package main.BaggageScanner;

import Employee.Inspector;

public class OperatingStation implements IHasButton {
    private Reader reader;
    private BaggageScanner baggageScanner;
    private Button[] buttons;
    private Inspector inspector;

    public OperatingStation() {
        buttons = new Button[3];
        buttons[0] = new Button();
        buttons[1] = new Button();
        buttons[2] = new Button();
        buttons[0].setShape(ButtonShape.ARROW_RIGHT);
        buttons[1].setShape(ButtonShape.ARROW_LEFT);
        buttons[2].setShape(ButtonShape.RECTANGLE);
    }

    @Override
    public void handleButtonPushed(Button sender) {
        //TODO write function handleButtonPushed
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
