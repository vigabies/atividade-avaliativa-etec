package br.com.gabriela.atividadeavaliativaetec.repository.filter.Cliente;

import br.com.gabriela.atividadeavaliativaetec.model.Cliente;
import br.com.gabriela.atividadeavaliativaetec.repository.filter.ClienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteRepositoryQuery {
    public Page<Cliente> filtrar(ClienteFilter clienteFilter, Pageable pageable);
}
