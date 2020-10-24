package main.BaggageScanner;

public class OperatingStation implements IHasButton {
    private Reader reader;
    private BaggageScanner baggageScanner;
    private Button[] buttons;

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
}
