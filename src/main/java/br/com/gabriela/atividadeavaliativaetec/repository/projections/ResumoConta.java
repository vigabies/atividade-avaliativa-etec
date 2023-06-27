package br.com.gabriela.atividadeavaliativaetec.repository.projections;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ResumoConta {
    private Integer id;
    private LocalDate data;
    private LocalDate datavenc;
    private BigDecimal valor;

    private String nome;

    public ResumoConta(Integer id, LocalDate data, LocalDate datavenc, BigDecimal valor, String nome) {
        this.id = id;
        this.data = data;
        this.datavenc = datavenc;
        this.valor = valor;
        this.nome = nome;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}


