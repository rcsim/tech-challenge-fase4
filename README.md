# Tech-challenge-fase4
## Repositório para o Tech Challenge Fase 4 - Grupo 30
Este repositório contém o código-fonte e a documentação para o Tech Challenge - Fase 4, desenvolvido pelo Grupo 30.

O projeto consiste em uma aplicação web para exibição de videos utilizando Spring Framework, Spring WebFlux, Spring Boot e Sping Data. A API permite gerenciamento de videos e usuários e principalmnente o streaming the videos utilizando endpoints reativos.

## 1- Relatório Técnico
Tecnologias e ferramentas utilizadas

* Linguagem de programação: 

    * Java 17

* Framework:
    * Spring Boot 3.2.0

* Bibliotecas:
  * Spring Web
  * Spring WebFlux
  * OpenAPI
  * Lombok
    
* Tests:
  * JUnit
  * JMockit
    
* Banco de dados:
  * MongoDB
    
* Outras ferramentas:
  * Docker 

## Configurações da solução

### Banco de Dados

Configuração de produção utilizando o MongoDB
https://github.com/rcsim/tech-challenge-fase4/blob/f88aa5295d6df5e0906a2d262845c530d474bad9/src/main/resources/application-dev.properties#L1

Relacionamento entre as entidades:

TODO1

### Container


Criamos um container para aplicação e outro para o banco de dados e uma rede no modo bridge para ter acesso ao containers via localhost:


Também adicionamos o arquivo Dockerfile que gerencia o processo de build da aplicação através do Maven e JDK, já inicializando a aplicação:

https://github.com/rcsim/tech-challenge-fase4/blob/f88aa5295d6df5e0906a2d262845c530d474bad9/Dockerfile#L1-L19

Para criação dos container, compilar e rodar a applicação é necessário apenas o comando:

https://github.com/rcsim/tech-challenge-fase4/blob/f88aa5295d6df5e0906a2d262845c530d474bad9/docker-compose.yml#L1-L28

docker-compose up -d


![image](https://github.com/rcsim/tech-challenge-fase4/assets/30301531/a8cae5b0-889f-4518-b627-364bf3790faa)


### Documentação das APIS 
Adicionamos a geração automática da documentação através da biblioteca SpringDoc OpenAPI, a documentação pode ser acessada enquanto a aplicação estiver rodando em http://localhost:8080/swagger-ui/index.html#/:

![image](https://github.com/rcsim/tech-challenge-fase4/assets/30301531/9eeee24f-7b89-4949-aba3-c7177383b982)
![image](https://github.com/rcsim/tech-challenge-fase4/assets/30301531/0692561d-6279-4dcb-8e37-d688634ca755)
![image](https://github.com/rcsim/tech-challenge-fase4/assets/30301531/b590f4c5-7c47-48bc-9a67-36c703985023)



#### Arquivo POSTMAN

Disponibilizamos um conjunto de arquivos JSON com todas as requisições Postman para testar a API, os arquivos estão disponíveis nos seguintes links:

https://github.com/rcsim/tech-challenge-fase4/blob/main/src/main/resources/postman/Category.postman_collection.json
https://github.com/rcsim/tech-challenge-fase4/blob/main/src/main/resources/postman/Statistics.postman_collection.json
https://github.com/rcsim/tech-challenge-fase4/blob/main/src/main/resources/postman/Users.postman_collection.json
https://github.com/rcsim/tech-challenge-fase4/blob/main/src/main/resources/postman/Videos.postman_collection.json


## Streaming the Videos com Deploy AWS S3
TODO2



## Conclusões 

TODO3
