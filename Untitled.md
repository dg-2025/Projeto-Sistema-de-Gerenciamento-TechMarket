

###### API: REST



A API que vamos usar é baseada em REST.

============================================================================================================================================================================



###### APIs e Banco de Dados



A API se comunica com o banco de dados.

Para isso, é necessário uma ferramenta que faça a tradução entre o banco de dados e a aplicação. No caso do Java, essa ferramenta é o JPA (Java Persistence API).



============================================================================================================================================================================



###### JPA e Hibernate



Vamos usar o JPA junto com o Hibernate.

O Hibernate é uma implementação da ORM (Object-Relational Mapping), que mapeia objetos para tabelas de banco de dados e facilita a interação entre a aplicação e o banco.

Toda linguagem de programação tem, ou pode ter, uma ORM para simplificar esse mapeamento. O Hibernate é uma das mais populares para Java.



============================================================================================================================================================================



###### Spring Framework



O Spring Framework é um conjunto de ferramentas que facilita o desenvolvimento de aplicações Java.

Ele simplifica a configuração e a criação de aplicações robustas, fornecendo várias funcionalidades prontas para uso.



============================================================================================================================================================================



###### Spring Boot

&nbsp;

O Spring Boot é uma extensão do Spring que permite criar aplicações prontas para produção de maneira muito rápida, em questão de minutos.



============================================================================================================================================================================



###### Passos para Criar uma Aplicação com Spring Boot



1.Criar o modelo de dados (Model): Define as tabelas que serão usadas no banco de dados.

2.Criar os Repositórios (Repositories): Intermediários entre o modelo e o banco de dados. Permitem o acesso e manipulação dos dados.

3.Criar o Service: Contém a lógica de negócios, onde as operações principais da aplicação são realizadas.

4.Criar o Controller: Responsável por gerenciar as requisições HTTP e direcionar para os serviços adequados.

4.1 - 

============================================================================================================================================================================



Backend - API 

Arquitetura (Como os sistemas são organizados) 



Arquitetura em Camadas

1\. Model (Tabelas) 

2\. Repository (Interage diretamente com BD) 

2.1 - Anotações (@Repository) 

2.2 - Herdar de JpaRepository 

3\. Service (Agrupar a lógica de negócio) 

3.1 - Anotações (Service)

3.2 - Injeçao 

4\. Controller\_(Porta de entrada da API)

4.1 - Anotações (RestController e RequestMapping) 

4.2 - Injeção de Dependência 





