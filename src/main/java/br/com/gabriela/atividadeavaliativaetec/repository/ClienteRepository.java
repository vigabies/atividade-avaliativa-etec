package br.com.gabriela.atividadeavaliativaetec.repository;

import br.com.gabriela.atividadeavaliativaetec.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
