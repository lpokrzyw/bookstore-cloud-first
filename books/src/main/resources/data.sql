ALTER TABLE BOOKS
ALTER COLUMN DESCRIPTION SET DATA TYPE VARCHAR(1024);

INSERT INTO BOOKS (ID, TITLE, AUTHOR, DESCRIPTION, PRICE)
VALUES (
    1,
    'Pamięć nieulotna',
    'Edward Snowden',
    'Pamięć nieulotna to autobiografia Edwarda Snowdena, który ujawnił tajne informacje o globalnym systemie inwigilacji elektronicznej. Książka opisuje jego życie, motywy, refleksje na temat prywatności oraz wolności w erze cyfrowej',
    49.99);

INSERT INTO BOOKS (ID, TITLE, AUTHOR, DESCRIPTION, PRICE)
VALUES (
    2,
    'Wojny w cyberprzestrzeni',
    'Chase Cunningham',
    'Książka, Wojny w cyberprzestrzeni autorstwa Chase Cunninghama analizuje cyfrowe pole walki, strategie obrony przed cyberatakami oraz ewolucję cyberprzestrzeni jako pola walki. Omawia motywy napastników, skutki ich działań i wskazówki ochrony systemów.',
    63.00);

INSERT INTO BOOKS (ID, TITLE, AUTHOR, DESCRIPTION, PRICE)
VALUES (
    3,
    'Indistractable',
    'Nir Eyal',
    'Poradnik o odzyskiwaniu kontroli nad uwagą i życiem, analizujący przyczyny rozproszenia oraz oferujący praktyczne strategie. Autor przedstawia cztery techniki, które pomagają stać się nierozpraszalnym w dzisiejszym świecie pełnym bodźców.',
    61.99);

INSERT INTO BOOKS (ID, TITLE, AUTHOR, DESCRIPTION, PRICE)
VALUES (
    4,
    'Metoda Lean Startup',
    'Eric Ries',
    'Metoda Lean Startup Erica Riesa rewolucjonizuje tworzenie startupów, kładąc nacisk na szybkie testowanie hipotez i dostosowywanie się do rynku. Cykl buduj-mierz-ucz się minimalizuje ryzyko i zwiększa szanse na sukces, pozwalając na efektywne wykorzystanie zasobów.',
    59.99);

INSERT INTO BOOKS (ID, TITLE, AUTHOR, DESCRIPTION, PRICE)
VALUES (
    5,
    'Cyberbroń - broń doskonała',
    'David E. Sanger',
    'Cyberbroń - broń doskonała Davida E. Sangera to analiza rosnącego znaczenia cyberprzestrzeni jako pola walki, gdzie cyfrowe narzędzia stają się potężną bronią. Autor opisuje, jak cyberataki wpływają na geopolitykę, gospodarkę i życie codzienne.',
    42.99);

INSERT INTO BOOKS (ID, TITLE, AUTHOR, DESCRIPTION, PRICE)
VALUES (
    6,
    'Innovators ',
    'Walter Isaacson',
    '"Innowatorzy Waltera Isaacsona to opowieść o ludziach, którzy stworzyli komputery i internet, ukazując, jak współpraca i kreatywność prowadzą do rewolucyjnych zmian. Autor przedstawia sylwetki pionierów, od Ady Lovelace po Steve’a Jobsa, analizując ich wpływ na świat.',
    79.00);

