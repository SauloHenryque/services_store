package br.com.saulo.store.dto.requests;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(description = "{{{store_request_description}}}")
public class StoreRequest implements Serializable{
	
	 private static final long serialVersionUID = 3589073168426445707L;

	 @ApiModelProperty(value = "{{{store_request_id_value}}}", position = 1)
	 private Long id;
	    
	 @ApiModelProperty(value = "{{{store_request_nome_value}}}", position = 2)
	 private String nome;
	 
	 @ApiModelProperty(value = "{{{store_request_cnpj_value}}}", position = 3)
	 private String cnpj;

}
