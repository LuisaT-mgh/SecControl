package Employee;

import java.awt.*;
import java.util.Date;
import java.util.UUID;

public class IDCard {
    private UUID id;
    private Date validUntil;
    private MagnetStripe magnetStripe;
    private boolean isLocked;
    private IDCardType type;
    private Employee employee;

    public IDCard(UUID id, Employee employee) {
        this.id = id;
        isLocked = false;
        //TODO validuntil auf in 4 Jahren setzten?
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

    public MagnetStripe getMagnetStripe() {
        return magnetStripe;
    }

    public void setMagnetStripe(MagnetStripe magnetStripe) {
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
