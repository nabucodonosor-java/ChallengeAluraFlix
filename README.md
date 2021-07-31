# Alura Challenge Backend - Projeto: AluraFlix
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/nabucodonosor-java/ChallengeAluraFlix/blob/main/LICENSE)


https://app-alura-flix.herokuapp.com

## Sobre o desafio

Dividido em 4 semanas o desafio requsita o desenvolvimento de uma APIRest de uma plataforma para compartilhamento de vídeos. Ao término da quarta semana a plataforma 
deve permitir ao usuário montar playlists com links para seus vídeos preferidos, separados por categorias. O sistema ágil de desenvolvimento utilizado será o Trello.

No meu caso vou criar um projeto Spring Boot utilizando o Maven como gerenciador de dependências e a linguagem java 11. O DB utilizado será o Postgres e a API será
hospedada no Heroku.

### Semana 1

Entidade, requisições e regra de negócio
![Web 1](https://personal-bucket-franco.s3.sa-east-1.amazonaws.com/s1-diagrama.png)

#### Validações

-> GET findById -> id inexistente
Http Status: 404 Not Found

-> POST insert / PUT update -> campo em branco
Http Status: 422 Unprocessable Entity

-> POST insert / PUT update -> tamanho do campo título
Http Status: 422 Unprocessable Entity

-> POST insert / PUT update -> Campo título e/ou url repetido
Http Status: 400 Bad request

-> DEL deleteById -> id inexistente
Http Status: 404 Not Found




