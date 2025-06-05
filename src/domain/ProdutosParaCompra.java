package domain;

import java.math.BigDecimal;

public class ProdutosParaCompra {
    private String nome;
    private final BigDecimal valor;

    public ProdutosParaCompra(String nome, double valor) {
        this.nome = nome;
        this.valor = BigDecimal.valueOf(valor);
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }


}
