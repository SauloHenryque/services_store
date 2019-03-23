# **Descrição:** Lista as store existentes.

**Description (en-US):** List the existent store.

## **Arquitetura**

**Nome da Tag:** Store

**Path:** GET /api/store

**Nome do Resource:** br.com.saulo.store.web.StoreResource

**Nome do Serviço:** br.com.saulo.store.servicos.StoreServico

**Nome do Método:** listarStore

## **Requisição**

### **Nome do Request:** br.com.saulo.store.dto.request.StoreRequest

|Parâmetro | Obrigatório | Descrição | Description (en-US) | Tipo parâmetro | Tipo de dados | Exemplo | Validador |
|---|:---:|---|---|:---:|:---:|---|---|
| nome | Não | Nome da Store | Store name | Query | String | "teste" | MAX(255) |
| cnpj | Não | CNPJ da Store | CNPJ Store | Query | String | "12345678912345" | MAX(14)|

### **Exemplo Request:**
```
/api/store
/api/store?nome=teste
/api/store?cnpj=12345678912345
```

## **Resposta**

### **Nome do Response:** br.com.saulo.store.dto.responses.StoreResponse

|Parâmetro | Descrição | Description (en-US) | Tipo de dados | Exemplo | Ordenação |
|---|---|---|:---:|---|:---:|
| id | Código identificador da store | store identifier | Long | 1 | 
| nome | Nome da store | store name | String | "teste" | 
| cnpj | CNPJ store | CNPJ store | String | "12345678912345" |


**Código status da resposta HTTP: 200 -  OK**

### **Exemplo Response:**
```json
{
    {
      "id": 1,
      "nome": "Teste 1",
      "cnpj": "12345678912348"
    },
    {
      "id": 2,
      "nome": "Teste 2",
      "cnpj": "12345678912345"
    }
}
```

## **Documentos e referência**

**Tabelas:** store

## **Detalhes de implementação**

**Fluxo de execução**

1. Converter o objeto de request na entidade store
2. Realizar a consulta
3. Retorna o List StoreEntidade

## **Casos de teste**
| Onde | Teste | HTTP Status | Resultado |
| :---: | --- | :---: | --- |
| Service | Quando retorna store  | 200 | OK |
| Service | Quando não encontra a store informado no parâmetro | 200 | Ok |
| DTO | Quando o atributo nome for maior que 255 caracteres | 400 | BadRequest |
| DTO | Quando o atributo cnpj for maior que 14 caracteres | 400 | BadRequest |
