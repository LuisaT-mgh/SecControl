import BaggageScanner.OperatingStation;
import Employee.*;
import General.Application;
import org.junit.jupiter.api.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
        //TODO 1.Die Simulation mit (i) 568 Passagieren und 609 Gepäckstücken wird korrekt initialisiert.
    }

    @Test
    @DisplayName("2. Check workplaces")
    public void testAssignmentOfEmployees(){
        //2.Die Positionen an dem Gepäckscanner werden korrekt mit Mitarbeitern besetzt.
        //TODO Maybe check the new specs again.

        //Create Dates
        Date conveyorDate = null, operatorDate = null, postControlDate = null, supervisorDate = null, policeDate = null;
        try{
            conveyorDate = new SimpleDateFormat("dd/MM/yyyy").parse("31/05/1930");
            operatorDate = new SimpleDateFormat("dd/MM/yyyy").parse("09/06/1981");
            postControlDate = new SimpleDateFormat("dd/MM/yyyy").parse("19/03/1955");
            supervisorDate = new SimpleDateFormat("dd/MM/yyyy").parse("19/11/1962");
            policeDate = new SimpleDateFormat("dd/MM/yyyy").parse("31/07/1962");
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("Error while creating the BirthDates to check against.");
        }

        //Inspektor Rollenbahn
        Employee current = app.baggageScanner.getRollerConveryor().getInspector();
        Assertions.assertNotNull(current);
        Assertions.assertEquals("Clint Eastwood", current.getName());
        Assertions.assertEquals(conveyorDate, current.getBirthDate());
        Assertions.assertEquals(Inspector.class, current.getClass());

        //Inspektorin Bedienplatz
        current = app.baggageScanner.getOperatingStation().getInspector();
        Assertions.assertNotNull(current);
        Assertions.assertEquals("Natalie Portman", current.getName());
        Assertions.assertEquals(operatorDate, current.getBirthDate());
        Assertions.assertEquals(Inspector.class, current.getClass());

        //Inspektor Nachkontrolle
        current = app.baggageScanner.getManualPostControl().getInspector();
        Assertions.assertNotNull(current);
        Assertions.assertEquals("Bruce Willis", current.getName());
        Assertions.assertEquals(postControlDate, current.getBirthDate());
        Assertions.assertEquals(Inspector.class, current.getClass());

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

    }

    @Test
    @DisplayName("3. Test locking IDCard after 3 wrong inputs")
    public void testLockingIDCard(){
        //TODO Test this
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
        //TODO 4.Ein Mitarbeiter mit dem Profil K oder O kann sich an einem Gepäckscanner nicht anmelden.
    }

    @Test
    @DisplayName("5. Test permissions for functions")
    public void testFunctionPermissions(){
        //TODO 5.Ein Mitarbeiter kann nur die - gemäß Profil - zugeordneten Funktionalitäten ausführen.
    }

    @Test
    @DisplayName("6. Only Supervisor can unlock")
    public void testSupervisorUnlock(){
        //TODO 6.Nur ein Supervisor kann einen Gepäckscanner im Status locked entsperren.
    }

    @TestFactory
    public Stream<DynamicTest> testFindKnifesInBaggage(){
        //TODO 7.Es wird der verbotene Gegenstand Messer in einem Handgepäckstück erkannt.
        List<DynamicTest> tests = new ArrayList<>();
        return tests.stream();
    }

    @TestFactory
    public Stream<DynamicTest> testFindWeaponInBaggage(){
        //TODO 8.Es wird der verbotene Gegenstand Waffe in einem Handgepäckstück erkannt.
        List<DynamicTest> tests = new ArrayList<>();
        return tests.stream();
    }

    @TestFactory
    public Stream<DynamicTest> testFindExplosivesInBaggage(){
        //TODO 9.Es wird der verbotene Gegenstand Explosivstoff in einem Handgepäck erkannt.
        List<DynamicTest> tests = new ArrayList<>();
        return tests.stream();
    }

    @TestFactory
    public Stream<DynamicTest> testLoggingOfScans(){
        //TODO 10.Jeder Scanvorgang wird ordnungsgemäß mit einem Datensatz protokolliert.
        List<DynamicTest> tests = new ArrayList<>();
        return tests.stream();
    }

    @TestFactory
    public Stream<DynamicTest> testBaggageNothingFound(){
        //TODO 11.Ordnungsgemäßer Ablauf, wenn keine verbotenen Gegenstände gefunden wurden.
        List<DynamicTest> tests = new ArrayList<>();
        return tests.stream();
    }

    @TestFactory
    public Stream<DynamicTest> testBaggageKnifeFound(){
        //TODO 12.Ordnungsgemäßer Ablauf, wenn der verbotene Gegenstand Messer gefunden wurde.
        List<DynamicTest> tests = new ArrayList<>();
        return tests.stream();
    }

    @TestFactory
    public Stream<DynamicTest> testBaggageWeaponFound(){
        //TODO 13.Ordnungsgemäßer Ablauf, wenn der verbotene Gegenstand Waffe gefunden wurde.
        List<DynamicTest> tests = new ArrayList<>();
        return tests.stream();
    }

    @TestFactory
    public Stream<DynamicTest> testBaggageExplosivesFound(){
        //TODO 14.Ordnungsgemäßer Ablauf, wenn der verbotene Gegenstand Sprengstoff gefunden wurde.
        List<DynamicTest> tests = new ArrayList<>();
        return tests.stream();
    }
}