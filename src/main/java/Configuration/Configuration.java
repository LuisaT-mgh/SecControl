package Configuration;

import java.util.Random;

public enum Configuration {
    instance;
    public String fileSeparator = System.getProperty("file.separator");
    public String userDirectory = System.getProperty("user.dir");
    public String passengerDataPath = userDirectory + fileSeparator + "src" + fileSeparator + "main" + fileSeparator + "resources" + fileSeparator + "passenger_baggage.txt";
    public String passengerNameDelimiter = " ";

    public String[] forbiddenItems = {"kn!fe", "glock|7", "exl|os!ve"};
    public String key = "FranzJosefStrauß";
    public String searchAlgorithm = "BoyerMoore";
    //public String searchAlgorithm = "KnuthMorrisPratt";

    public Random r = new Random();

    //For Testing
    public int numTestPassengers = 42;

}
