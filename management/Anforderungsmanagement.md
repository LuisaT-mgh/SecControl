#Anforderungsmanagement

###Sophisten-Sätze:

* Die Sicherheitskontrolle muss fähig sein von einem externen Wartungstechnicker gewartet zu werden.

* Die Sicherheitskontrolle muss die Gepäckstücke der Passagiere nach verbotenen Gegenständen scannen.
* Zum Scannen muss die Sicherheitskontrolle die Gepäckstücke automatisch bewegen.
* Die Sicherheitskontrolle muss den Gepäckscanner an- und ausschalten.
* Die Sicherheitskontrolle muss die Ausweistypen Staff und External unterscheiden.
* Falls ein Mitarbeiter den Profiltyp "K" oder "O" hat muss die Sicherheitskontrolle deren Nutzung des Gepäckscanners verweigern. 
* Falls ein Mitarbeiter den Profiltyp "I" hat muss die Sicherheitskontrolle deren Nutzung der Funktionalitäten "Band vorwärts bewegen", "Band rückwärts bewegen", "scannen" und "alarm" zulassen.
* Falls ein Mitarbeiter den Profiltyp "S" hat muss die Sicherheitskontrolle deren Nutzung der Funktionalität "report" zulassen.
* Falls ein Mitarbeiter den Profiltyp "T" hat muss die Sicherheitskontrolle deren Nutzung des Funktionalität "wartung" zulassen.
* Die Sicherheitskontrolle muss die Rollenbahn mit einem Inspektor besetzen.
* Die Sicherheitskontrolle muss den Bedienplatz mit einem Inspektor besetzen.
* Die Sicherheitskontrolle muss die Nachkontrolle mit einem Inspektor besetzen.
* Die Sicherheitskontrolle muss den Arbeitsplatz "Supervision" mit einem Supervisor und einem Bundespolizisten besetzen.
* Falls ein Mitarbeiter den Bedienplatz nutzen möchte muss die Sicherheitskontrolle eine Aktivierung des Gepäckscanners mittels IDCard und korrekter PIN zulassen.
* Falls eine PIN für eine IDCard drei mal falsch eingegeben wurde muss die Sicherheitskontrolle diese IDCard sperren. 
* Falls der Gepäckscanner im Status "locked" ist muss die Sicherheitskontrolle diesen durch einen Supervisor, Ausweis und PIN entsperren.
* Die Sicherheitskontrolle muss den Passagieren die Möglichkeit bieten ihre Gepäckstücke in einer Schale auf das Rollband zu legen.
* Während der Gepäckscanner scannt muss die Sicherheitskontrolle den Gepäckscanner in den Status "inUse" versetzen.
* Wenn der Gepäckscanner fertig gescannt hat muss die Sicherheitskontrolle den Gepäckscanner in den Status "activated" versetzen.
* Die Sicherheitskopntrolle muss die Gepäckstücke mittels der Algorithmen "BoyerMoore" oder "KnuthMorrisPratt" scannen.
* Sobald ein Scannvorgang abgeschlossen wurde muss die Sicherheitskontrolle einen zugehörigen Datensatz erzeugen.
* Falls in einem Gepäckstück kein verbotener Gegenstand gefunden wurde muss die Sicherheitskontrolle dem Passagier die Möglichkeit bieten das Gepäckstück zu entnehmen.
* Falls ein verbotener Gegenstand gefuden wurde muss die Sicherheitskontrolle eine manuelle Nachkontrolle durchführen.
---
######Sätze bezüglich verbotenen Gegenständen
* Falls in einem Gepäckstück ein Messer gefunden wurde muss die Sicherheitskontrolle gewährleisten dass der Inspektor in Gegenwart des Passagiers dieses entnimmt und entsorgt.

* Falls von einem Gepackstück ein Messer entfernt wurde muss die Sicherheitskontrolle das Gepäckstück an den Eingang des Scanners befördern und erneut scannen.
* Falls in einem Gepäckstück eine Waffe oder Sprengstoff gefunden wurde muss die Sicherheitskontrolle den Alarm auslösen.
* Falls der Alarm ausgelöst worden ist muss die Sicherheitskontrolle den Gepäckscanner in den Status "locked" versetzen.
* Falls der Alarm ausgelöst worden ist muss die Sicherheitskontrolle den Passagier durch den Bundespolizist festnehmen.
* Falls der Alarm ausgelöst worden ist muss die Sicherheitskontrolle fähig sein zwei Bundespolizisten von der Bundespolizeiinspektion anzufordern.
* Falls in einem Gepäckstück Sprengstoff gefunden wurde, muss die Sicherheitskontrolle fähig sein einen Roboter von der Bundespolizeiinspektion anzufordern.
* Falls in einem Gepäckstück eine Waffe gefunden wurde, muss die Sicherheitskontrolle gewährleisten dass der Bundespolizist in Gegenwart des Passagiers diese entnimmt und einem anderen Bundespolizisten übergibt.
* Falls in dem Gepäckstück eines Passagiers eine Waffe gefunden wurde und dieser weitere Gepäckstücke hat muss die Sicherheitskontrolle die restlichen Gepäckstücke des Passagiers scannen.
* Falls eine Waffe entfernt wurde muss die Sicherheitskontrolle fähig sein den Passagier und dessen Gepäckstücke an die zusätzlichen Bundespolizisten zu übergeben.
* Falls in einem Gepäckstück Sprengstoff gefunden wurde muss die Sicherheitskontrolle gewährleisten dass der Inspektor an der Nachkontrolle einen Teststreifen über das Gepäckstück streicht.
* Falls ein Teststreifen über ein Gepäckstück gestreicht wurde, muss die Sicherheitskontrolle den Teststreifen in das Gerät für Spurensuche nach Sprengstoff einführen.
* Sobald das Gerät für Spurensuche nach Sprengstoff den Fund von Sprengstoff bestätigt hat, muss die Sicherheitskontrolle die Zerstörung durch einen Roboter, Hochdruckwasserstrahl und einen Bundespolizisten einleiten.
* Sobald die Gefahr durch verbotene Gegenstände ausgeschlossen wurde, muss die Sicherheitskontrolle den Normalbetrieb wieder aufnehmen.