# **Descrição:** Deleta uma store a partir do seu código de identificação.

**Description (en-US):** Delete an store by the identifier code

## **Arquitetura**

**Nome da Tag:** Store

**Path:** DELETE /api/store/{id}

**Nome do Resource:** br.com.saulo.store.web.StoreResource

**Nome do Serviço:** br.com.saulo.store.servicos.StoreServico

**Nome do Método:** deletarStore

## **Requisição**

|Parâmetro | Obrigatório | Descrição | Description (en-US) | Tipo parâmetro | Tipo de dados | Exemplo | Validador |
|---|:---:|---|---|:---:|:---:|---|---|
| id | Não | Código identificador da Store | Store identifier | Path | Long  | 1 |

### **Exemplo Request:**
```
/api/store/1
```
## **Resposta**

**Código status da resposta HTTP: 204 - No Content**

## **Documentos e referência**

**Tabelas:** Store

## **Detalhes de implementação**

**Pré-requisitos**
* Existir store para o id informado

**Fluxo de execução**

1. Consultar a store pelo id
2. Verificar se a store não é nulo  
2.1. Se for nulo, retornar exceção de registro não encontrado  
3. Remover o registro da store
4. Retornar o response

## **Casos de teste**

| Onde | Teste | HTTP Status | Resultado |
| --- | --- | :---: | --- |
| Service | Quando deleta a store | 204 | Ok |
| Service | Quando a store não existe | 404 | Not Found |

## **Exceções**

| HTTP Status | Chave | Mensagem | Message (en-US) |
|---|---|---|---|
| 404 | REGISTRO_NAO_ENCONTRADO | Nenhum registro encontrado para essa solicitação | No register found for this request |