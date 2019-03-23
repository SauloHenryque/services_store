# **Descrição:** Atualiza uma store a partir do seu código de identificação.

**Description (en-US):** Update an store by the identifier code

## **Arquitetura**

**Nome da Tag:** store

**Path:** PUT /api/store/{id}

**Nome do Resource:** br.com.saulo.store.web.StoreResource

**Nome do Serviço:** br.com.saulo.store.servicos.StoreServico

**Nome do Método:** atualizarStore

## **Requisição**

### **Nome do Request:** br.com.saulo.store.dto.persists.StorePersist

|Parâmetro | Obrigatório | Descrição | Description (en-US) | Tipo parâmetro | Tipo de dados | Exemplo | Validador |
|---|:---:|---|---|:---:|:---:|---|---|
| id | Sim | Código identificador da store | store identifier | Path | Long  | 1 |
| nome | Não | Nome da store | store name | Body | String | "teste" | Máximo: 255 |
| cnpj | Não | CNPJ da store | CNPJ store | Body | String | "12345678912345" | Máximo: 14 |


### **Exemplo Request:**
```
/api/store/1
```
```json
{
  "nome": "Teste",
  "cnpj": "12345678912345"
}
```

## **Resposta**

### **Nome do Response:** br.com.saulo.store.dto.responses.StoreResponse

|Parâmetro | Descrição | Description (en-US) | Tipo de dados | Exemplo |
|---|---|---|:---:|---|
| id | Código identificador da store | store identifier | Long | 1 | 
| nome | Nome da store | store name | String | "teste" | 
| cnpj | CNPJ store | CNPJ store | String | "12345678912345" |

**Código status da resposta HTTP: 200 - Ok**

### **Exemplo Response:**
```json
{
  "id": 1,
  "nome": "Teste 1",
  "cnpj": "12345678912345"
}
```

## **Documentos e referência**

**Tabelas:** store

## **Detalhes de implementação**

**Pré-requisitos**
* Existir store para o id informado
* Cumprir as validações de entrada
* Não deve existir registros de Exemplo com nomes iguais.

**Fluxo de execução**

1. Consultar a store pelo id
2. Verificar se a store não é nulo  
2.1. Se for nulo, retornar exceção de registro não encontrado  
3. Converter o objeto persist na entidade store
4. Verificar existência de store já registrado com o nome informado  
4.1. Se existir, retornar exceção de exemplo com nome já cadastrado 
5. Verificar existência de store já registrado com o cnpj informado 
5.1. Se existir, retornar exceção de exemplo com cnpj já cadastrado  
5. Salvar entidade
6. Converter a entidade no response
7. Retornar o response

## **Casos de teste**

| Onde | Teste | HTTP Status | Resultado |
| --- | --- | :---: | --- |
| Service | Quando atualiza a store | 200 | Ok |
| Service | Quando a store não existe | 404 | Not Found |
| Service | Quando atualiza store com nome de um exemplo existente | 400 | Bad Request |
| Service | Quando atualiza store com cnpj de uma store já registrado | 400 | Bad Request |
| DTO | Quando a quantidade de caracteres do atributo nome for maior que 255 |  400 | Bad Request |
| DTO | Quando a quantidade de caracteres do atributo cnpj for maior que 14 |  400 | Bad Request |

## **Exceções**

| HTTP Status | Chave | Mensagem | Message (en-US) |
|---|---|---|---|
| 404 | REGISTRO_NAO_ENCONTRADO | Nenhum registro encontrado para essa solicitação | No register found for this request |
| 400 | CNPJ_JA_CADASTRADO | CNPJ já cadastrado | CNPJ already registered |
| 400 | NOME_JA_CADASTRADO | Nome já cadastrado | Nome already registered |