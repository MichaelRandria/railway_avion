-- CREATE USER tp_avion WITH PASSWORD 'tp_avion';
-- CREATE DATABASE tp_avion;
-- ALTER DATABASE tp_avion OWNER TO tp_avion;

-- \q
-- psql -U tp_avion tp_avion
-- tp_avion

CREATE TABLE Admin(
  id SERIAL PRIMARY KEY ,
  nomAdmin VARCHAR(255) NOT NULL ,
  mdpAdmin VARCHAR(32) NOT NULL ,
  email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE Avion(
    id SERIAL PRIMARY KEY ,
    matricule VARCHAR(12) NOT NULL
);

CREATE TABLE Assurance(
    id SERIAL PRIMARY KEY ,
    idAvion INTEGER NOT NULL,
    dateDebut DATE NOT NULL,
    dateFin DATE NOT NULL
);

CREATE TABLE Kilometrage(
    id SERIAL PRIMARY KEY ,
    idAvion INTEGER NOT NULL,
    dateKilometrage DATE NOT NULL,
    debutKm DOUBLE PRECISION NOT NULL,
    finKm DOUBLE PRECISION NOT NULL
);

CREATE TABLE Entretien(
    id SERIAL PRIMARY KEY ,
    typeEntretien VARCHAR(255)  NOT NULL
);

CREATE TABLE EntretienAvion(
    id SERIAL PRIMARY KEY ,
    idEntretien INTEGER NOT NULL,
    idAvion INTEGER NOT NULL,
    dateEntretien DATE NOT NULL
);

ALTER TABLE Kilometrage
    ADD FOREIGN KEY (idAvion) REFERENCES Avion(id);

ALTER TABLE Assurance
    ADD
        FOREIGN KEY (idAvion) REFERENCES Avion(id);

ALTER TABLE EntretienAvion
    ADD
        FOREIGN KEY (idEntretien) REFERENCES Entretien(id),
    ADD
        FOREIGN KEY (idAvion) REFERENCES Avion(id);

    CREATE TABLE adminToken(
        id SERIAL PRIMARY KEY,
        idAdmin INTEGER not null,
        date timestamp not null,
        tokenValue VARCHAR(255),
        FOREIGN KEY (idAdmin) references admin(id)
    );


INSERT INTO Avion(matricule) VALUES
    ('123T');

INSERT INTO Admin(nomAdmin, mdpAdmin, email) VALUES
    ('admin','admin','admin@mail.com');

INSERT INTO Kilometrage(idAvion,dateKilometrage,debutKm,finKm) VALUES
    (1,'2022-01-01',1500,1510);

INSERT INTO Kilometrage(idAvion,dateKilometrage,debutKm,finKm) VALUES
    (1,'2022-01-02',1510,1520);