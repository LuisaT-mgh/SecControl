package Configuration;

import Employee.ProfileType;

import java.time.LocalDateTime;
import java.time.ZoneId;

public enum Configuration {
    instance;
    ZoneId zone = ZoneId.of("Europe/Berlin");
    public LocalDateTime localDateTime = LocalDateTime.now(zone);

    public String fileSeparator = System.getProperty("file.separator");
    public String userDirectory = System.getProperty("user.dir");
    //public String passengerDataPath = userDirectory + fileSeparator + "src" + fileSeparator + "main" + fileSeparator + "resources" + fileSeparator + "passenger_baggage.txt";
    public String passengerDataPath = userDirectory + fileSeparator + "src" + fileSeparator + "main" + fileSeparator + "resources" + fileSeparator + "testFile.txt";
    public String passengerDataDelimiter = ";";
    public String passengerNameDelimiter = " ";

    public String[] forbiddenItems = {"kn!fe", "glock|7", "exl|os!ve"};
    public String key = "FranzJosefStrauß";
    public String searchAlgorithm = "BoyerMoore";
    public ProfileType[] noFunctionalityAllowed = {ProfileType.K, ProfileType.O};
    public ProfileType[] functionalityOneTroughFour = {ProfileType.I};
    public ProfileType[] functionalityFive = {ProfileType.S};
    public ProfileType[] functionalitySix = {ProfileType.T};
    //todo does not work public ISearchAlgorithm activeSearchAlgorithm = BoyerMoore;


}
