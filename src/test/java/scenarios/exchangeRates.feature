Feature: Kursy Walut

  Scenario: Pobierz i Wyświetl Kursy Walut
    Given użytkownik pobiera kursy walut ze strony "http://api.nbp.pl/api/exchangerates/tables/A"
    Then użytkownik wyświetla kurs dla waluty o kodzie: "USD"
    And użytkownik wyświetla kurs dla waluty o nazwie: "dolar amerykański"
    And użytkownik wyświetla waluty o kursie powyżej: 5
    And użytkownik wyświetla waluty o kursie poniżej: 3