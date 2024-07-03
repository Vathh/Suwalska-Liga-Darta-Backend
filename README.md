To jest API stworzone do zarządzania rozgrywkami turniejowymi darta. 
Zostało stworzone z myślą o usprawnieniu organizacji lokalnych zawodów rozgrywanych corocznie z podziałem na sezon wiosenny oraz jesienny. 
Każdy sezon składa się z kilkunastu turniejów odbywających się co tydzień. Turniej rozgrywany jest w systemie 'double K.O.', co oznacza, że porażka w jednym meczu nie oznacza przegranej w całym turnieju.
Uczestnicy dostają punkty w zależności od pozycji na jakiej skończyli dany turniej. Prowadzona jest tabela wyników w której pozycja ustalana jest na podstawie sumy punktów zebranych w danym sezonie.
Ponadto zbierane są również statystyki dotyczące 'achievements' czyli 180's (podejść 180 punktowych), 170+ (podejść 170+), quick finish (skończenia lega poniżej 20 rzutów), high finish (skończenia lega wartością powyżej 99).

Aplikacja umożliwia:
- Przechowywanie graczy w bazie danych
- Tworzenie drabinek turniejowych w systemie 'double K.O.' dla 16, 32 lub 48 graczy (lub mniej)
- Przechowywanie statystyk i historii turniejów z podziałem na sezony
- Przechowywanie statystyk dotyczących osiągnięć (180, 170+, QF, HF)
- Pobranie listy i szczegółów rozegranych turniejów z podziałem na sezony
- Pobranie statystyk graczy z podziałem na sezony

Schemat prowadzenia turnieju jest następujący:
- Stworzenie sezonu wraz z turniejami
- Dodanie graczy do bazy danych
- Aktywacja wybranego turnieju, rozlosowanie meczów drabinki turniejowej dla wybranych graczy
- Aktualizacja meczów dla aktywnego turnieju

Zapytania do API przechodzą proces autoryzacji, oto lista dostępnych opcji z podziałem na role:
1. Admin:
  - Dodawanie nowego gracza
  - Dodawanie nowego sezonu/turnieju
  - Aktywacja turnieju
  - Anulowanie aktywnego turnieju
  - Usuwanie sezonu/turnieju
  + Poniższe
2. User:
  - Pobranie aktywnych meczy
  - Dodanie nowego achievement
  - Aktualizacja meczu
  + Poniższe
3. Użytkownik niezalogowany:
  - Logowanie do aplikacji
  - Pobranie listy meczy dla określonego turnieju
  - Pobranie listy graczy
  - Pobranie listy sezonów
  - Pobranie statystyk sezonu
  - Pobranie listy turniejów dla określonego sezonu
  - Pobranie szczegółów aktywnego turnieju
  - Pobranie statystyk wybranego turnieju

Technologies used:
- 

  
