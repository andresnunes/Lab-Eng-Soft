INSERT INTO CLUBE(nome, cnpj, email, endereco) VALUES('Clube SP', '12341241234', 'clubesp@gmail.com','rua marquinho 123');
INSERT INTO ORGANIZADOR(cpf, email, nome, senha, clube_id) VALUES('123', 'organizadorSP@email', 'organizador SP','senha',1);
INSERT INTO ATLETA(nome, idade, clube_id) VALUES('Marquinhos',23, 1);
INSERT INTO ATLETA(nome, idade, clube_id) VALUES('Uguinho', 25, 1);
INSERT INTO ATLETA(nome, idade, clube_id) VALUES('Zézinho', 34, 1);
INSERT INTO ATLETA(nome, idade, clube_id) VALUES('Luizinho', 29, 1);



INSERT INTO CLUBE(nome, cnpj, email, endereco) VALUES('Clube RJ', '14215451556', 'cluberj@gmail.com','rua mandioca 123');
INSERT INTO ORGANIZADOR(cpf, email, nome, senha, clube_id) VALUES('456', 'organizadorRJ@email', 'organizador RJ','senha',2);
INSERT INTO ATLETA(nome, idade, clube_id) VALUES('Stella',23, 2);
INSERT INTO ATLETA(nome, idade, clube_id) VALUES('Andre', 25, 2);
INSERT INTO ATLETA(nome, idade, clube_id) VALUES('Gabiru', 34, 2);
INSERT INTO ATLETA(nome, idade, clube_id) VALUES('Murillo', 29, 2);


INSERT INTO TORNEIO(data_inicio, clube_id) VALUES('2020-12-30', 1);
INSERT INTO TORNEIO(data_inicio, clube_id) VALUES('2020-12-29', 1);



INSERT INTO TORNEIO_ATLETA(torneio_id, atleta_id) VALUES(1, 1);



