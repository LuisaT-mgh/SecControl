package BaggageScanner;

public class Button {
    private IHasButton parent;
    private ButtonShape shape;

    public Button(IHasButton parent) {
        this.parent = parent;
    }

    public ButtonShape getShape() {
        return shape;
    }

    public void setShape(ButtonShape shape) {
        this.shape = shape;
    }
}
