package br.com.gabriela.atividadeavaliativaetec.repository.filter.ContaPagar;

import br.com.gabriela.atividadeavaliativaetec.model.ContaPagar;
import br.com.gabriela.atividadeavaliativaetec.repository.filter.ContaPagarFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContaPagarRepositoryQuery {
    public Page<ContaPagar> filtrar(ContaPagarFilter contaPagarFilter, Pageable pageable);

}
