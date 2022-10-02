Projeto spring-boot cadastro

Criação e execução do banco de dados:
docker-compose up
caso o comando acima não execute os scripts sql faça o seguinte comando:
docker-compose down --volumes

Para executar o projeto defina os valores em
Edit Configurations: 
 - SPRING_PROFILES_ACTIVE=local