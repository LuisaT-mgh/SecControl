package BaggageScanner;

import Employee.IDCard;

public interface IHasButton {
    void handleButtonPushed(Button sender, IDCard idCard);
}
