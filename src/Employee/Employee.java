package Employee;

import java.text.ParseException;
import java.util.Date;
import java.util.UUID;
import Employee.IDCard;

public abstract class Employee {
    protected UUID id;
    protected String name;
    protected Date birthDate;
    protected IDCard idCard;
    protected String pinThatIsRemembered;

    public Employee(String name, Date birthDate) throws ParseException {
        this.name = name;
        this.birthDate = birthDate;
        id = UUID.randomUUID();

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public IDCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
    }



    public String getPinThatIsRemembered() {
        return pinThatIsRemembered;
    }

    public void setPinThatIsRemembered(String pinThatIsRemembered) {
        this.pinThatIsRemembered = pinThatIsRemembered;
    }
}

