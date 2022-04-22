INSERT INTO perfil (nome)
VALUES
	("ADMIN"),
    ("USER");

INSERT INTO usuario (email, nome, senha, perfil_id)
VALUES
	("josimar.n2007@gmail.com", "Admin", "$2a$10$m1ymMFT8mtQiMqxxBzKvw.CBcdiNFnnJGwtEd61sPqyOac.m10JbW",1),
    ("user@gmail.com", "User", "$2a$10$m1ymMFT8mtQiMqxxBzKvw.CBcdiNFnnJGwtEd61sPqyOac.m10JbW",2);

INSERT INTO categoria (descricao, tecnologia)
VALUES
	("Back-end", "Java"),
    ("Front-end", "Angular");

INSERT INTO starter (nome, cpf, email, imagem, quatro_letras, categoria_id)
VALUES
	("Joaozinho", "99999999999", "teste@teste.com", "", "abcd", 1),
    ("Zezinho", "88888888888", "email@teste.com", "", "ijlm", 2);