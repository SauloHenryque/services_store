package br.com.saulo.store.dto.persists;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @NotNull(message = "Nome não pode ser nulo")
    @Size(min = 1, max = 255, message= "Nome deve ter entre 1 a 255 caracter")
    private String nome;
    
    /**
     * CNPJ
     */
    @ApiModelProperty(value = "CNPJ Store", position = 2)
    @NotNull(message = "CNPJ não pode ser nulo")
    @Size(min = 14, max = 14, message= "CNPJ deve ter 14 caracter")
    private String cnpj;

}
