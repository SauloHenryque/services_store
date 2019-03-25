package br.com.saulo.store.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.saulo.store.entidades.StoreEntidade;

@Repository
public interface StoreRepositorio extends JpaRepository<StoreEntidade, Long> {

	StoreEntidade findById(long id);

	boolean existsByNome(String nome);

	boolean existsByCnpj(String cnpj);

}
