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

}
