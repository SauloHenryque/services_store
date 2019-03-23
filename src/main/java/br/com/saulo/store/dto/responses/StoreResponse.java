package br.com.saulo.store.dto.responses;


import java.io.Serializable;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Response Store")
public class StoreResponse implements Serializable{

	private static final long serialVersionUID = 4192610937139207457L;
	
	/**
     * Código de Identificação.
     */
    @ApiModelProperty(value = "Identificação da Store", position = 1)
    private Long id;

    /**
     * Nome da store.
     */
    @ApiModelProperty(value = "Nome da Store", position = 2)
    private String nome;
    
    /**
     * Response cnpj
     */
    @ApiModelProperty(value = "CNPJ da Store", position = 3)
    private String cnpj;
}
