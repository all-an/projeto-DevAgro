```json
```

## Colheita:

- endpoint:  colheita/<id Fazenda>

```json
{
    "colheita": 300.00
}
```


## Retirada de grãos:

- endpoint:  retirarGrao/<id Fazenda>

```json
{
    "retiradaDeGraos": 70.0
}
```

## Retorna lista de grãos uma empresa:

- endpoint: /empresas/graos/<id Empresa>

## Estoques grãos ordem crescente:

/estoquesGraos/{id}

##### Exemplo de retorno esperado:

```json 
{
    "Grão: Soja": 500.0,
    "Grão: Milho": 1000.0,
    "Grão: Feijão": 3000.0
}
```