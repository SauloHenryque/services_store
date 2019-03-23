package br.com.saulo.store.dto.persists;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "store_persist_description")
public class StorePersist implements Serializable {
	
	private static final long serialVersionUID = -7329881749188627883L;
	
    /**
     * Nome store
     */
    @ApiModelProperty(value = "Nome da Store", position = 1)
    @NotNull
    private String nome;
    
    /**
     * CNPJ
     */
    @ApiModelProperty(value = "CNPJ Store", position = 2)
    @NotNull
    private String cnpj;

}
