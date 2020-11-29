import Employee.Employee;
import General.Application;

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
}
