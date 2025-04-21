ALTER TABLE BOOKS
ALTER COLUMN DESCRIPTION SET DATA TYPE VARCHAR(1024);

INSERT INTO BOOKS (ID, TITLE, AUTHOR, DESCRIPTION, PRICE)
VALUES (
    1,
    'Permanent Record',
    'Edward Snowden',
    'Permanent Record is Edward Snowden’s autobiography. He revealed classified information about a global electronic surveillance system. The book covers his life, motives, and thoughts on privacy and freedom in the digital age.',
    49.99);

INSERT INTO BOOKS (ID, TITLE, AUTHOR, DESCRIPTION, PRICE)
VALUES (
    2,
    'Cyber Warfare',
    'Chase Cunningham',
    'The book Cyber Warfare by Chase Cunningham analyzes the digital battlefield, defense strategies against cyberattacks, and the evolution of cyberspace as a war domain. It covers attackers’ motives, effects of their actions, and system protection tips.',
    63.00);

INSERT INTO BOOKS (ID, TITLE, AUTHOR, DESCRIPTION, PRICE)
VALUES (
    3,
    'Indistractable',
    'Nir Eyal',
    'A guide to regaining control over attention and life, exploring causes of distraction and offering practical strategies. The author presents four techniques to become indistractable in today’s stimulus-rich world.',
    61.99);

INSERT INTO BOOKS (ID, TITLE, AUTHOR, DESCRIPTION, PRICE)
VALUES (
    4,
    'The Lean Startup',
    'Eric Ries',
    'The Lean Startup book revolutionizes startup creation by focusing on rapid hypothesis testing and market adaptation. The build-measure-learn loop reduces risk and boosts success chances through efficient resource use.',
    59.99);

INSERT INTO BOOKS (ID, TITLE, AUTHOR, DESCRIPTION, PRICE)
VALUES (
    5,
    'The Perfect Weapon',
    'David E. Sanger',
    'The Perfect Weapon by David E. Sanger analyzes the rise of cyberspace as a battlefield, where digital tools become powerful weapons. The author shows how cyberattacks impact geopolitics, the economy, and everyday life.',
    42.99);

INSERT INTO BOOKS (ID, TITLE, AUTHOR, DESCRIPTION, PRICE)
VALUES (
    6,
    'Innovators ',
    'Walter Isaacson',
    'The Innovators tells the story of the people who created computers and the internet, showing how collaboration and creativity drive change. He profiles pioneers from Ada Lovelace to Steve Jobs, exploring their impact.',
    79.00);

INSERT INTO USERS (USERNAME, PASSWORD, ROLE)
VALUES
  ('admin', '$2a$12$HUvUJILdvohqdFbCtjBljeme05kGSQ.3pKeAgMbTdWQcPsBDZ7XmO', 'ROLE_ADMIN'),
  ('user', '$2a$12$kjEJtEHtzDZcE3Bt1oeo2ORRgQZ1wdWxvRXKWZTrdRuj4GFxLUXx.', 'ROLE_USER'),
  ('lukasz', '$2a$12$yPf/9tTMGypyV2uJiPKtv.YRgXDTHYLkePJDOcQ1go3QQtXgKd7AW', 'ROLE_USER');

