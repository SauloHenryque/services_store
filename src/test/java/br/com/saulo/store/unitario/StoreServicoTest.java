package br.com.saulo.store.unitario;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.Lists;

import br.com.saulo.store.dto.requests.StoreRequest;
import br.com.saulo.store.entidades.StoreEntidade;
import br.com.saulo.store.exception.BadRequestException;
import br.com.saulo.store.exception.NotFoundException;
import br.com.saulo.store.repositorios.StoreRepositorio;
import br.com.saulo.store.servicos.StoreServico;
import junit.framework.TestCase;

@RunWith(SpringRunner.class)
public class StoreServicoTest {
 
	 @InjectMocks
     private StoreServico storeServicoMock;
	
     @Mock
     private StoreRepositorio storeRepositorio;
     
     @Mock
     private StoreEntidade storeEntidade;
     
     private StoreRequest storeRequest;

     @Before
     public void setup() {

          MockitoAnnotations.initMocks(this);
          storeRequest = new StoreRequest();
     }
     
     @Test
     public void salvarStore(){
    	 
    	 StoreEntidade	storeEntidadeNovo		 = new StoreEntidade();
    	 
    	 storeEntidadeNovo.setNome("Nome Teste");
    	 storeEntidadeNovo.setCnpj("12345678985234");
    	 
         Mockito.when(storeRepositorio.existsByNome("Teste")).thenReturn(false);
         Mockito.when(storeRepositorio.existsByCnpj("12345678912345")).thenReturn(false);
         Mockito.when(storeRepositorio.save(Mockito.any(StoreEntidade.class))).thenReturn(storeEntidade);

         StoreEntidade storeEntidadeCadastrado = storeServicoMock.salvarStore(storeEntidadeNovo);

         testCase(storeEntidade, storeEntidadeCadastrado);
     }
     
     @Test(expected = BadRequestException.class)
     public void salvarStoreNomeRepetido(){
    	 
    	 StoreEntidade	storeEntidadeNovo		 = new StoreEntidade();
    	 
    	 storeEntidadeNovo.setNome("Nome Teste");
    	 storeEntidadeNovo.setCnpj("12345678985234");
    	 
         Mockito.when(storeRepositorio.existsByNome("Teste")).thenReturn(true);
         Mockito.when(storeRepositorio.existsByCnpj("12345678912345")).thenReturn(false);
         Mockito.when(storeRepositorio.save(Mockito.any(StoreEntidade.class))).thenReturn(storeEntidade);

         storeServicoMock.salvarStore(storeEntidadeNovo);
     }
     
     @Test(expected = BadRequestException.class)
     public void salvarStoreCnpjRepetido(){
    	 
    	 StoreEntidade	storeEntidadeNovo		 = new StoreEntidade();
    	 
    	 storeEntidadeNovo.setNome("Nome Teste");
    	 storeEntidadeNovo.setCnpj("12345678985234");
    	 
         Mockito.when(storeRepositorio.existsByNome("Teste")).thenReturn(false);
         Mockito.when(storeRepositorio.existsByCnpj("12345678912345")).thenReturn(true);
         Mockito.when(storeRepositorio.save(Mockito.any(StoreEntidade.class))).thenReturn(storeEntidade);

         storeServicoMock.salvarStore(storeEntidadeNovo);
     }
     
    @Test
    public void atualizarStore(){
    	 
    	 StoreEntidade	storeEntidadeNovo		 = new StoreEntidade();
    	 
    	 storeEntidadeNovo.setId(1L);
    	 storeEntidadeNovo.setNome("Nome Teste");
    	 storeEntidadeNovo.setCnpj("12345678985234");
    	 
    	 Mockito.when(storeRepositorio.existsById(1L)).thenReturn(true);
         Mockito.when(storeRepositorio.existsByNomeAndIdNotIn("Teste", 1L)).thenReturn(false);
         Mockito.when(storeRepositorio.existsByCnpjAndIdNotIn("12345678912345", 1L)).thenReturn(false);
         Mockito.when(storeRepositorio.save(Mockito.any(StoreEntidade.class))).thenReturn(storeEntidade);

         StoreEntidade storeEntidadeAtualizado = storeServicoMock.atualizarStore(storeEntidadeNovo);

         testCase(storeEntidade, storeEntidadeAtualizado);
         TestCase.assertEquals(storeEntidade.getId(), storeEntidadeAtualizado.getId());
    }
    
    @Test(expected = NotFoundException.class)
    public void atualizarStoreNaoEncontrado(){
   	 
   	 	StoreEntidade	storeEntidadeNovo		 = new StoreEntidade();
   	 
   	 	storeEntidadeNovo.setId(1L);
   	 	storeEntidadeNovo.setNome("Nome Teste");
   	 	storeEntidadeNovo.setCnpj("12345678985234");
   	 
   	 	Mockito.when(storeRepositorio.existsById(1L)).thenReturn(false);
   	 	Mockito.when(storeRepositorio.existsByNomeAndIdNotIn("Teste", 1L)).thenReturn(false);
   	 	Mockito.when(storeRepositorio.existsByCnpjAndIdNotIn("12345678912345", 1L)).thenReturn(false);
   	 	Mockito.when(storeRepositorio.save(Mockito.any(StoreEntidade.class))).thenReturn(storeEntidade);

        storeServicoMock.atualizarStore(storeEntidadeNovo);
    }
    
    @Test(expected = BadRequestException.class)
    public void atualizarStoreNomeRepetido(){
   	 
   	 	StoreEntidade	storeEntidadeNovo		 = new StoreEntidade();
   	 
   	 	storeEntidadeNovo.setId(1L);
   	 	storeEntidadeNovo.setNome("Nome Teste");
   	 	storeEntidadeNovo.setCnpj("12345678985234");
   	 
   	 	Mockito.when(storeRepositorio.existsById(1L)).thenReturn(true);
   	 	Mockito.when(storeRepositorio.existsByNomeAndIdNotIn("Teste", 1L)).thenReturn(true);
   	 	Mockito.when(storeRepositorio.existsByCnpjAndIdNotIn("12345678912345", 1L)).thenReturn(false);
   	 	Mockito.when(storeRepositorio.save(Mockito.any(StoreEntidade.class))).thenReturn(storeEntidade);

        storeServicoMock.atualizarStore(storeEntidadeNovo);
    }
    
    @Test(expected = BadRequestException.class)
    public void atualizarStoreCnpjRepetido(){
   	 
   	 	StoreEntidade	storeEntidadeNovo		 = new StoreEntidade();
   	 
   	 	storeEntidadeNovo.setId(1L);
   	 	storeEntidadeNovo.setNome("Nome Teste");
   	 	storeEntidadeNovo.setCnpj("12345678985234");
   	 
   	 	Mockito.when(storeRepositorio.existsById(1L)).thenReturn(true);
   	 	Mockito.when(storeRepositorio.existsByNomeAndIdNotIn("Teste", 1L)).thenReturn(false);
   	 	Mockito.when(storeRepositorio.existsByCnpjAndIdNotIn("12345678912345", 1L)).thenReturn(true);
   	 	Mockito.when(storeRepositorio.save(Mockito.any(StoreEntidade.class))).thenReturn(storeEntidade);

        storeServicoMock.atualizarStore(storeEntidadeNovo);
    }
    
    @Test()
    public void deletarStore(){
   	 
   	 	Mockito.when(storeRepositorio.existsById(1L)).thenReturn(true);
   	 	Mockito.when(storeRepositorio.findById(1L)).thenReturn(storeEntidade);

        storeServicoMock.deletarStore(1L);
    }
    
    @Test(expected = NotFoundException.class)
    public void deletarStoreInexistente(){
   	 
   	 	Mockito.when(storeRepositorio.existsById(1L)).thenReturn(false);
   	 	Mockito.when(storeRepositorio.findById(1L)).thenReturn(storeEntidade);

        storeServicoMock.deletarStore(1L);
    }


	private static void testCase(StoreEntidade storeEntidade, StoreEntidade storeEntidadeCadastrado) {
         
         TestCase.assertNotNull(storeEntidade);
         TestCase.assertEquals(storeEntidade.getNome(), storeEntidadeCadastrado.getNome());
         TestCase.assertEquals(storeEntidade.getCnpj(), storeEntidadeCadastrado.getCnpj());
         
    }
     
    @Test
    public void testListar() {

    	StoreEntidade	storeEntidadeNovo		 = new StoreEntidade();
	 
   	 	storeEntidadeNovo.setNome("Nome Teste");
   	 	storeEntidadeNovo.setCnpj("12345678985234");
    	
        List<StoreEntidade> listaStoreEntidade  = Lists.newArrayList(storeEntidade);
    	 	
        Mockito.when(storeRepositorio.findAll(Example.of(storeEntidadeNovo))).thenReturn(listaStoreEntidade);
    	 
        List<StoreEntidade> listStoreEntidade = storeServicoMock.listarStore(storeEntidade);
       
    	assertNotNull(listStoreEntidade);
        

    }

}
