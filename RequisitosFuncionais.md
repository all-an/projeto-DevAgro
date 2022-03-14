## Requisitos Funcionais:

- [x] - O sistema deve ser desenvolvido em Java com Spring.
- [x] - O sistema deve utilizar banco de dados PostgreSQL.
- [x] - O sistema deve seguir o Roteiro da Aplicação logo abaixo.
- [x] - O sistema deve ser uma API que se comunica com outros serviços (por exemplo, front-end web ou Postman) através de requisições HTTP.

- [x] - A API deve possibilitar o cadastro de Empresas, Fazendas, Funcionários, Grãos.

- [x] - O cadastro de empresas deve possibilitar o registro de nome, CNPJ e endereço.
- [x] - Cada empresa pode ter uma ou mais propriedades rurais associadas (fazendas).
- [x] - Cada empresa pode ter um ou mais funcionários associados.
- [x] - Cada empresa pode ter um ou mais grãos associados.
- [x] - O CNPJ deve ser validado para estar no formato: XX.XXX.XXX/XXXX-XX.

- [x] - O cadastro de fazendas deve possibilitar o registro de nome, endereço, qual grão é produzido naquela propriedade, qual o estoque inicial daquele grão naquela fazenda (em kg), e qual empresa é proprietária da fazenda.
- [x] - Cada fazenda pode ter apenas um grão associado.
- [x] - Cada fazenda pode estar associada a apenas uma empresa.
- [x] - Cada fazenda deve possuir um atributo para guardar a data da última colheita.

- [x] - O cadastro de grãos deve possibilitar o registro de nome, empresa e tempo médio de colheita, em quantidade de dias. ( Tempo médio é input )

- [x] - O cadastro de funcionários deve possibilitar o registro de nome, sobrenome, CPF, endereço, telefone, sexo, data de nascimento, data de contratação, e qual empresa o emprega.
- [x] - O CPF deve ser validado para estar no formato: XXX.XXX.XXX-XX.
- [x] - O telefone deve ser validado para estar no formato: (XX) XXXXXXXXX.

- [x] - Nesse primeiro momento, não é necessário fazer o front-end da aplicação, apenas o back-end, ou seja, a API (em Java com Spring Boot) e o banco de dados (PostgreSQL).
- [x] - Você poderá testar sua aplicação utilizando ferramentas como Postman, Insomnia ou Curl.

- [x] - Será necessário implementar os endpoints (controller, service, repository) para cadastro de todas essas entidades (models).

- [x] - Na aplicação devem existir: 
- [x] - Um endpoint para retornar a lista completa de empresas cadastradas.
- [x] - Um endpoint que retorna a lista de fazendas de uma empresa.
- [x] - Um endpoint que retorna a quantidade de fazendas de uma empresa.
- [x] - Um endpoint que retorna uma lista de fazendas de uma empresa, onde cada elemento da lista deve ter 3 atributos: ID da fazenda, nome da fazenda e a data prevista da próxima colheita (considerando a data da última colheita e o tempo médio de colheita do grão associado a essa fazenda).
- [x] - Um endpoint para registrar colheita em uma fazenda, que aumenta o estoque de grãos daquela fazenda.
- [x] - Um endpoint para registrar retirada de grãos de uma fazenda, que diminui o estoque de grãos daquela fazenda.
- [x] - Um endpoint que retorna a lista de grãos de uma empresa.
- [x] - Um endpoint que retorna a lista de grãos associados a uma empresa, onde cada elemento da lista deve conter: nome do grão e quantidade em estoque, ordenado de menor para maior quantidade em estoque.
- [x] - Um endpoint que retorna a lista de funcionários de uma empresa.
- [x] - Um endpoint que retorna a quantidade de funcionários de uma empresa.
