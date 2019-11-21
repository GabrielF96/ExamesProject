use examesdb;

create table if not exists Paciente(
id_Paciente bigint not null primary key auto_increment,
nm_Paciente varchar(100) not null,
rg char(9) not null,
dt_Nascimento date not null,
sexo char(1) not null
);

create table if not exists Medico(
id_Medico bigint not null primary key auto_increment,
nm_Medico varchar(100) not null,
rg char(9) not null
);

create table if not exists Exame(
id_Exame bigint not null primary key auto_increment,
id_Medico bigint not null,
id_Paciente bigint not null,
dt_Exame date not null,
tp_Sanguineo char(3),
reumatismo bool,
doenca_cardiaca bool,
pressao_alta bool,
diabetes bool,
doenca_mental bool,
epilepsia bool,
hernia bool,
cancer varchar(100),
alergias varchar(100),
outras_doencas varchar(100),
medicamentos varchar(100),
doencas_familiares varchar(100)
);

alter table exame 
add constraint fk_medico 
foreign key (id_Medico) references Medico(id_Medico);

alter table exame
add constraint fk_paciente
foreign key (id_Paciente) references Paciente(id_Paciente);

drop table exame;
drop table medico;
drop table paciente;

/* INSERTS */

insert into Medico values(null, "Carlos da Silva", "552550551");
insert into Medico values(null, "Mário Vasconcellos", "540225224");
insert into Medico values(null, "Marta Gonzalez", "919012215");

insert into Paciente values(null, "Carla Sanchez", "410892452", "1990/02/10", 'F');
insert into Paciente values(null, "Naiara Martins", "980112341", "1988/10/21", 'F');
insert into Paciente values(null, "Marcos Aurelio Soares", "110929989", "1980/12/30", 'M');
insert into Paciente values(null, "Jorge Luiz Silva", "810789525", "1995/01/05", 'M');
insert into Paciente values(null, "Tiago Alves", "882327718", "1987/08/22", 'M');
insert into Paciente values(null, "Joana Felicio", "908761983", "1978/06/10", 'F');
insert into Paciente values(null, "Silvia Helena Pereira", "278809871", "1991/08/15", 'F');

select p.id_Paciente from paciente p where p.nm_Paciente="Silvia Helena Pereira" and p.rg="278809871";

/* CONSULTAS */

select * from medico;
select * from paciente;
select * from exame;

select e.*, e.dt_Exame, paciente.nm_Paciente, medico.nm_medico from Exame e, (select p.id_paciente, p.nm_paciente from paciente p) as paciente, (select m.id_medico, m.nm_medico from medico m) as medico where e.id_paciente = paciente.id_paciente and e.id_medico = medico.id_medico and e.id_exame=11;

select p.id_paciente, p.nm_paciente from paciente p;

/* DELETES */