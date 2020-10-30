package BaggageScanner;

import Employee.IDCard;

public class Button {
    private IHasButton parent;
    private ButtonShape shape;

    public Button(IHasButton parent) {
        this.parent = parent;
    }

    public void pushButton(IDCard card){
        parent.handleButtonPushed(this, card);
    }

    public ButtonShape getShape() {
        return shape;
    }

    public void setShape(ButtonShape shape) {
        this.shape = shape;
    }
}
