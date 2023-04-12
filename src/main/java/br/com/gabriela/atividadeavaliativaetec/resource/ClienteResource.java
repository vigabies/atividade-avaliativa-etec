package br.com.gabriela.atividadeavaliativaetec.resource;

import br.com.gabriela.atividadeavaliativaetec.model.Cliente;
import br.com.gabriela.atividadeavaliativaetec.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("clientes")
public class ClienteResource {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/todos")
    public List<Cliente> listarTodosClientes(){
        return clienteRepository.findAll();
    }
}
