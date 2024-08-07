# Sistema de registros de ordens de serviço

Sistema de gerenciamento de ordens de serviço para uma loja que oferece reparos em aparelhos eletrônicos. Esse sistema possibilitará o cadastro do cliente, do equipamento e posteriormente irá gerar uma ordem de serviço, onde o profissional responsável irá descrever o trabalho realizado e atualizará o Status da demanda.

## Para começar

Antes de executar o programa, certifique-se que tenha uma versão da JRE instalada na sua máquina. Depois disso, clone o projeto do github e vá na pasta onde está o JAR, em "rpinfo_desafio_java/out/artifacts/rp_desafio_java_jar", abra o terminal e digite o seguinte comando `java -jar rp_desafio_java.jar`, isso irá iniciar o programa.

### Menu inicial

No menu inicial será apresentado as opções para o usuários interagir com o sistema.

 1 - Nova ordem de serviço
 2 - Listar ordens de serviço
 3 - Consultar ordem de serviço
 4 - Atualizar ordem de serviço
 0 - Sair

#### 1 - Nova ordem de serviço
Aqui será possível cadastrar os dados do cliente e também do equipamento. Também será  necessário informar a descrição do servico a ser realizado.

#### 2 - Listar ordens de serviço
Opção para listar todas as as ordens de serviço.

#### 3 - Consultar ordem de serviço
Será solicitado o ID da ordem de serviço que será buscado no banco.

#### 4 - Atualizar ordem de serviço
Opção para atualizar uma ordem de serviço em andamento. Usado caso a ordem seja finalizada ou parada por alguma razão, será possível descrever melhor a situação da demanda.

#### 0 - Sair
Encerra o programa.

## Consumo da API

Depois de executar o programa, é possível consultar os dados do banco via API. Isso pode ser feito pelo navegador ou um software espcífico para isso (Postman, Insomnia, etc).

### Acessando clientes

No endereço local `http://localhost:8080/clientes` será possível recuperar os dados do cliente. Você também pode recuperar um cliente em específico pelo ID no `http://localhost:8080/clientes/(id)`.

### Acessando equipamentos

No endereço local `http://localhost:8080/equipamentos` será possível recuperar os dados do equipamento. Você também pode recuperar um equipamento em específico pelo ID no `http://localhost:8080/equipamentos/(id)`.

### Acessando ordens de serviço

No endereço local `http://localhost:8080/ordem_servico` será possível recuperar os dados das ordens de serviço cadastrados. Você também pode recuperar uma ordem de serviço em específico pelo ID no `http://localhost:8080/ordem_servico/(id)`.
