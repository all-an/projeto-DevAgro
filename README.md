# DEV-Agro
API Rest em Java para o controle de produção agrícola com interação entre Fazendas, Empresas, Funcionários e Grãos

<p align="center">
        <a href="https://www.linkedin.com/in/allan-pereira-abrahao/">
            <img align="center" width="933" height="468"  src="/img-readme/agroaevidaimg.png" />
        </a>
</p>

## Tecnologias utilizadas:

- Java 17
- Spring Boot 2
- PostgreSQL

## Executando a aplicação:

- IDE IntelliJ IDEA Community Edition 2021.2.3 ou superior

## Requisitos Funcionais:
- [Checklist / Roadmap dos Requisistos Funcionais do sistema](https://github.com/all-an/projeto-DevAgro/blob/main/RequisitosFuncionais.md)

## Cadastrando Empresa:
```json
```

```json
{
    "nome": "Empresa SENAI LTDA",
    "cnpj": "00.536.492/0001-34",
    "endereco": "Rua 1 num 1"
}
```
### Cadastrando Empresa com CNPJ inválido:

```json
{
    "nome": "Empresa ERRADA LTDA",
    "cnpj": "0000001234",
    "endereco": "Rua 1 num 1"
}

```
### Retorno esperado:

```json
{
    "dados": null,
    "erros": [
        "Formate assim CNPJ XX.XXX.XXX/XXXX-XX",
        "invalid Brazilian corporate taxpayer registry number (CNPJ)"
    ]
}
```
## Cadastrando Fazenda:

```json
{
    "nome": "Fazenda NOVA",
    "endereco": "Rua 111 num 9999",
    "empresa": {
        "id": 1,
        "nome": "Empresa Java LTDA",
        "cnpj": "97.753.887/0001-20",
        "endereco": "Rua 8 num 90"
    },
    "dataUltimaColheita": "2022-03-11T19:53:07Z",
     "grao": {
        "id": 3,
        "nome": "Feijão"
    },
    "estoqueInicialGraos": 1000.0
}
```
## Cadastrando Grão:

- ENDPOINT http://localhost:8080/graos/

```json
{
    "nome": "Grão de Bico",
    "tempoMedioColheita": 300,
    "empresa": 
        {
            "id": 1,
            "nome": "Empresa Java LTDA",
            "cnpj": "97.753.887/0001-20",
            "endereco": "Rua 8 num 90"
        }
    
}
```

### Resposta esperada:

```json 
{
    "dados": {
        "id": 25,   << exemplo id
        "nome": "Grão de Bico",
        "tempoMedioColheita": 300,
        "empresas": 
            {
                "id": 1,
                "nome": "Empresa Java LTDA",
                "cnpj": "97.753.887/0001-20",
                "endereco": "Rua 8 num 90"
            }
        
    },
    "erros": []
}
```

## Cadastrando Funcionario:

```json
{
    "nome": "Allan",
    "sobrenome": "Ritchie",
    "sexo": "MASCULINO",
    "endereco": "Rua 2 num 4",
    "salario": 1200.0,
    "telefone": "(49) 916787675",
    "nascimento": "01/01/2001",
    "contratacao": "01/01/2022",
    "funcoes": [
        {
            "id": 2,
            "nome": "Operador de Plantador"
        }
    ],
    "empresa":{
        "id": 1,
        "nome": "Empresa Java LTDA",
        "cnpj": "97.753.887/0001-20",
        "endereco": "Rua 8 num 90"
    }
}
```

### Cadastro funcionário inválido:

telefone inválido:    "telefone": "916787675",

#### Resposta esperada:

```json
{
    "dados": null,
    "erros": [
        "Deve ser um formato válido (XX) XXXXXXXXX"
    ]
}
```

## Retornando todos os funcionarios de uma empresa:

ENDPOINT:
/empresas/listaFuncionarios/1  << ID da empresa

## Retornando quantidade de funcionarios de uma empresa:

ENDPOINT:
  
/empresas/quantidadeFuncionarios/1 << ID da empresa

## Outros exemplos de entradas de dados em formato Json e respectivos Endpoints:

- [Exemplos, Json e Endpoints](https://github.com/all-an/projeto-DevAgro/blob/main/ExemplosJsonEntradas.md)

## Autor:
- [Allan Pereira Abrahão](https://www.linkedin.com/in/allan-pereira-abrahao/)

## Licença:
- [MIT](https://github.com/all-an/DEV-Agro/blob/main/LICENSE)



