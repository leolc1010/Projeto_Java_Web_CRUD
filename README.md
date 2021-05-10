# Projeto_Java_Web_CRUD
Projeto simples de web Java com um API simples de CRUD

Projeto feito em java utilizando o Eclipse com banco em MySQL

CREATE TABLE Ftt.Aluno (
	id int NOT NULL AUTO_INCREMENT,
    Nome varchar(40) NULL,
	RA varchar(30) NULL,
    Curso varchar(30) NULL,
    PRIMARY KEY(ID)
    )ENGINE=INNODB AUTO_INCREMENT=9 DEFAULT CHARSET=UTF8MB4 COLLATE = UTF8MB4_0900_AI_CI;
   
   select *
    from ftt.Aluno;
