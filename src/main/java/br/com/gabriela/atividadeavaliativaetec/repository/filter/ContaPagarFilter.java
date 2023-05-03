package br.com.gabriela.atividadeavaliativaetec.repository.filter;

import java.math.BigDecimal;
import java.util.Date;

public class ContaPagarFilter {
    private Date data;
    private Date datavenc;
    private BigDecimal valor;

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
}
