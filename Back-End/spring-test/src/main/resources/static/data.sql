INSERT INTO CLUBE(nome, cnpj, email, endereco) VALUES('Clube SP', '12341241234', 'clubesp@gmail.com','rua marquinho 123');
INSERT INTO CLUBE(nome, cnpj, email, endereco) VALUES('Clube RJ', '14215451556', 'cluberj@gmail.com','rua mandioca 123');
INSERT INTO CLUBE(nome, cnpj, email, endereco) VALUES('Clube MG', '14534534562', 'clubemg@gmail.com','rua marques 123');
INSERT INTO CLUBE(nome, cnpj, email, endereco) VALUES('Clube PA', '37367583561', 'clubepa@gmail.com','rua mandarin 123');

INSERT INTO ATLETA(nome, idade, clube_id) VALUES('Marquinhos',23, 1);
INSERT INTO ATLETA(nome, idade, clube_id) VALUES('Uguinho', 25, 1);
INSERT INTO ATLETA(nome, idade, clube_id) VALUES('Zézinho', 34, 2);
INSERT INTO ATLETA(nome, idade, clube_id) VALUES('Luizinho', 29, 3);


select * from ATLETA ;
select * from CLUBE ;
select * from ORGANIZADOR ;
select * from TORNEIO;
select * from TORNEIO_ATLETA ;