package br.com.gabriela.atividadeavaliativaetec.repository.filter.ContaPagar;

import br.com.gabriela.atividadeavaliativaetec.model.ContaPagar;
import br.com.gabriela.atividadeavaliativaetec.repository.filter.ContaPagarFilter;
import br.com.gabriela.atividadeavaliativaetec.repository.projections.ResumoConta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContaPagarRepositoryQuery {
    public Page<ResumoConta> filtrar(ContaPagarFilter contaPagarFilter, Pageable pageable);
}
