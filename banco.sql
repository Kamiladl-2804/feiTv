-- Criação do banco de dados

-- Criação da tabela de usuários
CREATE TABLE usuarios (

    id SERIAL PRIMARY KEY, -- Chave primária 

    nome VARCHAR(100), -- Nome do usuário

    email VARCHAR(100) UNIQUE, -- Email do usuário unico

    senha VARCHAR(100) -- Senha do usuário

);
-- Criação da tabela de vídeos
CREATE TABLE videos (
    id SERIAL PRIMARY KEY, -- Chave primária
    titulo VARCHAR(150) NOT NULL, -- Título do vídeo
    descricao TEXT NOT NULL, -- Descrição do vídeo
    categoria VARCHAR(100) NOT NULL, -- Categoria do vídeo
    classificacao_indicativa VARCHAR(10) NOT NULL -- Classificação indicativa(idade)
);

--Colocar os dados da tabela de vídeos
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

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Homem de Ferro',
'Tony Stark constrói uma armadura e se torna o Homem de Ferro.',
'Ação',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'O Incrível Hulk',
'Bruce Banner tenta controlar o monstro dentro de si.',
'Ação',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Homem de Ferro 2',
'Tony Stark enfrenta novos inimigos e problemas pessoais.',
'Ação',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Thor',
'O deus do trovão é banido para a Terra e aprende humildade.',
'Fantasia',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Capitão América: O Primeiro Vingador',
'Steve Rogers se torna o supersoldado Capitão América.',
'Ação',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Os Vingadores',
'Os maiores heróis da Terra se unem para salvar o planeta.',
'Ação',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Homem de Ferro 3',
'Tony Stark enfrenta um poderoso terrorista chamado Mandarim.',
'Ação',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Thor: O Mundo Sombrio',
'Thor enfrenta uma antiga ameaça que coloca os reinos em perigo.',
'Fantasia',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Capitão América: O Soldado Invernal',
'Steve Rogers enfrenta conspirações dentro da SHIELD.',
'Ação',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Vingadores: Era de Ultron',
'Os Vingadores enfrentam a inteligência artificial Ultron.',
'Ação',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Homem-Formiga',
'Scott Lang ganha poderes com uma tecnologia de encolhimento.',
'Ação',
'10'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Capitão América: Guerra Civil',
'Os heróis entram em conflito após decisões políticas.',
'Ação',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Guardiões da Galáxia Vol. 2',
'Os Guardiões descobrem mais sobre o passado de Peter Quill.',
'Ficção Científica',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Homem-Aranha: De Volta ao Lar',
'Peter Parker tenta equilibrar escola e vida de herói.',
'Ação',
'10'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Thor: Ragnarok',
'Thor precisa impedir a destruição de Asgard.',
'Fantasia',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Vingadores: Guerra Infinita',
'Os heróis enfrentam Thanos antes que ele reúna as joias.',
'Ação',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Homem-Formiga e a Vespa',
'Scott Lang se une à Vespa em uma nova missão.',
'Ação',
'10'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Capitã Marvel',
'Carol Danvers descobre seus poderes cósmicos.',
'Ação',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Homem-Aranha: Longe de Casa',
'Peter Parker enfrenta ameaças durante uma viagem escolar.',
'Ação',
'10'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Viúva Negra',
'Natasha Romanoff confronta seu passado como espiã.',
'Ação',
'14'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Shang-Chi e a Lenda dos Dez Anéis',
'Shang-Chi enfrenta o legado de sua família.',
'Ação',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Eternos',
'Seres imortais protegem a humanidade há milhares de anos.',
'Ficção Científica',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Thor: Amor e Trovão',
'Thor embarca em uma jornada de autodescoberta.',
'Fantasia',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Pantera Negra: Wakanda Para Sempre',
'Wakanda enfrenta novos desafios após grandes perdas.',
'Ação',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Homem-Formiga e a Vespa: Quantumania',
'Scott Lang entra no Reino Quântico com sua família.',
'Ficção Científica',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Guardiões da Galáxia Vol. 3',
'Os Guardiões enfrentam ameaças ao passado de Rocket.',
'Ficção Científica',
'14'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'As Marvels',
'Carol Danvers une forças com novas heroínas.',
'Ação',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Deadpool & Wolverine',
'Deadpool e Wolverine se unem em uma aventura caótica.',
'Ação',
'18'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Capitão América: Admirável Mundo Novo',
'Sam Wilson assume novos desafios como Capitão América.',
'Ação',
'12'
);

INSERT INTO videos
(titulo, descricao, categoria, classificacao_indicativa)
VALUES
(
'Thunderbolts*',
'Um grupo de anti-heróis realiza missões perigosas.',
'Ação',
'14'
);

-- Criação da tabela de curtidas
CREATE TABLE curtidas (

    usuario_id INTEGER REFERENCES usuarios(id) ON DELETE CASCADE, -- Chave estrangeira pega da tabela de usuários
    video_id INTEGER REFERENCES videos(id) ON DELETE CASCADE, -- Chave estrangeira pega da tabela de vídeos

    PRIMARY KEY (usuario_id, video_id) -- Chave primária composta, para garantir que se um é excluido o outro também seja excluido

);

-- Criação da tabela de favoritos
CREATE TABLE favoritos (
    id SERIAL PRIMARY KEY,-- Chave primária
    usuario_id INT NOT NULL UNIQUE,-- Chave estrangeira pega da tabela de usuários, e é unico para garantir que cada usuário tenha apenas um favorito

    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) -- Chave estrangeira pega da tabela de usuários
    ON DELETE CASCADE-- para garantir que se um usuário for excluido, seu favorito também seja excluido
);

-- Criação da tabela de favoritos_video
CREATE TABLE favoritos_video (
    id SERIAL PRIMARY KEY,-- Chave primária
    favorito_id INT NOT NULL,-- Chave estrangeira pega da tabela de favoritos
    video_id INT NOT NULL,-- Chave estrangeira pega da tabela de vídeos

    FOREIGN KEY (favorito_id) REFERENCES favoritos(id)-- Chave estrangeira pega da tabela de favoritos
    ON DELETE CASCADE,-- para garantir que se um favorito for excluido, seus videos favoritos também sejam excluidos

    FOREIGN KEY (video_id) REFERENCES videos(id)-- Chave estrangeira pega da tabela de vídeos
    ON DELETE CASCADE-- para garantir que se um video for excluido, ele seja excluido dos favoritos de todos os usuários
);