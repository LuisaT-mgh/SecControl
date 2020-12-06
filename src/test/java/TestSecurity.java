import BaggageScanner.*;
import Employee.*;
import General.Application;
import HandBaggage.HandBaggage;
import HandBaggage.Layer;
import Passenger.Passenger;
import org.junit.jupiter.api.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestSecurity {

    Application app;

    @BeforeEach
    public void setUp(){
        app = new Application();
        app.generateSecurityControl();
    }

    @Test
    @DisplayName("1. Test num passenger/baggage")
    public void testInitialize(){
        //1.Die Simulation mit (i) 568 Passagieren und 609 Gepäckstücken wird korrekt initialisiert.
        //TODO Maybe add more.
        Assertions.assertEquals(568, app.passengers.size());

        ArrayList<Passenger> passengers = new ArrayList<>(app.passengers);
        List<Integer> numberBaggages = passengers.stream().map(passenger -> passenger.getHandBaggage().size()).collect(Collectors.toList());
        int sum = 0;
        for(Integer integer : numberBaggages){
            sum += integer;
        }
        Assertions.assertEquals(609, sum);
    }

    @Test
    @DisplayName("2. Check workplaces")
    public void testAssignmentOfEmployees(){
        //2.Die Positionen an dem Gepäckscanner werden korrekt mit Mitarbeitern besetzt.

        //Create Dates
        Date conveyorDate = null, operatorDate = null, postControlDate = null, supervisorDate = null, policeDate = null, technicianDate = null, houseKeepingDate = null, additionalPoliceDate = null, additionalAdditionalPoliceDate = null;
        try{
            conveyorDate = new SimpleDateFormat("dd/MM/yyyy").parse("31/05/1930");
            operatorDate = new SimpleDateFormat("dd/MM/yyyy").parse("09/06/1981");
            postControlDate = new SimpleDateFormat("dd/MM/yyyy").parse("19/03/1955");
            supervisorDate = new SimpleDateFormat("dd/MM/yyyy").parse("19/11/1962");
            policeDate = new SimpleDateFormat("dd/MM/yyyy").parse("31/07/1962");
            technicianDate = new SimpleDateFormat("dd/MM/yyyy").parse("26/07/1967");
            houseKeepingDate = new SimpleDateFormat("dd/MM/yyyy").parse("17/07/1969");
            additionalPoliceDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1969");
            additionalAdditionalPoliceDate = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1969");
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Error while creating the BirthDates to check against.");
        }

        //Inspektor Rollenbahn
        Employee current = app.baggageScanner.getRollerConveyor().getInspector();
        Assertions.assertNotNull(current);
        Assertions.assertEquals("Clint Eastwood", current.getName());
        Assertions.assertEquals(conveyorDate, current.getBirthDate());
        Assertions.assertEquals(Inspector.class, current.getClass());
        Assertions.assertTrue(((Inspector)current).isSenior());

        //Inspektorin Bedienplatz
        current = app.baggageScanner.getOperatingStation().getInspector();
        Assertions.assertNotNull(current);
        Assertions.assertEquals("Natalie Portman", current.getName());
        Assertions.assertEquals(operatorDate, current.getBirthDate());
        Assertions.assertEquals(Inspector.class, current.getClass());
        Assertions.assertFalse(((Inspector)current).isSenior());

        //Inspektor Nachkontrolle
        current = app.baggageScanner.getManualPostControl().getInspector();
        Assertions.assertNotNull(current);
        Assertions.assertEquals("Bruce Willis", current.getName());
        Assertions.assertEquals(postControlDate, current.getBirthDate());
        Assertions.assertEquals(Inspector.class, current.getClass());
        Assertions.assertTrue(((Inspector)current).isSenior());

        //Supervisor am Arbeitsplatz SV
        current = app.baggageScanner.getSupervision().getSupervisor();
        Assertions.assertNotNull(current);
        Assertions.assertEquals("Jodie Foster", current.getName());
        Assertions.assertEquals(supervisorDate, current.getBirthDate());
        Assertions.assertEquals(Supervisor.class, current.getClass());

        //Bundespolizist
        current = app.baggageScanner.getFederalPoliceOfficer();
        Assertions.assertNotNull(current);
        Assertions.assertEquals("Wesley Snipes", current.getName());
        Assertions.assertEquals(policeDate, current.getBirthDate());
        Assertions.assertEquals(FederalPoliceOfficer.class, current.getClass());

        //Techniker
        current = app.technician;
        Assertions.assertNotNull(current);
        Assertions.assertEquals("Jason Statham", current.getName());
        Assertions.assertEquals(technicianDate, current.getBirthDate());
        Assertions.assertEquals(Technician.class, current.getClass());

        //HoseKeeping
        current = app.houseKeeping;
        Assertions.assertNotNull(current);
        Assertions.assertEquals("Jason Clarke", current.getName());
        Assertions.assertEquals(houseKeepingDate, current.getBirthDate());
        Assertions.assertEquals(HouseKeeping.class, current.getClass());

        //Zusätzliche Polizisten
        current = app.federalPoliceOffice.getRegisteredOfficers().get(0);
        Employee other = app.federalPoliceOffice.getRegisteredOfficers().get(1);
        Assertions.assertNotNull(current);
        Assertions.assertNotNull(other);
        if(!current.getName().equals("Toto")){
            Employee temp = current;
            current = other;
            other = temp;
        }
        Assertions.assertEquals("Toto", current.getName());
        Assertions.assertEquals(additionalPoliceDate, current.getBirthDate());
        Assertions.assertEquals(FederalPoliceOfficer.class, current.getClass());
        Assertions.assertEquals("Harry", other.getName());
        Assertions.assertEquals(additionalAdditionalPoliceDate, other.getBirthDate());
        Assertions.assertEquals(FederalPoliceOfficer.class, other.getClass());
    }

    @Test
    @DisplayName("3. Test locking IDCard after 3 wrong inputs")
    public void testLockingIDCard(){
        //3.Nach dreimaliger Falschangabe der PIN wird der Ausweis für die weitere Nutzung gesperrt.
        OperatingStation opStation = app.baggageScanner.getOperatingStation();
        Assertions.assertFalse(opStation.getInspector().getIdCard().isLocked());

        //Pins are always between 0 and 10000, so 10001 is always wrong.
        Assertions.assertFalse(opStation.getReader().activateBaggageScanner(opStation.getInspector().getIdCard(), "10001"));
        Assertions.assertFalse(opStation.getInspector().getIdCard().isLocked());
        Assertions.assertFalse(opStation.getReader().activateBaggageScanner(opStation.getInspector().getIdCard(), "10001"));
        Assertions.assertFalse(opStation.getInspector().getIdCard().isLocked());
        Assertions.assertFalse(opStation.getReader().activateBaggageScanner(opStation.getInspector().getIdCard(), "10001"));
        Assertions.assertTrue(opStation.getInspector().getIdCard().isLocked());
    }

    @Test
    @DisplayName("4. Test permissions for BaggageScanner")
    public void testBaggageScannerPermissions(){
        //4.Ein Mitarbeiter mit dem Profil K oder O kann sich an einem Gepäckscanner nicht anmelden.
        OperatingStation opStation = app.baggageScanner.getOperatingStation();

        //Profil K
        HouseKeeping houseKeeping = new HouseKeeping("Bill Gates", "01/01/2000");
        Assertions.assertFalse(opStation.getReader().activateBaggageScanner(houseKeeping.getIdCard(), houseKeeping.getPinThatIsRemembered()));

        //Profil O
        FederalPoliceOfficer officer = new FederalPoliceOfficer("Bad Guy", "11/11/2011", "officer");
        Assertions.assertFalse(opStation.getReader().activateBaggageScanner(officer.getIdCard(), officer.getPinThatIsRemembered()));
    }

    @Test
    @DisplayName("5. Test permissions for functions")
    public void testFunctionPermissions(){
        //5.Ein Mitarbeiter kann nur die - gemäß Profil - zugeordneten Funktionalitäten ausführen.
        //i - Band vor
        //ii - Band zurück
        //iii - Scan
        //iv - Alarm
        //v - Report
        //vi - Wartung
        //Profile: K, O - nichts
        //I - i bis iv
        //S - v
        //T - vi

        //Setup
        Employee typeK = new HouseKeeping("Bill Gates", "01/01/2000");
        Employee typeO = new FederalPoliceOfficer("Bad Guy", "11/11/2011", "officer");
        Employee typeI = new Inspector("Angela Merkel", "01/01/2000", true);
        Employee typeS = new Supervisor("Peter Parker", "01/01/2000", false, true);
        Employee typeT = new Technician("Harry Potter", "01/01/2000");

        Assertions.assertEquals('K', typeK.getIdCard().getMagnetStripe().charAt(0));
        Assertions.assertEquals('O', typeO.getIdCard().getMagnetStripe().charAt(0));
        Assertions.assertEquals('I', typeI.getIdCard().getMagnetStripe().charAt(0));
        Assertions.assertEquals('S', typeS.getIdCard().getMagnetStripe().charAt(0));
        Assertions.assertEquals('T', typeT.getIdCard().getMagnetStripe().charAt(0));


        //Test Profile K
        Assertions.assertFalse(TestHelpers.checkIsAllowed(app, typeK, "i"));
        Assertions.assertFalse(TestHelpers.checkIsAllowed(app, typeK, "ii"));
        Assertions.assertFalse(TestHelpers.checkIsAllowed(app, typeK, "iii"));
        Assertions.assertFalse(TestHelpers.checkIsAllowed(app, typeK, "iv"));
        Assertions.assertFalse(TestHelpers.checkIsAllowed(app, typeK, "v"));
        Assertions.assertFalse(TestHelpers.checkIsAllowed(app, typeK, "vi"));
        //Test Profile O
        Assertions.assertFalse(TestHelpers.checkIsAllowed(app, typeO, "i"));
        Assertions.assertFalse(TestHelpers.checkIsAllowed(app, typeO, "ii"));
        Assertions.assertFalse(TestHelpers.checkIsAllowed(app, typeO, "iii"));
        Assertions.assertFalse(TestHelpers.checkIsAllowed(app, typeO, "iv"));
        Assertions.assertFalse(TestHelpers.checkIsAllowed(app, typeO, "v"));
        Assertions.assertFalse(TestHelpers.checkIsAllowed(app, typeO, "vi"));
        //Test Profile I
        Assertions.assertTrue(TestHelpers.checkIsAllowed(app, typeI, "i"));
        Assertions.assertTrue(TestHelpers.checkIsAllowed(app, typeI, "ii"));
        Assertions.assertTrue(TestHelpers.checkIsAllowed(app, typeI, "iii"));
        Assertions.assertTrue(TestHelpers.checkIsAllowed(app, typeI, "iv"));
        Assertions.assertFalse(TestHelpers.checkIsAllowed(app, typeI, "v"));
        Assertions.assertFalse(TestHelpers.checkIsAllowed(app, typeI, "vi"));
        //Test Profile S
        Assertions.assertFalse(TestHelpers.checkIsAllowed(app, typeS, "i"));
        Assertions.assertFalse(TestHelpers.checkIsAllowed(app, typeS, "ii"));
        Assertions.assertFalse(TestHelpers.checkIsAllowed(app, typeS, "iii"));
        Assertions.assertFalse(TestHelpers.checkIsAllowed(app, typeS, "iv"));
        Assertions.assertTrue(TestHelpers.checkIsAllowed(app, typeS, "v"));
        Assertions.assertFalse(TestHelpers.checkIsAllowed(app, typeS, "vi"));
        //Test Profile T
        Assertions.assertFalse(TestHelpers.checkIsAllowed(app, typeT, "i"));
        Assertions.assertFalse(TestHelpers.checkIsAllowed(app, typeT, "ii"));
        Assertions.assertFalse(TestHelpers.checkIsAllowed(app, typeT, "iii"));
        Assertions.assertFalse(TestHelpers.checkIsAllowed(app, typeT, "iv"));
        Assertions.assertFalse(TestHelpers.checkIsAllowed(app, typeT, "v"));
        Assertions.assertTrue(TestHelpers.checkIsAllowed(app, typeT, "vi"));
    }

    @Test
    @DisplayName("6. Only Supervisor can unlock")
    public void testSupervisorUnlock(){
        //6.Nur ein Supervisor kann einen Gepäckscanner im Status locked entsperren.
        FederalPoliceOfficer officer = new FederalPoliceOfficer("Bad Guy", "11/11/2011", "officer");
        HouseKeeping houseKeeping = new HouseKeeping("Bill Gates", "01/01/2000");
        Inspector inspector = new Inspector("Inspektor Gadget", "11/11/2011", true);
        Technician technician = new Technician("Harald Herbert", "12/12/2012");
        Supervisor supervisor = new Supervisor("Max Mustermann", "01/02/2003", true, false);

        //Lock the BaggageScanner
        BaggageScanner baggageScanner = app.baggageScanner;
        baggageScanner.setStatus(Status.LOCKED);
        Assertions.assertEquals(Status.LOCKED, baggageScanner.getStatus());

        //Test unauthorised Employees
        Assertions.assertFalse(baggageScanner.getOperatingStation().getReader().unlockBaggageScanner(officer.getIdCard(), officer.getPinThatIsRemembered()));
        Assertions.assertEquals(Status.LOCKED, baggageScanner.getStatus());
        Assertions.assertFalse(baggageScanner.getOperatingStation().getReader().unlockBaggageScanner(houseKeeping.getIdCard(), houseKeeping.getPinThatIsRemembered()));
        Assertions.assertEquals(Status.LOCKED, baggageScanner.getStatus());
        Assertions.assertFalse(baggageScanner.getOperatingStation().getReader().unlockBaggageScanner(inspector.getIdCard(), inspector.getPinThatIsRemembered()));
        Assertions.assertEquals(Status.LOCKED, baggageScanner.getStatus());
        Assertions.assertFalse(baggageScanner.getOperatingStation().getReader().unlockBaggageScanner(technician.getIdCard(), technician.getPinThatIsRemembered()));
        Assertions.assertEquals(Status.LOCKED, baggageScanner.getStatus());

        //Test authorized Employee
        Assertions.assertTrue(baggageScanner.getOperatingStation().getReader().unlockBaggageScanner(supervisor.getIdCard(), supervisor.getPinThatIsRemembered()));
        Assertions.assertNotEquals(Status.LOCKED, baggageScanner.getStatus());
    }

    @TestFactory
    public Stream<DynamicTest> testFindKnifesInBaggage(){
        //7.Es wird der verbotene Gegenstand Messer in einem Handgepäckstück erkannt.
        List<DynamicTest> tests = new ArrayList<>();
        ArrayList<Passenger> passengers = TestHelpers.generatePassengersWithItem("K");

        app.prepareSecurityControl();

        int i = 0;
        for(Passenger pass : passengers){
            DynamicTest test = DynamicTest.dynamicTest("Testing Bagge num: " + i, () ->{
                int startingRecords = app.baggageScanner.getRecords().size();
                app.processPassenger(pass);

                ArrayList<Record> records = TestHelpers.getNewRecords(app, startingRecords);
                boolean generatedKnifeRecord = false;
                for(Record record : records){
                    if(record.getResult().substring(16).startsWith("kn!fe")){
                        generatedKnifeRecord = true;
                        break;
                    }
                }
                Assertions.assertTrue(generatedKnifeRecord);
            });
            tests.add(test);
            i++;
        }

        return tests.stream();
    }

    @TestFactory
    public Stream<DynamicTest> testFindWeaponInBaggage(){
        //8.Es wird der verbotene Gegenstand Waffe in einem Handgepäckstück erkannt.
        List<DynamicTest> tests = new ArrayList<>();

        ArrayList<Passenger> passengers = TestHelpers.generatePassengersWithItem("W");

        app.prepareSecurityControl();

        int i = 0;
        for(Passenger pass : passengers){
            DynamicTest test = DynamicTest.dynamicTest("Testing Bagge num: " + i, () ->{
                int startingRecords = app.baggageScanner.getRecords().size();
                app.processPassenger(pass);

                ArrayList<Record> records = TestHelpers.getNewRecords(app, startingRecords);
                boolean generatedWeaponRecord = false;
                for(Record record : records){
                    if(record.getResult().substring(16).startsWith("glock|7")){
                        generatedWeaponRecord = true;
                        break;
                    }
                }
                Assertions.assertTrue(generatedWeaponRecord);
            });
            tests.add(test);
            i++;
        }

        return tests.stream();
    }

    @TestFactory
    public Stream<DynamicTest> testFindExplosivesInBaggage(){
        //9.Es wird der verbotene Gegenstand Explosivstoff in einem Handgepäck erkannt.
        List<DynamicTest> tests = new ArrayList<>();

        ArrayList<Passenger> passengers = TestHelpers.generatePassengersWithItem("E");

        app.prepareSecurityControl();

        int i = 0;
        for(Passenger pass : passengers){
            DynamicTest test = DynamicTest.dynamicTest("Testing Explosives-Baggage num: " + i, () ->{
                int startingRecords = app.baggageScanner.getRecords().size();
                app.processPassenger(pass);

                ArrayList<Record> records = TestHelpers.getNewRecords(app, startingRecords);
                boolean generatedExplosiveRecord = false;
                for(Record record : records){
                    if(record.getResult().substring(16).startsWith("exl|os!ve")){
                        generatedExplosiveRecord = true;
                        break;
                    }
                }
                Assertions.assertTrue(generatedExplosiveRecord);
            });
            tests.add(test);
            i++;
        }
        return tests.stream();
    }

    @TestFactory
    public Stream<DynamicTest> testLoggingOfScans(){
        //10.Jeder Scanvorgang wird ordnungsgemäß mit einem Datensatz protokolliert.
        List<DynamicTest> tests = new ArrayList<>();

        ArrayList<Passenger> passengers = app.passengers;

        app.prepareSecurityControl();

        int i = 0;
        for(Passenger pass : passengers){
            DynamicTest test = DynamicTest.dynamicTest("Testing logging for passenger: " + i, () ->{
                int startingRecords = app.baggageScanner.getRecords().size();
                int handBaggageSize = pass.getHandBaggage().size();
                app.processPassenger(pass);
                int endRecords = app.baggageScanner.getRecords().size();

                //Equal, if clean or explosive. More else.
                Assertions.assertTrue(startingRecords + handBaggageSize <= endRecords);
            });
            tests.add(test);
            i++;
        }

        return tests.stream();
    }

    @TestFactory
    public Stream<DynamicTest> testBaggageNothingFound(){
        //11.Ordnungsgemäßer Ablauf, wenn keine verbotenen Gegenstände gefunden wurden.
        List<DynamicTest> tests = new ArrayList<>();

        ArrayList<Passenger> passengers = TestHelpers.generatePassengersWithItem("");

        app.prepareSecurityControl();

        int i = 0;
        for(Passenger pass : passengers){
            DynamicTest test = DynamicTest.dynamicTest("Testing process clean baggage, number: " + i, ()->{
                Track track2 = null;
                for(Track track : app.baggageScanner.getTracks()){
                    if(track.getTrackNumber() == 2){
                        track2 = track;
                        break;
                    }
                }
                if(track2 == null){
                    Assertions.fail("There is no Track 2.");
                }
                int startTrack2Num = track2.getTrays().size();
                int startRecordNum = app.baggageScanner.getRecords().size();

                app.processPassenger(pass);

                int endTrack2Num = track2.getTrays().size();
                int endRecordNum = app.baggageScanner.getRecords().size();

                Assertions.assertEquals(startTrack2Num + pass.getHandBaggage().size(), endTrack2Num);
                Assertions.assertEquals(startRecordNum + pass.getHandBaggage().size(), endRecordNum);
            });
            tests.add(test);
            i++;
        }

        return tests.stream();
    }

    @TestFactory
    public Stream<DynamicTest> testBaggageKnifeFound(){
        //12.Ordnungsgemäßer Ablauf, wenn der verbotene Gegenstand Messer gefunden wurde.
        List<DynamicTest> tests = new ArrayList<>();

        ArrayList<Passenger> passengers = TestHelpers.generatePassengersWithItem("K");

        app.prepareSecurityControl();

        int i = 0;
        for(Passenger pass : passengers){
            DynamicTest test = DynamicTest.dynamicTest("Testing process knife baggage, number: " + i, () -> {
                Track track2 = null;
                for(Track track : app.baggageScanner.getTracks()){
                    if(track.getTrackNumber() == 2){
                        track2 = track;
                        break;
                    }
                }
                if(track2 == null) Assertions.fail("There is no Track 2.");
                int startTrack2Num = track2.getTrays().size();
                int startRecordNum = app.baggageScanner.getRecords().size();

                app.processPassenger(pass);

                int endTrack2Num = track2.getTrays().size();
                int endRecordNum = app.baggageScanner.getRecords().size();

                Assertions.assertEquals(startTrack2Num + pass.getHandBaggage().size(), endTrack2Num);
                Assertions.assertEquals(startRecordNum + pass.getHandBaggage().size() + 1, endRecordNum);
                Assertions.assertEquals(Status.ACTIVATED, app.baggageScanner.getStatus());

                //Test if the knife has been removed.
                boolean knifeInBaggage = false;
                for(HandBaggage baggage : pass.getHandBaggage()){
                    for(Layer layer : baggage.getLayers()){
                        if(Arrays.toString(layer.getCharacter()).contains("kn!fe")){
                            knifeInBaggage = true;
                            break;
                        }
                    }
                }
                Assertions.assertFalse(knifeInBaggage);
            });
            tests.add(test);
            i++;
        }
        return tests.stream();
    }

    @TestFactory
    public Stream<DynamicTest> testBaggageWeaponFound(){
        //TODO 13.Ordnungsgemäßer Ablauf, wenn der verbotene Gegenstand Waffe gefunden wurde.
        List<DynamicTest> tests = new ArrayList<>();

        ArrayList<Passenger> passengers = TestHelpers.generatePassengersWithItem("W");

        app.prepareSecurityControl();

        int i = 0;
        for(Passenger pass : passengers){
            DynamicTest test = DynamicTest.dynamicTest("Testing process weapon baggage, number: " + i, () -> {
                int startRecordNum = app.baggageScanner.getRecords().size();
                ArrayList<HandBaggage> baggages = pass.getHandBaggage();

                app.processPassenger(pass);

                int endRecordNum = app.baggageScanner.getRecords().size();
                FederalPoliceOfficer officer = null;
                for(FederalPoliceOfficer o : app.federalPoliceOffice.getRegisteredOfficers()){
                    if(o.getName().equals("Harry")){
                        officer = o;
                    }
                }
                if(officer == null) Assertions.fail("Harry ist nicht an seinem Platz.");

                Assertions.assertNotNull(app.baggageScanner.getFederalPoliceOfficer());
                Assertions.assertEquals(0, app.federalPoliceOfficers.size());
                Assertions.assertEquals(3, app.federalPoliceOffice.getRegisteredOfficers().size());
                Assertions.assertEquals("glock|7", officer.getWeapon());
                Assertions.assertEquals(baggages, officer.getConfiscatedBaggage());
                Assertions.assertEquals(Status.ACTIVATED, app.baggageScanner.getStatus());

                //Test if the weapon has been removed.
                boolean weaponInBaggage = false;
                for(HandBaggage baggage : officer.getConfiscatedBaggage()){
                    for(Layer layer : baggage.getLayers()){
                        if(Arrays.toString(layer.getCharacter()).contains("glock|7")){
                            weaponInBaggage = true;
                            break;
                        }
                    }
                }
                Assertions.assertFalse(weaponInBaggage);
            });
            tests.add(test);
            i++;
        }
        return tests.stream();
    }

    @TestFactory
    public Stream<DynamicTest> testBaggageExplosivesFound(){
        //TODO 14.Ordnungsgemäßer Ablauf, wenn der verbotene Gegenstand Sprengstoff gefunden wurde.
        List<DynamicTest> tests = new ArrayList<>();

        ArrayList<Passenger> passengers = TestHelpers.generatePassengersWithItem("E");

        app.prepareSecurityControl();

        int i = 0;
        for(Passenger pass : passengers){
            DynamicTest test = DynamicTest.dynamicTest("Testing process explosives baggage, number: " + i, () -> {
                int startRecordNum = app.baggageScanner.getRecords().size();
                int numHandBaggage = pass.getHandBaggage().size();
                int startTestStripsNum = app.baggageScanner.getManualPostControl().getExplosiveTraceDetector().getTestStrips().size();//TODO

                app.processPassenger(pass);

                int endRecordNum = app.baggageScanner.getRecords().size();
                int endTestStripsNum = app.baggageScanner.getManualPostControl().getExplosiveTraceDetector().getTestStrips().size();

                Assertions.assertEquals(startRecordNum + numHandBaggage, endRecordNum);
                Assertions.assertEquals(0, pass.getHandBaggage().size());
                Assertions.assertEquals(startTestStripsNum+1, endTestStripsNum);
                Assertions.assertNotNull(app.baggageScanner.getFederalPoliceOfficer());
                //Laut spezifikation gehen die Officers nie zurück.
                //Assertions.assertEquals(0, app.federalPoliceOfficers.size());
                Assertions.assertEquals(3, app.federalPoliceOffice.getRegisteredOfficers().size());
                Assertions.assertEquals(Status.ACTIVATED, app.baggageScanner.getStatus());
            });
            tests.add(test);
            i++;
        }
        return tests.stream();
    }
}