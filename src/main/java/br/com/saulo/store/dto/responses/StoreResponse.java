package br.com.saulo.store.dto.responses;


import java.io.Serializable;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "{{{store_response_description}}}")
public class StoreResponse implements Serializable{

	private static final long serialVersionUID = 4192610937139207457L;
	
	/**
     * Código de Identificação.
     */
    @ApiModelProperty(value = "{{{store_response_id_value}}}", position = 1)
    private Long id;

    /**
     * Nome da store.
     */
    @ApiModelProperty(value = "{{{store_response_nome_value}}}", position = 2)
    private String nome;
    
    /**
     * Response cnpj
     */
    @ApiModelProperty(value = "{{{store_response_cnpj_value}}}", position = 3)
    private String cnpj;
}
