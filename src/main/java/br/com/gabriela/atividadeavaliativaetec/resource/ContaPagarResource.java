package br.com.gabriela.atividadeavaliativaetec.resource;


import br.com.gabriela.atividadeavaliativaetec.model.ContaPagar;
import br.com.gabriela.atividadeavaliativaetec.repository.ContaPagarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("contapagar")
public class ContaPagarResource {
    @Autowired
    private ContaPagarRepository contaPagarRepository;

    @GetMapping("/todos")
    public List<ContaPagar> listarTodosContaPagar(){
        return contaPagarRepository.findAll();
    }
}
