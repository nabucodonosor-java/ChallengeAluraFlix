# Alura Challenge Backend - Projeto: AluraFlix
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/nabucodonosor-java/ChallengeAluraFlix/blob/main/LICENSE)

https://app-alura-flix.herokuapp.com \
**username** user@mapin.com \
**password** alura-flix

## Sobre o desafio

Dividido em 4 semanas o desafio requisita o desenvolvimento de uma APIRest de uma plataforma para compartilhamento de vídeos. Ao término da quarta semana a plataforma 
deve permitir ao usuário montar playlists com links para seus vídeos preferidos, separados por categorias. O sistema ágil de desenvolvimento utilizado será o Trello.

No meu caso vou criar um projeto Spring Boot utilizando o Maven como gerenciador de dependências e a linguagem java 11. O DB utilizado será o Postgres e a API será
hospedada no Heroku. As dependências do spring utilizadas no projeto foram: starter-web, data-jpa, h2, postgresql, validation, test (excluindo as versões antigas), security, oauth2 e commons-io.\
\
**Sobre as Mensagens Personalizadas de Erro e Validações:**
criei a classe ResourceExceptionHandler e anotei com @ControllerAdvice (anotação spring para monitorar todos as exceções lançadas pelos controllers da aplicação).

### Semana 1

**Entidade, requisições e regra de negócio**
![Web 1](https://personal-bucket-franco.s3.sa-east-1.amazonaws.com/s1.png)

#### Json para realizar as requisiçãos (no caso meu caso utilizei o Postman)

Requisição POST e PUT para /videos e /categorias (lembrando que caso não seja especificado o id da categoria no cadastro ou atualização do vídeo o sistema irá atribuir a categoria id 1 - LIVRE)\
\
**\videos** \
{\
    "titulo": "Quando A Gira Girou",\
    "descricao": "Zeca Pagodinho - Quando A Gira Girou",\
    "url": "https://www.youtube.com/watch?v=Nm5N4iFLU0g", \
    "categoriaId": 2\
}
\
\
**\categorias** \
{\
    "titulo": "Aeromodelismo",\
    "cor": "purple",\
}
#### Cenários de erro na requisição e respectivas respostas http status e Validações

-> GET findById -> id inexistente\
Http Status: 404 Not Found\
Exceção Lançada: ResourceNotFoundException\
Mensagem: {{ Recurso }} não encontrado!

-> POST insert / PUT update -> campo em branco\
Http Status: 400 Bad request\
Exceção Lançada: MethodArgumentNotValidException\
Mensagem: O campo é obrigatório!

-> POST insert / PUT update -> tamanho do campo título\
Http Status: 400 Bad request\
Exceção Lançada: MethodArgumentNotValidException\
Mensagem: Título deve ter no máximo 30 caracteres

-> POST insert / PUT update -> Campo título e/ou url repetido\
Http Status: 400 Bad request\
Exceção Lançada: SQLException\
Mensagem: Recurso já cadastrado!

-> DEL deleteById -> id inexistente\
Http Status: 404 Not Found\
Exceção Lançada: ResourceNotFoundException\
Mensagem: {{ Recurso }} não encontrado!

### Semana 2

**Entidades**\
![Web 1](https://personal-bucket-franco.s3.sa-east-1.amazonaws.com/s2.png)\
**Requisições Http**
\
\
Atender uma requisição GET que exiba todos os categorias com o seguinte endpoint:\
/categorias\
\
Atender uma requisição GET que retorne uma única categoria caso o ID do seja válido, com o seguinte endpoint:\
/categorias/{ categoriaId }\
\
Atender uma requisição POST que crie uma nova categoria, caso todos os campos estejam preenchidos e validados.\
/categorias\
\
Atender uma requisição PUT/PATCH capaz de atualizar um ou mais campos de um vídeo\
/categorias/{ categoriaId }\
\
Criar uma rota GET relacionando categorias e videos:\
/categorias/{ categoriaId }/videos\
\
Criar uma rota GET que busque vídeos por nome via query parameters, por exemplo:\
/videos?titulo={ tituloVideo }\
\
**Regras de Negócio**\
\
A categoria com ID = 1, deve chamar LIVRE e caso ela não seja especificada na criação do vídeo, vamos atribuir o ID = 1.\
Uma nova categoria não pode ser criada caso tenha algum campo vazio.\
Testes Unitários **(Repositories, Services e Controllers)** utilizei o Junit5 e Mockito para implementar os testes unitários e de integração

### Semana 3 e 4

Nesta semana, o desafio será complementar a API adicionando paginação nas requisições de vídeos e categorias. Além disso, foi solicitado para segurança dos recursos proporcionados pela API, adicionar um método de autenticação. Para finalizar, vamos realizar o deploy da API disponibilizando os recursos para todos.\
A paginação foi implementanda na primeira semana do desafio assim como deploy que foi realizado no heroku. A autenticação será desenvolvida com o padrão JWT(Json Web Token) utilizando o Spring Security e o OAuth2.\
\
**Parâmetros de Paginação**
/videos?page=0&size=12&sort=titulo&direction=ASC \
- page: número da página (lembrando que a página 0 é a página 1;
- size: quantidade de objetos por página;
- sort: ordenação por campo
- direction: ASC ascendente e DESC decrescente.
\
\
**Regras de Negócio**
- Adicione nas requisições GET em ambos os modelos, tanto vídeos como categoria uma paginação que retorne 5 itens por página;
- Para garantir a segurança dos dados, implemente algum tipo de autenticação, para que só os usuários autenticados possam acessar as rotas de GET, POST, PUT e DELETE;\
**Caso a autenticação não seja válida, retornar uma mensagem informando Não autorizado ou Credenciais inválidas.**\
**Caso usuário e senha inválido, informar Usuário e senha inválido.**
- Criar o seguinte endpoint com um número fixo de filmes disponível, sem a necessidade de autenticação: GET /videos/free.
\
#### Configrações do Postman com cenário de segurança e autenticação habilitados

**Variáveis de Ambiente** \
host -> https://app-alura-flix.herokuapp.com \
client-id -> alura-flix \
client-secret -> alura-flix123 \
username -> user@mapin.com \
password -> alura-flix \
token -> (deixar vazio) \
\
**Endpoint para Login** \
Basic Auth -> Username -> {{client-id}} Password -> {{client-secret}} \
x-www-form-urlenconded -> Add key e value: username = {{username}} -- password = {{password}} -- grant_type = password
\
\
**Nos endpoints que necessitam de autenticação e autorização** \
Authorization -> Bearer Token e no campo Token colocar a variável de ambiente {{token}} \
Body -> raw -> JSON -> inserir o json conforme modelos já dados nessa documentação.


