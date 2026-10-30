create table Professors(
    id int AUTO_INCREMENT PRIMARY KEY,
    nom varchar(20),
    cognoms varchar(20)
)

insert into Professors
values
    ("Abril","Comelles"),
    ("Arnau","Durant"),
    ("Pol","Germa");

create table ModulsProfessionals(
                                    id int AUTO_INCREMENT PRIMARY KEY,
                                    nom varchar(20),
                                    id_profe int,
                                    CONSTRAINT FK_Modul_Profe FOREIGN KEY  (id_profe) references Professors(id)
);