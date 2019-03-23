#**Descrição:** Cadastra store.

**Description (en-US):** Save store.

## **Arquitetura**

**Nome da Tag:** store

**Path:** POST /api/store

**Nome do Resource:** br.com.saulo.store.web.StoreResource

**Nome do Serviço:** br.com.saulo.store.servicos.StoreServico

**Nome do Método:** salvarStore

## **Requisição**

### **Nome do Request:** br.com.saulo.store.dto.persists.StorePersist

|Parâmetro | Obrigatório | Descrição | Description (en-US) | Tipo parâmetro | Tipo de dados | Exemplo | Validador |
|---|:---:|---|---|:---:|:---:|---|---|
| nome | Sim | Nome da store | store name | Body | String | "teste" | Máximo: 255 |
| cnpj | Sim | CNPJ da store | CNPJ store | Body | String | "12345678912345" | Máximo: 14 |


### **Exemplo Request:**
```
/api/store
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
| id | Código identificador da store | Store identifier | Long | 1 | 
| nome | Nome da store | store name | String | "teste" | 
| cnpj | CNPJ store | CNPJ store | String | "12345678912345" |
 

**Código status da resposta HTTP: 201 - Created**

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

**Fluxo de execução**

1. Converter o objeto de persist na entidade store
2. Verificar existência de store já registrado com o nome informado  
2.1. Se existir, retornar exceção de exemplo com nome já cadastrado
3. Verificar existência de store já registrado com o cnpj informado 
3.1. Se existir, retornar exceção de exemplo com cnpj já cadastrado 
4. Salvar entidade
5. Converter a entidade no response
6. Retornar o response

## **Casos de teste**

| Onde | Teste | HTTP Status | Resultado |
| :---: | --- | :---: | --- |
| Service | Quando cadastra store | 201 | Ok |
| Service | Quando cadastra store com nome de uma store já registrado | 400 | Bad Request |
| Service | Quando cadastra store com cnpj de uma store já registrado | 400 | Bad Request |
| DTO | Quando a quantidade de caracteres do atributo cnpj for maior que 14 |  400 | Bad Request |
| DTO | Quando o atributo nome não existir | 400 | Bad Request |
| DTO | Quando o atributo cnpj não existir | 400 | Bad Request |

## **Exceções**

| HTTP Status | Chave | Mensagem | Message (en-US) |
|:---:|---|---|---|
| 400 | CNPJ_JA_CADASTRADO | CNPJ já cadastrado | CNPJ already registered |
| 400 | NOME_JA_CADASTRADO | Nome já cadastrado | Nome already registered |