package br.com.gabriela.atividadeavaliativaetec.repository.filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class ContaPagarFilter {

    //como é data tem que formatar
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate data;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate datavenc;
    private BigDecimal valor;

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
