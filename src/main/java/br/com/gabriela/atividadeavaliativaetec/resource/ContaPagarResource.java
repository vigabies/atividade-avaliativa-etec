package br.com.gabriela.atividadeavaliativaetec.resource;


import br.com.gabriela.atividadeavaliativaetec.model.ContaPagar;
import br.com.gabriela.atividadeavaliativaetec.repository.ContaPagarRepository;
import br.com.gabriela.atividadeavaliativaetec.repository.filter.ContaPagarFilter;
import br.com.gabriela.atividadeavaliativaetec.repository.projections.ResumoConta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contapagar")
public class ContaPagarResource {
    @Autowired
    private ContaPagarRepository contaPagarRepository;

    @GetMapping("/todos")
    public List<ContaPagar> listarTodosContaPagar(){
        return contaPagarRepository.findAll();
    }

    @GetMapping()
    public Page<ResumoConta> pesquisar(ContaPagarFilter contaPagarFilter, Pageable pageable) {
        return contaPagarRepository.filtrar(contaPagarFilter, pageable);
    }
}
