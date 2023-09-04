# provatoken

Prova técnica para Token.

foi utilizado o Trello como ferramenta de gestão de projeto, podendo ser acompanhado no link no link: https://trello.com/b/Z3nPMFOQ/provatoken

projeto desenvolvido utilizando Maven, Java 17, SpringBoot 3, banco de dados H2, Docker, e OpenAPI 3.0 (swagger). Foi utilizada a metodologia TDD, criando testes unitários em Junit 5 e de integração através do Postman (no futuro, serão integrados como Newman em uma pipeline Jenkins).

Para rodar o projeto, basta rodar através de uma IDE dando run pelo AssessmentApplication ou baixando a imagem Docker do seguinte repositório do Docker Hub:

[dockerhub prova Token](https://hub.docker.com/repository/docker/lucasbjacob/assessmenttoken/general)

baixando a imagem, deve-se rodar através do comando

docker pull lucasbjacob/assessmenttoken

o projeto pode ser testado via Swagger pelo endpoint

http://localhost:8080/swagger-assessment.html

O projeto se baseia em resolver 2 questões, que foram divididas em packages:


#ENDPOINTS:
java assessments:
GET localhost:8080/tasks/task1 - Retorna um novo Array de objeto em ordem reversa
GET localhost:8080/tasks/task2 - Retorna o mesmo Array de objeto em ordem reversa
GET localhost:8080/tasks/task3 - Retorna uma lista de objetos em ordem reversa
GET localhost:8080/tasks/task4 - Retorna um Array de strings lidos de um arquivo .csv

sql assessments:
GET localhost:8080/sqls/sql1 - Retorna uma Lista de String com o nome de todos os pais
GET localhost:8080/sqls/sql2 - Retorna uma Lista de String com o nome de todos os pais com mais de um filho
GET localhost:8080/sqls/sql3 - Retorna uma Lista de String com o nome de todos os pais de cada filho
GET localhost:8080/sqls/sql4 - Retorna o número de filhos de John
GET localhost:8080/sqls/sql5 - Retorna o número de filhos da Mary

