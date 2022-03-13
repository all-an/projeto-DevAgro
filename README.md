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
- [Checklist / Roadmap dos Requisistos Funcionais do sistema](https://github.com/all-an/DEV-Agro/blob/main/RequisitosFuncionais.md)

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


## Outros exemplos de entradas de dados em formato Json e respectivos Endpoints:

- [Exemplos, Json e Endpoints](https://github.com/all-an/dev-agro-devinhouse/blob/main/ExemplosJsonEntradas.md)

## Autor:
- [Allan Pereira Abrahão](https://www.linkedin.com/in/allan-pereira-abrahao/)

## Licença:
- [MIT](https://github.com/all-an/DEV-Agro/blob/main/LICENSE)



