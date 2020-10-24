package Configuration;

import Employee.ProfileType;
import General.BoyerMoore;
import General.ISearchAlgorithm;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

public enum Configuration {
    instance;
    ZoneId zone = ZoneId.of("Europe/Berlin");
    public LocalDateTime localDateTime = LocalDateTime.now(zone);

    public String fileSeparator = System.getProperty("file.separator");
    public String userDirectory = System.getProperty("user.dir");
    public String passengerDataPath = userDirectory + fileSeparator + "data" + fileSeparator + "passenger_baggage.txt";
    public String passengerDataDelimiter = ";";
    public String passengerNameDelimiter = " ";

    public String[] forbiddenItems = {"kn!fe", "glock|7", "exl|os!ve"};
    public ProfileType[] noFunctionalityAllowed = {ProfileType.K, ProfileType.O};
    public ProfileType[] functionalityOneTroughFour = {ProfileType.I};
    public ProfileType[] functionalityFive = {ProfileType.S};
    public ProfileType[] functionalitySix = {ProfileType.T};
    //todo does not work public ISearchAlgorithm activeSearchAlgorithm = BoyerMoore;


}
