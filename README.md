# FEITv

Projeto desenvolvido para a disciplina de Java da FEI com o objetivo de criar uma plataforma de informações sobre filmes, inspirada em serviços de streaming.

Como o professor propôs que tivesse um tema para o trabalho, eu escolhi que todos os vídeos seriam filmes da Marvel.

## Funcionalidades

- Cadastro de usuários
- Login de usuários
- Exibir listagem de vídeos
- Busca de vídeos por nome
- Curtir e descurtir vídeos
- Exibir lista de favoritos
- Adicionar e remover favoritos
- Apagar lista de favoritos
- Navegação entre telas

## Tecnologias utilizadas

- Java
- Java Swing
- PostgreSQL
- JDBC
- Maven
- NetBeans

## Arquitetura

O projeto foi desenvolvido utilizando o padrão MVC.

- **Model** = classes de dados
- **View** = telas do sistema
- **Controller** = regras de negócio
- **DAO** = acesso ao banco de dados

## Banco de Dados

O sistema utiliza PostgreSQL (`banco.sql`).

### Tabelas

- usuarios
- videos
- curtidas
- favoritos
- favoritos_video

## Como executar o projeto

### 1. Clonar o repositório

```bash
git clone LINK_DO_REPOSITORIO
```

### 2. Criar o banco PostgreSQL

Criar um banco chamado:

```sql
CREATE DATABASE feiTv;
```

### 3. Configurar a senha do banco

Criar um arquivo `.env` com a senha do banco:

```env
SENHA_DB=sua_senha
```

### 4. Executar o projeto

Abrir no NetBeans e executar a classe:

```bash
feiTv.java
```

## Estrutura do Projeto

```text
src
├── controller
│   ├── FavoritosController
│   ├── LoginController
│   ├── UsuarioController
│   └── VideoController
│
├── feiTv
│   └── feiTv
│
├── model
│   ├── Curtir
│   ├── Favoritos
│   ├── Usuario
│   ├── Video
│   └── dao
│       ├── Conexao
│       ├── CurtirDAO
│       ├── FavoritosDAO
│       ├── UsuarioDAO
│       └── VideoDAO
│
└── view
    ├── CadastroJFrame
    ├── FavoritosJFrame
    ├── LoginJFrame
    └── PrincipalJFrame
```
## Diagrama do Projeto

![Diagrama](Diagrama.png)

## Video de apresentação
[Assistir apresentação do projeto](https://drive.google.com/file/d/1SGpnqFGKTYbRuM3TXlvkjfEJk87sNeEV/view?usp=drive_link)

## Autor

Projeto desenvolvido por Kamila Dantas Luongo.
