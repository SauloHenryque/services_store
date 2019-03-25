package br.com.saulo.store.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.saulo.store.dto.persists.StorePersist;
import br.com.saulo.store.dto.requests.StoreRequest;
import br.com.saulo.store.dto.responses.StoreResponse;
import br.com.saulo.store.entidades.StoreEntidade;
import br.com.saulo.store.servicos.StoreServico;
import br.com.saulo.store.ultil.GenericConvert;
import io.swagger.annotations.Api;

@RestController
@Api(tags = "store")
@RequestMapping(value = "/api/store", produces = MediaType.APPLICATION_JSON_VALUE)
public class StoreResource {
	
	 	@Autowired
		private StoreServico lojaServico;
		
	 	@PostMapping
	    public ResponseEntity<?> salvar(@RequestBody @Valid StorePersist request) {

			StoreEntidade storeEntidade = GenericConvert.convertModelMapper(request, StoreEntidade.class);
			storeEntidade 				= lojaServico.salvarStore(storeEntidade);
			StoreResponse response 		= GenericConvert.convertModelMapper(storeEntidade, StoreResponse.class);

			return ResponseEntity.status(HttpStatus.CREATED).body(response);
	    }
		
		@GetMapping
	    public ResponseEntity<?> listar(@Valid StoreRequest lojaRequest) {
			
			StoreEntidade lojaEntidade = GenericConvert.convertModelMapper(lojaRequest, StoreEntidade.class);	
			return ResponseEntity.status(HttpStatus.OK).body(lojaServico.listarStore(lojaEntidade));
	    }
		
		@PutMapping("/{id}")
	    public ResponseEntity<?> atualizar(@PathVariable("id") long id, @RequestBody @Valid StorePersist request ) {
			
			StoreEntidade lojaEntidade 	= GenericConvert.convertModelMapper(request, StoreEntidade.class);
			lojaEntidade.setId(id);
			
			lojaEntidade 				= lojaServico.atualizarStore(lojaEntidade);
			StoreResponse response 		= GenericConvert.convertModelMapper(lojaEntidade, StoreResponse.class);

			return ResponseEntity.status(HttpStatus.OK).body(response);
	    }
		
		@DeleteMapping("/{id}")
	    public ResponseEntity<?> deletar(@PathVariable("id") long id) {
			
	        lojaServico.deletarStore(id);
	        return ResponseEntity.ok(HttpStatus.OK);
	    }

}
