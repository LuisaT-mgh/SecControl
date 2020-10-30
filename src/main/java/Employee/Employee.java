package Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public abstract class Employee {
    protected UUID id;
    protected String name;
    protected Date birthDate;
    protected IDCard idCard;
    protected String pinThatIsRemembered;

    public Employee(String name, String birthDate){
        this.name = name;
        try{
            this.birthDate = new SimpleDateFormat("dd/MM/yyyy").parse(birthDate);
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Error with parsing the birthDate while creating the main.Employee.");
        }
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

