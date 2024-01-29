# Tech-challenge-fase4
## Repositório para o Tech Challenge Fase 4 - Grupo 30
Este repositório contém o código-fonte e a documentação para o Tech Challenge - Fase 4, desenvolvido pelo Grupo 30.

O projeto consiste em uma aplicação web para exibição de videos utilizando Spring Framework, Spring WebFlux, Spring Boot e Sping Data. A API permite gerenciamento de videos, usuários e principalmnente o streaming the videos utilizando endpoints reativos.

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
  * AWS Java SDK
    
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

O schema e os dados iniciais do banco de dados são criados através do arquivo schema.js:

https://github.com/rcsim/tech-challenge-fase4/blob/e97832c47978104b3421e2ddaad67460fe6773ea/schema.js#L1-L62

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
https://github.com/rcsim/tech-challenge-fase4/blob/main/src/main/resources/postman/Stream.postman_collection.json


### Testes de Unidade 
Utilizando as bibliotecas JUnit e JMockit, implementamos os testes de unidade, chegando a 93% de cobertura das classes do sistema:

![image](https://github.com/rcsim/tech-challenge-fase4/assets/30301531/fcc79848-91b5-4e5a-a17c-2eaacaca7966)

## Streaming the Videos com Deploy AWS S3
Para gerenciar vídeos de forma eficiente, utilizamos o Amazon S3 para armazenamento e o AWS Java SDK para facilitar a interação com o S3. Os vídeos são enviados e organizados em buckets no S3, aproveitando sua escalabilidade e durabilidade. O AWS Java SDK simplifica a integração, proporcionando uma maneira fácil e segura de baixar vídeos para transmissão. A combinação dessas tecnologias garante uma recuperação eficiente dos vídeos armazenados, permitindo uma experiência de transmissão suave e confiável. A segurança é mantida por meio de políticas de controle de acesso, garantindo a proteção dos vídeos armazenados no S3.

![image](https://github.com/rcsim/tech-challenge-fase4/blob/feature/recomendacao/assets/bucketS3.png)



## Conclusões 

O projeto foi concluído com êxito, atendendo integralmente aos requisitos propostos no desafio. A escolha criteriosa das tecnologias e ferramentas desempenhou um papel fundamental, proporcionando um ambiente propício para o desenvolvimento eficiente e robusto do sistema. Destaca-se o enfoque dedicado à implementação de endpoints reativos com Spring WebFlux, constituindo o principal ponto de aprendizado nesta etapa. Vale ressaltar que, devido à novidade desse paradigma para alguns membros do grupo, foram necessários esforços adicionais para assimilação e aplicação efetiva.

As principais dificuldades encontradas estão relacionadas à incorporação do protocolo HLS para o streaming de vídeos e à hospedagem destes na AWS S3. Conforme mencionado anteriormente, o paradigma de programação reativa também se configurou como um ponto de atenção, dada sua novidade para parte dos integrantes. Essas questões exigiram uma abordagem cuidadosa e estratégica para superação, demonstrando a capacidade do grupo em lidar com desafios complexos.


