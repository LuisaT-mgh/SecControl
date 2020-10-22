package Configuration;

import Employee.ProfileType;

import java.util.ArrayList;

public enum Configuration {
    instance;
    public String[] forbiddenItems = {"kn!fe", "glock|7", "exl|os!ve"};
    public ProfileType[] noFunctionalityAllowed = {ProfileType.K, ProfileType.O};
    public ProfileType[] functionalityOneTroughFour = {ProfileType.I};
    public ProfileType[] functionalityFive = {ProfileType.S};
    public ProfileType[] functionalitySix = {ProfileType.T};


}
