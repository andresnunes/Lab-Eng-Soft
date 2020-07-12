INSERT INTO CLUBE(nome, cnpj, email, endereco) VALUES('Clube SP', '48.664.752/0001-83', 'clubesp@gmail.com','rua marquinho 123');
INSERT INTO ORGANIZADOR(cpf, email, nome, senha, clube_id) VALUES('694.915.690-15', 'organizadorSP@email', 'organizador SP','senha',1);
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Marquinhos','2010-02-17', 1,'112.779.960-67');
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Uguinho', '2009-02-17', 1, '665.395.950-34');
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Zézinho', '2008-02-17', 1,'746.727.690-70');
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Luizinho', '2007-02-17', 1,'043.144.280-07');



INSERT INTO CLUBE(nome, cnpj, email, endereco) VALUES('Clube RJ', '03.564.129/0001-10', 'cluberj@gmail.com','rua mandioca 123');
INSERT INTO ORGANIZADOR(cpf, email, nome, senha, clube_id) VALUES('099.160.550-09', 'organizadorRJ@email', 'organizador RJ','senha',2);
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Stella', '2000-02-17', 2,'940.674.750-20');
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Andre', '1997-02-17', 2,'805.506.160-20');
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Gabiru', '1982-02-17', 2,'934.117.270-55');
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Murillo', '1984-02-17', 2,'535.641.730-64');


INSERT INTO TORNEIO(data_inicio, nome, clube_id) VALUES('2020-12-17', 'Torneio1', 1);
INSERT INTO TORNEIO(data_inicio, nome, clube_id) VALUES('2020-02-29', 'Torneio2', 1); 
INSERT INTO TORNEIO(data_inicio, nome, clube_id) VALUES('2020-05-17', 'Torneio3', 1);
INSERT INTO TORNEIO(data_inicio, nome, clube_id) VALUES('2020-03-17', 'Torneio4', 1);

INSERT INTO TORNEIO_ATLETA(torneio_id, atleta_id) VALUES(1, 1);
INSERT INTO TORNEIO_ATLETA(torneio_id, atleta_id) VALUES(1, 2);



