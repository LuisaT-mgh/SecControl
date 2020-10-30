import General.Application;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TestSecurity {

    Application app;

    @BeforeEach
    public void setUp(){
        //TODO create the classes to test.
        app = new Application();
    }

    @Test
    @DisplayName("1. Test num passenger/baggage")
    public void testInitialize(){
        //TODO 1.Die Simulation mit (i) 568 Passagieren und 609 Gepäckstücken wird korrekt initialisiert.
    }

    @Test
    @DisplayName("2. Check workplaces")
    public void testAssignmentOfEmployees(){
        //TODO 2.Die Positionen an dem Gepäckscanner werden korrekt mit Mitarbeitern besetzt.
    }

    @Test
    @DisplayName("3. Test locking IDCard after 3 wrong inputs")
    public void testLockingIDCard(){
        //TODO 3.Nach dreimaliger Falschangabe der PIN wird der Ausweis für die weitere Nutzung gesperrt.
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