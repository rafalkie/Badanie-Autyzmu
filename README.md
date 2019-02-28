## Dokumentacja

***Aplikacja mobilna wspierająca diagnostykę autyzmu***

## Cel projektu

> Stworzenie aplikacji mobilnej wspierający badanie osób potencjalnie
> chorych na autyzm. Poprzez urządzenie mobilne i dobrze sprecyzowane ,
> kluczowe pytania dla tej choroby będziemy mogli dostać wynik badania .

##  Funkcjonalności programu

Program będzie służył do diagnozowania czy dana osoba ma autyzm. Będzie
to możliwe poprzez wybranie pytań w ankiecie ,priorytetowych dla tej
choroby. Aby to zbadać w programie będziemy mogli:

-odpowiadać na pytania związane ze spektrum autyzmu.

-przetworzyć odpowiedzi osoby i podać wynik badania.

\- zapisywać odpowiedzi osób badanych.

-wyświetlać ankiety wypełnione.

-edytować pytania i dodawać nowe pytania do ankiety.

## Technologie:

**1.Podstawowe:**

-   Java(Android)

<!-- -->

-   XML

-   SQL

**2.Programy:**

-   **Android Studio**

-   **Sqlitestudio-2.0.26**

-   Adobe Photoshop CS6

##  Uzasadnienia

**Wybrałem aplikacje mobilną dla tego projektu , ponieważ dzisiaj każdy
posiada telefon w zasięgu ręki i z łatwością będzie można wykonać
diagnostykę za pomocą tego programu.**

**Dzięki bazie danych SqlLite będziemy mogli z łatwością magazynować
dane , poza tym ta baza jest dedykowana na platformę Android.**

## Tutorial dla użytkownika

1.  Menu główne

**Po uruchomieniu aplikacji ukazuje nam się menu główne .Po kliknięciu w
przycisk :**

-   **„START ANKIETA" -- rozpoczynamy wypełnianie ankiety .**

-   **„ANKIETA" - możemy tutaj podejrzeć wszystkie ankiety , które były
    wypełniane**

-   **„PYTANIA"-możemy tutaj podejrzeć wszystkie pytania które są w
    bazie danych i edytować je.**

-   **„DODAJ PYTANIE"- przechodzimy do okienka z możliwością dodania
    nowego pytania do bazy**

-   **„USTAWIENIA"- wchodzimy do edycji ustawień programu**

-   **„WYJSCIE"- wyłączamy program**

![image](https://user-images.githubusercontent.com/26554041/48031327-158f1080-e154-11e8-9263-97798183c47a.png)

**Poniżej zostaną kolejno omówione te wszystkie okienka które się
uruchamiają po kliknięciu w te przyciski powyżej.**

2.  Ankieta- wypełnianie.

**Tutaj następuje wypełnianie ankiety. Możemy odpowiadać na pytania ale
tez nie musimy wystarczy nacisnąć symbol szczałki , ale wtedy nie
dostaniemy dobrego wyniku badania ,gdyż pominiemy pytanie. Możemy także
powracać do poprzedniego pytania i odpowiadać od nowa na już wcześniej
zaznaczone pytania.**

**Po kliknięciu w odpowiedź ostatniego pytania pokazuje nam się wynik
badania. Następnie możemy anulować i edytować odpowiedzi lub zakończyć
ankietę.**


![image](https://user-images.githubusercontent.com/26554041/48031405-6c94e580-e154-11e8-8a88-8993ccdd04b3.png)





3.  Ankieta- podgląd historii.

**W tym oknie możemy wybrać ankietę która była wypełniana na tym
urządzeniu. Następnie jak widać na drugim zdjęciu mamy podgląd na
odpowiedzi jakich udzielał na poszczególne pytania użytkownik. **


![image](https://user-images.githubusercontent.com/26554041/48031384-538c3480-e154-11e8-8f94-bf2a5f02b432.png)

4.  Pytania- podgląd i edycja.

**W tym oknie możemy zobaczyć wszystkie pytania które znajdują się w
bazie danych . Następnie klikając w wybrane przez nas pytanie jak widać
na drugim zdjęciu przechodzimy do okienka edycji tego pytania.**

**Tutaj także możemy edytować typ odpowiedzi jaki będzie się wyświetlał
w ankiecie.**

**Jeśli już jest wszystko gotowe zatwierdzamy a pytanie zaktualizuje się
od razu w bazie danych.**

![image](https://user-images.githubusercontent.com/26554041/48031425-80d8e280-e154-11e8-9ca0-2dabb3dd37b9.png)


5.  Pytania- dodawanie nowego.

> **To okno wygląda tak samo jak powyżej tylko tutaj mamy możliwość
> dodawania nowych pytań do bazy danych.**


![image](https://user-images.githubusercontent.com/26554041/48031439-8a624a80-e154-11e8-9317-25642c540bf7.png)


6.  Ustawienia

> **Tutaj możemy zmienić takie liczby jak :**

-   **Ilość pytań jaka nam się wyświetli podczas ankiety**

-   **Próg punktów za które program będzie uznawał osobę za chorą.**


![image](https://user-images.githubusercontent.com/26554041/48031448-964e0c80-e154-11e8-8682-c2af758ad577.png)



## Encja bazy danych

> Baza danych zawiera 5 tabel:

1)  **Uzytkownik**

> Tabela zawiera informacje o Użytkowniku(ID Użytkownika ,nazwa).

2)  **Odpowiedz**

> Tabela zawiera odpowiedzi (ID odpowiedzi , nazwa , ID symbolu).

3)  **Pytanie**

> Tabela zawiera pytania(ID pytania, nazwa, ID symbolu).

4)  **Symbol**

> Tabela zawiera symbole (ID symbolu, nazwa).

5)  **Ankieta\_pytania**

> Tabela zawiera informacje o wypełnionych ankietach(ID ankiety, ID
> użytkownika,
>
> ID pytania, ID odpowiedzi).
>

![image](https://user-images.githubusercontent.com/26554041/48031462-a1a13800-e154-11e8-9149-90da10d841b2.png)



## Wybrane fragmenty kodu(objaśnienie)

1.  Funkcja która się wykonuje po kliknięciu w przycisk . Aktualizuje
    zmienną „liczba\_pytan" i „Chory\_od" .Przekazuje te liczby także do
    Edit Text.


![image](https://user-images.githubusercontent.com/26554041/48031472-b2ea4480-e154-11e8-8e77-99476532d481.png)




2.  Zmienna typu String przechowująca zapytanie SQL.

![image](https://user-images.githubusercontent.com/26554041/48031482-bbdb1600-e154-11e8-82d0-bcf714f7f1fd.png)






3.  Funkcja „addSymbol" dzięki której możemy dodać do bazy danych
    Symbol.


![image](https://user-images.githubusercontent.com/26554041/48031496-c72e4180-e154-11e8-80fb-c9b85db97075.png)



4.  Implementacja przycisku .Określanie parametrów(marginesów, rozmiaru
    , koloru) .Przypisanie do przycisku funkcji onClick o nazwie „btn4".


![image](https://user-images.githubusercontent.com/26554041/48031514-d3b29a00-e154-11e8-8712-669d3f5078f5.png)



