create table professors
(
    dni Nvarchar(9) PRIMARY KEY,
    nom Nvarchar(20)

);

create table moduls
(
    codiModul  NVARCHAR(3) PRIMARY KEY,
    nommodul   Nvarchar(20),
    profemodul NVARCHAR(9),
    CONSTRAINT moduls_profe FOREIGN KEY (profemodul) REFERENCES professors (dni)

);