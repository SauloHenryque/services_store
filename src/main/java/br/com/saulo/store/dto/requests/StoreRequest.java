package br.com.saulo.store.dto.requests;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(description = "Request Store")
public class StoreRequest implements Serializable{
	
	 private static final long serialVersionUID = 3589073168426445707L;

	 @ApiModelProperty(value = "Identificação da Store", position = 1)
	 private Long id;
	    
	 @ApiModelProperty(value = "Nome da Store", position = 2)
	 private String nome;
	 
	 @ApiModelProperty(value = "CNPJ da Store", position = 3)
	 private String cnpj;

}
