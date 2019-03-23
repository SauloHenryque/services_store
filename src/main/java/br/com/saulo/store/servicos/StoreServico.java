package br.com.saulo.store.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import br.com.saulo.store.entidades.StoreEntidade;
import br.com.saulo.store.repositorios.StoreRepositorio;
import lombok.Data;

@Data
@Service
public class StoreServico {
	
    
    @Autowired
    private StoreRepositorio storeRepositorio;
	
	/**
	 * Método responsável pela listagem das store.
	 * 
	 * @param storeEntidade <br/>
	 *                   Objeto que representa a requisição do serviço
	 *                   {@link StoreEntidade}
	 * 
	 * @return {@link List(storeEntidade)}
	 */

    public List<StoreEntidade> listarStore(StoreEntidade storeEntidade) {

    	return storeRepositorio.findAll(Example.of(storeEntidade));

    }

	/**
	 * Método responsável pela criação da store.
	 *  
	 * @param storeEntidade <br/>
	 *                   Objeto que representa a requisição
	 *                   {@link storeEntidade}
	 * 
	 * @return {@link StoreEntidade}
	 */
	public StoreEntidade salvarStore(StoreEntidade storeEntidade) {
		
        return storeRepositorio.save(storeEntidade);

	}
	
	
	/**
	 * Método responsável pela edição da store.
	 *  
	 * @param storeEntidade <br/>
	 *                   Objeto que representa a requisição
	 *                   {@link storeEntidade}
	 * 
	 * @return {@link StoreEntidade}
	 */
	public StoreEntidade atualizarStore(StoreEntidade storeEntidade) {
		
		return storeRepositorio.save(storeEntidade);
	} 
	
	
	/**
	 * Método responsável por deletar uma store
	 *  
	 * @param id <br/>
	 * id da store a ser deletada
	 * 
	 */
    public void deletarStore(long id) {
    	
    	StoreEntidade storeEntidade = storeRepositorio.findById(id);
    	storeRepositorio.delete(storeEntidade);
    }




}
