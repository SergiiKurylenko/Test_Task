Feature: Wybranie telefonu z listy ofert na stronie T-Mobile

  Scenario: Wybranie telefonu z listy ofert
    Given Otwórz odpowiednią przeglądarkę "chrome"
    When Przejdź na stronę "https://www.t-mobile.pl/"
    Then Strona główna jest widoczna.
    When Z górnej belki wybierz "Urządzenia"
    Then Widoczna rozwijana lista
    When Kliknij "Bez abonamentu" z kolumny "Smartwatche i opaski"
    Then Widoczna lista smartfonów 18 szt
    When Kliknij w 1 element z listy
    Then Widoczna strona produktu
    When Dodaj produkt do koszyka
    Then Widoczna strona "Twój koszyk". Kwoty Cena na start oraz Rata miesięczna zgadzają się z kwotami z poprzedniej strony.
    When Przejdź na stronę główną T-Mobile
    Then Widoczna strona główna. W prawym górnym rogu widoczna jest ikonka koszyka z liczbą produktów w koszyku "1".
