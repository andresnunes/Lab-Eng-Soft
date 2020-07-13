INSERT INTO CLUBE(nome, cnpj, email, endereco) VALUES('Clube SP', '48.664.752/0001-83', 'clubesp@gmail.com','rua marquinho 123');
INSERT INTO ORGANIZADOR(cpf, email, nome, senha, clube_id) VALUES('694.915.690-15', 'organizadorSP@email', 'organizador SP','senha',1);
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Marquinhos','2010-02-11', 1,'112.779.960-67');
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Uguinho', '2009-02-18', 1, '665.395.950-34');
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Zézinho', '2008-02-17', 1,'746.727.690-70');
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Luizinho', '2007-02-10', 1,'043.144.280-07');
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Cintia','2011-08-17', 1,'808.626.620-60');
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Marcos', '2009-12-10', 1, '040.653.270-24');
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Xuxa', '2000-02-17', 1,'183.243.960-71');
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Sergio', '2006-02-16', 1,'258.719.990-50');
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Fabio','1999-10-07', 1,'809.621.240-01');
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Rafaela', '1983-02-14', 1, '546.810.600-03');
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Lucas', '1988-06-22', 1,'076.343.460-47');
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Ugo', '2007-04-19', 1,'089.310.310-17');
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Silvio','2010-02-14', 1,'820.779.630-85');
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Daniele', '1999-03-30', 1, '854.252.100-51');
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Rafael', '1983-12-19', 1,'427.844.070-71');
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Raul', '1977-10-12', 1,'738.912.150-53');
INSERT INTO TORNEIO(data_inicio, nome, clube_id) VALUES('2020-12-17', 'Torneio1', 1);
INSERT INTO TORNEIO(data_inicio, nome, clube_id) VALUES('2020-02-29', 'Torneio2', 1); 
INSERT INTO TORNEIO(data_inicio, nome, clube_id) VALUES('2020-05-17', 'Torneio3', 1);
INSERT INTO TORNEIO(data_inicio, nome, clube_id) VALUES('2020-03-17', 'Torneio4', 1);
INSERT INTO TORNEIO_ATLETA(torneio_id, atleta_id) VALUES(1, 1);
INSERT INTO TORNEIO_ATLETA(torneio_id, atleta_id) VALUES(1, 2);
INSERT INTO TORNEIO_ATLETA(torneio_id, atleta_id) VALUES(1, 3);
INSERT INTO TORNEIO_ATLETA(torneio_id, atleta_id) VALUES(1, 4);
INSERT INTO TORNEIO_ATLETA(torneio_id, atleta_id) VALUES(1, 5);
INSERT INTO TORNEIO_ATLETA(torneio_id, atleta_id) VALUES(1, 6);
INSERT INTO TORNEIO_ATLETA(torneio_id, atleta_id) VALUES(1, 7);
INSERT INTO TORNEIO_ATLETA(torneio_id, atleta_id) VALUES(1, 8);
INSERT INTO TORNEIO_ATLETA(torneio_id, atleta_id) VALUES(1, 9);
INSERT INTO TORNEIO_ATLETA(torneio_id, atleta_id) VALUES(1, 10);
INSERT INTO TORNEIO_ATLETA(torneio_id, atleta_id) VALUES(1, 11);
INSERT INTO TORNEIO_ATLETA(torneio_id, atleta_id) VALUES(1, 12);
INSERT INTO TORNEIO_ATLETA(torneio_id, atleta_id) VALUES(1, 13);
INSERT INTO TORNEIO_ATLETA(torneio_id, atleta_id) VALUES(1, 14);
INSERT INTO TORNEIO_ATLETA(torneio_id, atleta_id) VALUES(1, 15);
INSERT INTO TORNEIO_ATLETA(torneio_id, atleta_id) VALUES(1, 16);




INSERT INTO PARTIDAS(ATLETA_A_PONTOS_SET_1, ATLETA_A_PONTOS_SET_2, 
ATLETA_A_PONTOS_SET_3, ATLETA_A_PONTOS_SET_4, 
ATLETA_A_PONTOS_SET_5, ATLETA_A_SETS_VENCIDOS, 
ATLETA_B_PONTOS_SET_1, ATLETA_B_PONTOS_SET_2,
ATLETA_B_PONTOS_SET_3, ATLETA_B_PONTOS_SET_4,
ATLETA_B_PONTOS_SET_5, ATLETA_B_SETS_VENCIDOS,
DATA_PARTIDA, torneio_id) 
VALUES(1, 2, 1, 2, 1, 2,
	   2, 1, 2, 1, 2, 3,
	   '2020-10-25', 1);
												
INSERT INTO PARTIDA(partida_id, atleta_a_id, atleta_b_id) VALUES(1 ,1, 2);




INSERT INTO PARTIDAS(ATLETA_A_PONTOS_SET_1, ATLETA_A_PONTOS_SET_2, 
ATLETA_A_PONTOS_SET_3, ATLETA_A_PONTOS_SET_4, 
ATLETA_A_PONTOS_SET_5, ATLETA_A_SETS_VENCIDOS, 
ATLETA_B_PONTOS_SET_1, ATLETA_B_PONTOS_SET_2,
ATLETA_B_PONTOS_SET_3, ATLETA_B_PONTOS_SET_4,
ATLETA_B_PONTOS_SET_5, ATLETA_B_SETS_VENCIDOS,
DATA_PARTIDA, torneio_id) 
VALUES(2, 2, 2, 2, 2, 5,
	   1, 1, 1, 1, 1, 0,
	   '2020-10-25', 1);
												
INSERT INTO PARTIDA(partida_id, atleta_a_id, atleta_b_id) VALUES(2 ,3, 4);




INSERT INTO CLUBE(nome, cnpj, email, endereco) VALUES('Clube RJ', '03.564.129/0001-10', 'cluberj@gmail.com','rua mandioca 123');
INSERT INTO ORGANIZADOR(cpf, email, nome, senha, clube_id) VALUES('099.160.550-09', 'organizadorRJ@email', 'organizador RJ','senha',2);
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Stella', '1997-04-18', 2,'940.674.750-20');
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Andre', '1997-02-13', 2,'805.506.160-20');
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Gabiru', '1982-02-18', 2,'934.117.270-55');
INSERT INTO ATLETA(nome, data_nascimento, clube_id, cpf) VALUES('Murillo', '1984-02-24', 2,'535.641.730-64');








