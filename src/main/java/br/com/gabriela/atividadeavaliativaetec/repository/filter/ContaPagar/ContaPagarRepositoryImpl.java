package br.com.gabriela.atividadeavaliativaetec.repository.filter.ContaPagar;

import br.com.gabriela.atividadeavaliativaetec.model.ContaPagar;
import br.com.gabriela.atividadeavaliativaetec.repository.filter.ContaPagarFilter;
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

public class ContaPagarRepositoryImpl implements ContaPagarRepositoryQuery{
    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<ContaPagar> filtrar(ContaPagarFilter contaPagarFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<ContaPagar> criteria = builder.createQuery(ContaPagar.class);
        Root<ContaPagar> root = criteria.from(ContaPagar.class);

        Predicate[] predicates = criarRestricoes(contaPagarFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("data")));

        TypedQuery<ContaPagar> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query, pageable);

    }

    private void adicionarRestricoesDePaginacao(TypedQuery<ContaPagar> query, Pageable pageable) {
    }

    private Predicate[] criarRestricoes(ContaPagarFilter contaPagarFilter, CriteriaBuilder builder, Root<ContaPagar> root) {
        List<Predicate> predicates = new ArrayList<>();

        //maior que a data ou igual
        if(contaPagarFilter.getData() != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("data"), contaPagarFilter.getData()));
        }

        //menor que a data ou igual
        if(contaPagarFilter.getData() != null) {
            predicates.add(builder.lessThanOrEqualTo(root.get("data"), contaPagarFilter.getData()));
        }

        //maior que a data ou igual
        if(contaPagarFilter.getDatavenc() != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get("datavenc"), contaPagarFilter.getDatavenc()));
        }

        //menor que a data ou igual
        if(contaPagarFilter.getDatavenc() != null) {
            predicates.add(builder.lessThanOrEqualTo(root.get("datavenc"), contaPagarFilter.getDatavenc()));
        }

            return predicates.toArray((new Predicate[predicates.size()]));
    }
}
