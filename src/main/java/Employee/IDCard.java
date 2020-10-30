package Employee;

import Configuration.Configuration;
import General.AES;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

public class IDCard {
    private UUID id;
    private Date validUntil;
    private String magnetStripe;
    private boolean isLocked;
    private IDCardType type;
    private Employee employee;

    public IDCard(UUID id, Employee employee, ProfileType profileType){
        this.id = id;
        isLocked = false;
        try {
            validUntil = new SimpleDateFormat("dd/MM/yyyy").parse("24/03/2100");
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Error while parsing the Date for the IDCard.");
        }
        this.employee = employee;
        Random random = new Random();
        String pin = String.format("%04d", random.nextInt(10000));
        employee.setPinThatIsRemembered(pin);
        magnetStripe = (String.valueOf(profileType) + AES.encrypt(pin, Configuration.instance.key));
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }

    public String getMagnetStripe() {
        return magnetStripe;
    }

    public void setMagnetStripe(String magnetStripe) {
        this.magnetStripe = magnetStripe;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public IDCardType getType() {
        return type;
    }

    public void setType(IDCardType type) {
        this.type = type;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
