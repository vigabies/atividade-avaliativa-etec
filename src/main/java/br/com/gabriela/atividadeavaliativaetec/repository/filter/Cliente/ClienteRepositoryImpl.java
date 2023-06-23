package br.com.gabriela.atividadeavaliativaetec.repository.filter.Cliente;

import br.com.gabriela.atividadeavaliativaetec.model.Cliente;
import br.com.gabriela.atividadeavaliativaetec.repository.filter.ClienteFilter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryImpl implements ClienteRepositoryQuery{
    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Cliente> filtrar(ClienteFilter clienteFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Cliente> criteria = builder.createQuery(Cliente.class);
        Root<Cliente> root = criteria.from(Cliente.class);

        Predicate[] predicates = criarRestricoes(clienteFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("nomecliente")));

        TypedQuery<Cliente> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query, pageable);
    }

    private void adicionarRestricoesDePaginacao(TypedQuery<Cliente> query, Pageable pageable) {
    }

    private Predicate[] criarRestricoes(ClienteFilter clienteFilter, CriteriaBuilder builder, Root<Cliente> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(clienteFilter.getNome())) {
            predicates.add(builder.like(builder.lower(root.get("nomecliente")),
                    "%" + clienteFilter.getNome().toLowerCase() + "%"));
        }
        return predicates.toArray((new Predicate[predicates.size()]));
    }
}
