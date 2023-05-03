package br.com.gabriela.atividadeavaliativaetec.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table (name="contapagar")
public class ContaPagar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date data;
    private Date datavenc;
    private BigDecimal valor;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="idcliente")
    private Cliente cliente;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getDatavenc() {
        return datavenc;
    }

    public void setDatavenc(Date datavenc) {
        this.datavenc = datavenc;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaPagar that = (ContaPagar) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
