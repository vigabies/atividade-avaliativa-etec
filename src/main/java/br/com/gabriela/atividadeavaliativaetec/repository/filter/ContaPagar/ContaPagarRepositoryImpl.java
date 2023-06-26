package br.com.gabriela.atividadeavaliativaetec.repository.filter.ContaPagar;

import br.com.gabriela.atividadeavaliativaetec.model.ContaPagar;
import br.com.gabriela.atividadeavaliativaetec.repository.filter.ContaPagarFilter;
import br.com.gabriela.atividadeavaliativaetec.repository.projections.ResumoConta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
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
    public Page<ResumoConta> filtrar(ContaPagarFilter contaPagarFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<ResumoConta> criteria = builder.createQuery(ResumoConta.class);
        Root<ContaPagar> root = criteria.from(ContaPagar.class);

        //select todos os campos q ta no filme
        criteria.select(builder.construct(ResumoConta.class
                , root.get("id")
                , root.get("data")
                , root.get("datavenc")
                , root.get("valor")
                , root.get("cliente").get("nome")
        ));

        Predicate[] predicates = criarRestricoes(contaPagarFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("data")));

        TypedQuery<ResumoConta> query = manager.createQuery(criteria);
        adicionarRestricoesDePaginacao(query, pageable);
        return new PageImpl<>(query.getResultList(), pageable, totalRegistro(contaPagarFilter));
    }

    private Long totalRegistro(ContaPagarFilter contaPagarFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<ContaPagar> root = criteria.from(ContaPagar.class);

        Predicate[] predicates = criarRestricoes(contaPagarFilter, builder, root);
        criteria.where(predicates);
        criteria.orderBy(builder.asc(root.get("data")));

        criteria.select(builder.count(root));
        return manager.createQuery(criteria).getSingleResult();
    }

    private void adicionarRestricoesDePaginacao(TypedQuery<ResumoConta> query, Pageable pageable) {
        int pageAtual = pageable.getPageNumber();
        int totalRegistroPage = pageable.getPageSize();
        int primeiroRegistroPage = pageAtual * totalRegistroPage;

        query.setFirstResult(primeiroRegistroPage);
        query.setMaxResults(totalRegistroPage);
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
