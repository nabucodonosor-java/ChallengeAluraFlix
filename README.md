# Alura Challenge Backend - Projeto: AluraFlix
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/nabucodonosor-java/ChallengeAluraFlix/blob/main/LICENSE)


https://app-alura-flix.herokuapp.com

## Sobre o desafio

Dividido em 4 semanas o desafio requisita o desenvolvimento de uma APIRest de uma plataforma para compartilhamento de vídeos. Ao término da quarta semana a plataforma 
deve permitir ao usuário montar playlists com links para seus vídeos preferidos, separados por categorias. O sistema ágil de desenvolvimento utilizado será o Trello.

No meu caso vou criar um projeto Spring Boot utilizando o Maven como gerenciador de dependências e a linguagem java 11. O DB utilizado será o Postgres e a API será
hospedada no Heroku.

### Semana 1

**Entidade, requisições e regra de negócio**
![Web 1](https://personal-bucket-franco.s3.sa-east-1.amazonaws.com/s1.png)

#### Cenários de erro na requisição e respectivas respostas http status e Validações

-> GET findById -> id inexistente\
Http Status: 404 Not Found

-> POST insert / PUT update -> campo em branco\
Http Status: 400 Bad request

-> POST insert / PUT update -> tamanho do campo título\
Http Status: 400 Bad request

-> POST insert / PUT update -> Campo título e/ou url repetido\
Http Status: 400 Bad request

-> DEL deleteById -> id inexistente\
Http Status: 404 Not Found

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
**Regras de Negócio**
* A categoria com ID = 1, deve chamar LIVRE e caso ela não seja especificada na criação do vídeo, vamos atribuir o ID = 1.
* Uma nova categoria não pode ser criada caso tenha algum campo vazio.
* Testes Unitários **(Repositories, Services e Controllers)**
* Testes de Integração

