# Desafio Santander - Consulta CEP

Resumo
- Aplicação Spring Boot que consulta CEPs usando mocks do WireMock e armazena/consulta resultados em Redis. Aplicação criada no Modelo MVC separando cada camada da aplicação sua responsabilidade com o objetivo simples e rápido de mockarmos uma consulta de CEP com wiremock.

Componentes principais
- MainResource (Controller): expõe endpoints /consulta_cep/{cep} e /consulta_cep, recebe requisições e delega para a camada de serviço.
- ConsultaCepService (Service): orquestra a lógica: valida entrada, chama cliente externo (RestTemplateService), atualiza cache e prepara resposta.
- RestTemplateService (Service): recebe valor do cep a ser consultado e chama cliente externo (mock) para obtenção dos dados.
- Mapper: responsabilidades de conversão entre entidades externas/DTOs e o domain.Cep.

Fluxo de requisição
- Requisição chega em MainResource.
- ConsultaCepService chama restTemplateService (WireMock/externo).
- Resultado é salvo em cache via redis e retornado ao cliente.
- Todas conversões de payload passam pelo Mapper.

Como rodar (local com Docker)
1. Build e start:
   docker compose up --build

2. Endpoints
- /consulta_cep/{cep} - busca determinado CEP nos mocks mapeados, registra a busca do CEP no redis e retorna os dados da consulta.
- /consulta_cep: busca no redis todos os CEP consultados com os dados da API e dataHora da consulta feita.
