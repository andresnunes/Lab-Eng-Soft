INSERT INTO CLUBE(nome, cnpj, email, endereco) VALUES('Clube SP', '48.664.752/0001-83', 'clubesp@gmail.com','rua marquinho 123');
INSERT INTO ORGANIZADOR(cpf, email, nome, senha, clube_id) VALUES('694.915.690-15', 'organizadorSP@email', 'organizador SP','senha',1);
INSERT INTO ATLETA(nome, idade, clube_id) VALUES('Marquinhos',23, 1);
INSERT INTO ATLETA(nome, idade, clube_id) VALUES('Uguinho', 25, 1);
INSERT INTO ATLETA(nome, idade, clube_id) VALUES('Zézinho', 34, 1);
INSERT INTO ATLETA(nome, idade, clube_id) VALUES('Luizinho', 29, 1);



INSERT INTO CLUBE(nome, cnpj, email, endereco) VALUES('Clube RJ', '03.564.129/0001-10', 'cluberj@gmail.com','rua mandioca 123');
INSERT INTO ORGANIZADOR(cpf, email, nome, senha, clube_id) VALUES('099.160.550-09', 'organizadorRJ@email', 'organizador RJ','senha',2);
INSERT INTO ATLETA(nome, idade, clube_id) VALUES('Stella',23, 2);
INSERT INTO ATLETA(nome, idade, clube_id) VALUES('Andre', 25, 2);
INSERT INTO ATLETA(nome, idade, clube_id) VALUES('Gabiru', 34, 2);
INSERT INTO ATLETA(nome, idade, clube_id) VALUES('Murillo', 29, 2);


INSERT INTO TORNEIO(data_inicio, clube_id) VALUES('17/02/2020', 1);
INSERT INTO TORNEIO(data_inicio, clube_id) VALUES('30/12/2020', 1);



INSERT INTO TORNEIO_ATLETA(torneio_id, atleta_id) VALUES(1, 1);
INSERT INTO TORNEIO_ATLETA(torneio_id, atleta_id) VALUES(1, 2);



