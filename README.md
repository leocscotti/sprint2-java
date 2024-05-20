# VisionaryAI
 Projeto para o challenge

## Integrantes

Leonardo Cordeiro Scotti- RM550769
Responsável por desenvolver aplicação backend em c# e java

Gabriel de Andrade Baltazar- RM550870
Responsável por desenvolver o banco de dados e o script da IA usando Machine Learning

Enzo Ross Gallone- RM551754
Responsável por desenvolver a aplicação em mobile

Vinicius de Araujo Camargo- RM99494
Responsável por desenvolver os serviços de devops e Cloud computing

Pedro Gomes Fernandes- RM551480
Responsável pela arquitetura do projeto em Compliance e Governança

## Diagrama de entidades de relacionamento 
![image](https://github.com/leocscotti/sprint2-java/assets/126523762/0372450b-8d7d-4ce2-8622-a5a997f231b0)

## Como rodar a aplicação
Ao importar o projeto e abri-lo no seu editor de código, rodar a classe "VisionaryAiApplication", cuja é a classe responsável por colocar o projeto no ar.
Após essa etapa, testar os endpoints fornecidos abaixo no Postman ou Insomnia

## Documentação da API e listagem dos endpoints

#### Obter todos os clientes (findAll clienteDTO)

```http
  GET /clientes
```

#### Obter cliente por id (findById clienteDTO)

```http
  GET /clientes/${id}
```

| Parâmetro | Tipo   | Descrição                                    |
|:----------|:-------|:---------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id do cliente a ser buscado |

#### Gravar cliente (save)

```http
  POST /clientes
```

Body:

```json
{
    "nome": "Exemplo",
}
```

| Parâmetro | Tipo     | Descrição                       |
|:----------|:---------|:--------------------------------|
| `nome`    | `String` | Nome do cliente a ser gravado   |


#### Atualizar cliente (update)

```http
  PUT /clientes/${id}
```

| Parâmetro | Tipo   | Descrição                                       |
|:----------|:-------|:------------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id do cliente a ser atualizado |

Body:

```json
{
    "nome": "Exemplo",
}
```

| Parâmetro | Tipo     | Descrição                          |
|:----------|:---------|:-----------------------------------|
| `nome`    | `String` | Nome do cliente a ser atualizado   |

#### Excluir cliente (delete)

```http
  DELETE /clientes/${id}
```

| Parâmetro | Tipo   | Descrição                                     |
|:----------|:-------|:----------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id do cliente a ser excluído |



#### Obter todas as empresas (findAll empresaDTO)

```http
  GET /empresas
```

#### Obter empresa por id (findById empresaDTO)

```http
  GET /empresas/${id}
```

| Parâmetro | Tipo   | Descrição                                    |
|:----------|:-------|:---------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id da empresa a ser buscado |

#### Gravar empresa (save)

```http
  POST /empresas
```

Body:

```json
{
    "cnpj": "12345678912345",
    "email": "exemplo@email.com",
    "nome": "Exemplo",
    "situacao": "ativa"
}
```

| Parâmetro | Tipo     | Descrição                       |
|:----------|:---------|:--------------------------------|
| `cnpj`    | `String` | Cnpj da empresa a ser gravado   |
| `email`   | `String` | E-mail da empresa a ser gravado |
| `nome`   | `String` | Nome da empresa a ser gravado  |
| `situacao` | `String` | Situacao da empresa a ser gravado |

#### Atualizar empresa (update)

```http
  PUT /empresas/${id}
```

| Parâmetro | Tipo   | Descrição                                       |
|:----------|:-------|:------------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id da empresa a ser atualizado |

Body:

```json
{
    "cnpj": "12345678912345",
    "email": "exemplo@email.com",
    "nome": "Exemplo",
    "situacao": "ativa"
}
```

| Parâmetro | Tipo     | Descrição                          |
|:----------|:---------|:-----------------------------------|
| `cnpj`    | `String` | Cnpj da empresa a ser gravado   |
| `email`   | `String` | E-mail da empresa a ser gravado |
| `nome`   | `String` | Nome da empresa a ser gravado  |
| `situacao` | `String` | Situacao da empresa a ser gravado  |

#### Excluir empresa (delete)

```http
  DELETE /empresas/${id}
```

| Parâmetro | Tipo   | Descrição                                     |
|:----------|:-------|:----------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id da empresa a ser excluído |


#### Obter todas as ias (findAll iaDTO)

```http
  GET /ias
```

#### Obter ia por id (findById iaDTO)

```http
  GET /ias/${id}
```

| Parâmetro | Tipo   | Descrição                                    |
|:----------|:-------|:---------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id da ia a ser buscado |

#### Gravar ia (save)

```http
  POST /ias
```

Body:

```json
{
    "tipo": "generativa",
    "descricao": "ia para gerar dados",
    "acuracia": "87%",
    "situacao": "ativa"
}
```

| Parâmetro | Tipo     | Descrição                       |
|:----------|:---------|:--------------------------------|
| `tipo`    | `String` | Tipo da ia a ser gravado   |
| `descricao`   | `String` | Descricao da ia a ser gravada |
| `acuracia`   | `String` | Acuracia da ia a ser gravada  |
| `situacao` | `String` | Situacao da ia a ser gravada |

#### Atualizar ia (update)

```http
  PUT /ias/${id}
```

| Parâmetro | Tipo   | Descrição                                       |
|:----------|:-------|:------------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id da ia a ser atualizado |

Body:

```json
{
    "tipo": "generativa",
    "descricao": "ia para gerar dados",
    "acuracia": "87%",
    "situacao": "ativa"
}
```

| Parâmetro | Tipo     | Descrição                          |
|:----------|:---------|:-----------------------------------|
| `tipo`    | `String` | Tipo da ia a ser gravado   |
| `descricao`   | `String` | Descricao da ia a ser gravada |
| `acuracia`   | `String` | Acuracia da ia a ser gravada  |
| `situacao` | `String` | Situacao da ia a ser gravada |

#### Excluir empresa (delete)

```http
  DELETE /ias/${id}
```

| Parâmetro | Tipo   | Descrição                                     |
|:----------|:-------|:----------------------------------------------|
| `id`      | `Long` | **Obrigatório**. Id da ia a ser excluída |

## Link para o vídeo explicativo da solução 
https://youtu.be/yR397qCfDAc
