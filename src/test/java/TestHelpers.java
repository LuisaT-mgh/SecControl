import Configuration.Configuration;
import Employee.Employee;
import General.Application;
import HandBaggage.HandBaggage;
import Passenger.Passenger;

import java.util.ArrayList;

public class TestHelpers {

    public static boolean checkIsAllowed(Application app, Employee employee, String functionality){
        switch (functionality){
            case "i":
                return app.baggageScanner.moveBeltForward(employee.getIdCard());
            case "ii":
                return app.baggageScanner.moveBeltBackwards(employee.getIdCard());
            case "iii":
                return app.baggageScanner.scan(employee.getIdCard());
            case "iv":
                return app.baggageScanner.alarm(employee.getIdCard(), "");
            case "v":
                return app.baggageScanner.report(employee.getIdCard());
            case "vi":
                return app.baggageScanner.maintenance(employee.getIdCard());
            default:
                return false;
        }
    }

    public static ArrayList<Passenger> generatePassengersWithItem(String items){
        ArrayList<Passenger> ret = new ArrayList<>();
        for(int i = 0; i< Configuration.instance.numTestPassengers; i++){
            Passenger pass = Passenger.getTestPassenger();
            pass.setHandBaggage(HandBaggage.generateRandomHandBaggages(items));
            ret.add(pass);
        }
        return ret;
    }
}
