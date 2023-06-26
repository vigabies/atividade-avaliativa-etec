package br.com.gabriela.atividadeavaliativaetec.repository.projections;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ResumoConta {
    private Integer id;
    private LocalDate data;
    private LocalDate datavenc;
    private BigDecimal valor;

    public ResumoConta(Integer id, LocalDate data, LocalDate datavenc, BigDecimal valor) {
        this.id = id;
        this.data = data;
        this.datavenc = datavenc;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDate getDatavenc() {
        return datavenc;
    }

    public void setDatavenc(LocalDate datavenc) {
        this.datavenc = datavenc;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}

