# Exemplarische Beschreibung der Vorgehensweise mit Scrum

### Product Backlog

Zu Beginn des Projektes werden die Anforderungen in User Stories festgehalten. Diese bilden den Kern des
Product Backlogs. Jede User Story wird vom Product Owner mit einer Business Value und vom Team mit einem
geschätzten Aufwand versehen. Aus diesen beiden Kennzahlen wird der ROI (Return on Investment) berechnet.

Der Backlog wird nach dem ROI sortiert. User Stories die weiter oben stehen werden priorisiert.

| # | User Story | BusinessValue (1-10) | Aufwand in Tagen | ROI |
|-------:|------|:---------------:|:---------:|:-----:|
| 0 | Als Flughafenbetreiber möchte ich, dass Kriminelle der Polizei übergeben und vom Flughafengelände entfernt werden. | 7 | 2 | 3.5 |
| 1 | Als Flughafenbetreiber möchte ich, dass beim durchsuchen von Gepäckstücken der entsprechende Passagier dabei ist, um keine Persönlichkeitsrechte zu verletzen. | 9 | 3 | 3 |
| 2 | Als Flughafenbetreiber möchte ich, dass die Ausweise in External und Staff unterschieden werden, um interne Daten und Systeme zu schützen. | 7 | 3 | 2.3 |
| 3 | Als Flughafenbetreiber möchte ich, dass an der Sicherheitskontrolle Arbeitsplätze für einen Bundespolizisten und einen Supervisor existieren, um einen professionellen Umgang mit Zwischenfällen zu gewährleisten. | 8 | 4 | 2 |
| 4 | Als Flughafenbetreiber möchte ich, dass Mitarbeiter nur Funktionalitäten nutzen dürfen, zu denen sie berechtigt sind, um Sicherheitsrisiken minimal zu halten. | 9 | 6 | 1.5 |
| 5 | Als Flughafenbetreiber möchte ich, dass der Gepäckscanner an- und ausgeschaltet werden kann, um Stromkosten zu sparen. | 10 | 7 | 1.43 |
| 6 | Als Flughafenbetreiber möchte ich, dass die Sicherheitskontrolle von einem externen Wartungstechniker gewartet werden kann, um Kosten zu sparen. | 4 | 5 | 0.8 |
| 7 | Als Passagier möchte ich, dass mein Gepäck unversehrt durch die Sicherheitskontrolle kommt, um Sachschäden zu vermeiden. | 8 | 11 | 0.73 |
| 8 | Als Flughafenbetreiber möchte ich, dass die Gepäckstücke der Passagiere möglichst automatisiert transportiert werden, um Mitarbeiter zu schonen. | 8 | 12 | 0.67 |
| 9 | Als Flughafenbetreiber möchte ich, dass bei dem Fund eines verbotenen Gegenstands entsprechend der Schwere des Vergehens gehandelt wird, um Passagiere und Mitarbeiter zu schützen. | 10 | 15 | 0.67 |
| 10 | Als Polizeibehörde möchte ich, dass Roboter zur Beseitigung von Sprengstoff bereitstehen, um meine Mitarbeiter zu schützen. | 9 | 50 | 0.18 |

### Sprint
In unserer Firma umfasst ein Sprint 2 Wochen, also 10 Werktage. Zu Beginn dessen findet ein Sprint Planning Meeting statt, im dem der Product Owner Tätigkeiten bespricht, deren Ausführung im Rahmen des Sprints wichtig sind. Aus diesen Angaben erstellt das Team den Spring Backlog, der alle abzuarbeitenden Aufgaben enthält.

#### Sprint Backlog
Exemplarisch ist hier der Sprint Backlog des ersten Sprints dargestellt.

Für das Sprint Backlog haben sich qualifiziert:
+ User Story 1
+ User Story 2
+ User Story 3

| # | Task | ROI |
|-------:|------|:-----:|
| 0 | Planen eines Bereiches zum Untersuchen von Gepäckstücken. | 3 |
| 1 | Recherche nach gesetzlichen Vorschriften beim Untersuchen von Gepäckstücken. | 3 |
| 2 | Schulen von Mitarbeitern zu Handlungsvorschriften bei Gepäckuntersuchungen. | 3 |
| 3 | Entwerfen der Ausweistypen "External" und "Staff". | 2.3 |
| 4 | Setzen der Berechtigungen der Ausweistypen "External" und "Staff". | 2.3 |
| 5 | Planen des Arbeitsplatzes Supervision. | 2 |
| 6 | Anfordern eines Bundespolizisten von der Bundespolizeiinspektion. | 2 |
| 7 | Erstellen der Position "Supervisor" mit entsprechenden Berechtigungen im System. | 2 |


Die Aufgaben des Sprint Backlogs werden in ein Kanban Board eingegliedert. Mit diesem werden die Aufgaben in die Kategorien "TODO", "InProgress" und "Done" eingeteilt. Die Mitarbeiter wählen selbstständig ihre Aufgaben aus "TODO" und verschieben sie beim Start der Bearbeitung in "InProgress". Sobald diese fertiggestellt ist, wird sie in "Done" verschoben. Am Ende eines Sprints müssen alle Aufgaben in "Done" sein.

####Kanban Board
Hier exemplarisch das Kanban Board nach 6 Tagen:

| TODO | InProgress | Done |
|----|----------|----|
| Setzen der Berechtigungen der Ausweistypen "External" und "Staff". | Schulen von Mitarbeitern zu Handlungsvorschriften bei Gepäckuntersuchungen. | Planen eines Bereiches zum Untersuchen von Gepäckstücken. |
| Anfordern eines Bundespolizisten von der Bundespolizeiinspektion. | Planen des Arbeitsplatzes Supervision. | Recherche nach gesetzlichen Vorschriften beim Untersuchen von Gepäckstücken. |
| Erstellen der Position "Supervisor" mit entsprechenden Berechtigungen im System. |  | Entwerfen der Ausweistypen "External" und "Staff". |

Während des Sprints werden in sogenannten Daily Standups (kurze Meetings) aufgekommene Probleme, sowie Erfolge besprochen, sodass jedes Teammitglied zu jedem Zeitpunkt über den Stand des Projekts Bescheid weiß. 
Der Scrum Master kümmert sich um eine ideale Arbeitsatmosphäre und stellt sicher, dass die Mitarbeiter effizient arbeiten können. Während der Scrum Master so vor allem die Interessen der Mitarbeiter vertritt, kümmert sich der Product Owner um die Interessen des Auftraggebers. 