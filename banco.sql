CREATE TABLE usuarios (

    id SERIAL PRIMARY KEY,

    nome VARCHAR(100),

    email VARCHAR(100) UNIQUE,

    senha VARCHAR(100)

);

CREATE TABLE videos (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    descricao TEXT NOT NULL,
    categoria VARCHAR(100) NOT NULL,
    classificacao_indicativa VARCHAR(10) NOT NULL
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Vingadores: Ultimato',
'Os heróis restantes enfrentam Thanos para restaurar o universo e trazer seus amigos e familiares de volta.',
'Ação',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Homem-Aranha: Sem Volta Para Casa',
'Peter Parker enfrenta as consequências após sua identidade ser revelada para todo o mundo.',
'Ação',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Pantera Negra',
'TChalla luta para provar que é digno de assumir o trono de Wakanda.',
'Ação',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Doutor Estranho',
'Após um grave acidente, o neurocirurgião Dr. Stephen Strange aprende as artes místicas.',
'Fantasia',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Guardiões da Galáxia',
'Um grupo de criminosos espaciais precisa salvar a galáxia.',
'Ficção Científica',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Doutor Estranho no Multiverso da Loucura',
'Doutor Estranho enfrenta ameaças envolvendo outros universos.',
'Fantasia',
'14'
);


CREATE TABLE curtidas (

    usuario_id INTEGER REFERENCES usuarios(id) ON DELETE CASCADE,
    video_id INTEGER REFERENCES videos(id) ON DELETE CASCADE,

    PRIMARY KEY (usuario_id, video_id)

);

CREATE TABLE favoritos (
    id SERIAL PRIMARY KEY,
    usuario_id INT NOT NULL UNIQUE,

    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
    ON DELETE CASCADE
);

CREATE TABLE favoritos_video (
    id SERIAL PRIMARY KEY,
    favorito_id INT NOT NULL,
    video_id INT NOT NULL,

    FOREIGN KEY (favorito_id) REFERENCES favoritos(id)
    ON DELETE CASCADE,

    FOREIGN KEY (video_id) REFERENCES videos(id)
    ON DELETE CASCADE
);