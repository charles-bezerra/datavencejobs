# DatavenceJobs-API

## Etapas

### 1 - Instale em sua máquina o PostgreSQL

=> Tutorial para ubuntu: youtube.com/watch?v=LYgQW4a_anA


### 2 - Baixe o projeto e descompacte o arquivo

=> Na sua máquina abra seu projeto com a IDE de sua preferência, no meu caso IntelliJ.


### 3 - Configurar o banco de dados no Spring

=> No arquivo resources/application.properties alterar e adicionar o seguinte:

spring.datasource.initialization-mode=always

spring.datasource.url=jdbc:postgresql://localhost:5432/banco de dados criado por você

spring.datasource.username= usuario que definiu

spring.datasource.password= senha que definiu

spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true


### 4 - Executar o projeto

#### Obs: Lembre-se de baixar, instalar e executar o front-end em seguida <a href="https://github.com/charles-bezerra/DatavenceJobs-Front/">neste link</a>

