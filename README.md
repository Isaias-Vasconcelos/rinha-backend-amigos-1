# Rinha de backend entre amigos 1° edição 🚀

Olá , me chamo Isaías Vasconcelos e quero que você participe deste teste para testar suas habilidades como desenvolvedor backend 😍. 

Lembrando que:

`A API que mais aceitar requisição vence!`

`Vocês terão 1 semana para construir a API`

`Qualquer arquitetura e linguagem é valida`

`Siga as regras`

O desafio é... que rufem os tambores 🥁...

## Você deverá construir uma `api  de provador de roupas` ...

 #### Funcionalidades :

A api deverá receber e retornar um cliente no formato que está na pasta de exemplos no repositório, onde cada cliente deverá receber uma lista de roupas que ele escolheu para provar no campo `clothes`, as roupas que o cliente escolheu para provar serão armazenadas em outra tabela, onde a tabela roupas possui um relacionamento com a tabela clientes.

- Criação de clientes ;
- Listagem de clientes;
- Listagem de cliente por termo (roupa, nome ou sobrenome) na mesma consulta.
### Entrada e saída da api:

O exemplos de entrada e retorno da api estão localizados na pasta de exemplos do repositório, dá uma olhada lá... 😊 

####  Tabelas :

Você deverá fazer uma relação entre 1 cliente para várias roupas, ou seja, serão 2 tabelas:

- Cliente ;
- Roupas ;

###### Definições:

Obs: O tipo de banco de dados é de sua escolha (Mysql,Pgsql,MongoDb...) apenas siga o padrão de criação das tabelas, caso não siga, não irei considerar seus resultados.

Clientes:

```sh
 id VARCHAR(36) NOT NULL PRIMARY KEY
 name VARCHAR(25) NOT NULL
 lastname VARCHAR(50) NOT NULL
```
Roupas:
```sh
id VARCHAR(36) NOT NULL PRIMARY KEY
clienteId VARCHAR(36)
name TEXT NOT NULL
```
 A coluna id de cada tabela tem que ser definida como chave primaria e do tipo varchar.
 
 O id utilizado é do tipo UUID:
 
 ```sh
 '50b97e45-526c-4a8d-bddf-2d82e2f1b669'
 ```
### Requisições:

| Type | Url |
| ---- | --- |
| GET | /api/clientes |
| GET | /api/clientes?termo=cliente1 |
| POST | /api/clientes |


### Testes de carga:

Os testes de carga serão realizados utilizando o K6 grafana , logo abaixo tem o exemplo de como instala-lo :

##### Instalação :
Utilzando o Powershell : 
```sh
winget install k6 --source winget
```

Utilizando o Node :
```sh
npm install -g k6
```
##### Uso:

Os testes estão localizados dentro da pasta `teste_carga`, apenas entre na pasta, faça as alterações de url para o teste ser feito na sua api, e em seu terminal execute o comando:

```sh
k6 run teste_carga_rinha.js
```

Após a realização dos testes, adicionem  o print do resultado do teste em formato de imagem  na pasta `resultados` que está no repositório.

É isso meus amigos... Desejo boa sorte a cada um que está participando. Que comecem os jogos 🚀!
  
