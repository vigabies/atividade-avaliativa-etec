package br.com.gabriela.atividadeavaliativaetec.repository;

import br.com.gabriela.atividadeavaliativaetec.model.ContaPagar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaPagarRepository extends JpaRepository<ContaPagar, Integer> {
}
