package br.com.saulo.store.dto.requests;

import java.io.Serializable;
import javax.validation.constraints.Size;

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
	 @Size(min = 1, max = 255, message= "Nome deve ter entre 1 a 255 caracter")
	 private String nome;
	 
	 @Size(min = 14, max = 14, message= "CNPJ deve ter 14 caracter")
	 @ApiModelProperty(value = "CNPJ da Store", position = 3)
	 private String cnpj;

}
