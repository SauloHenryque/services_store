package br.com.saulo.store.dto.responses;

import java.io.Serializable;

import br.com.saulo.store.ultil.PageStore;
import io.swagger.annotations.ApiModel;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@ApiModel(description = "Response Store", discriminator = "Response Store")
public class PageStoreResponse extends PageStore<StoreResponse> implements Serializable {

    private static final long serialVersionUID = -4679776107027097057L;

    public PageStoreResponse(PageStore<StoreResponse> p) {
        super(p.getNumber(), p.size, p.totalPages, p.numberOfElements, p.totalElements, p.firstPage, p.hasPreviousPage, p.hasNextPage, p.hasContent, p.first, p.last, p.nextPage, p.previousPage, p.content);
    }
}