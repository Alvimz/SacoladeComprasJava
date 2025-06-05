package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Sacola {
    private final BigDecimal VALOR_MINIMO_COMPRA_DESCONTO = new BigDecimal("250.00");
    private final BigDecimal DESCONTO_X_VALOR = new  BigDecimal("10");
    private UUID idSacola = UUID.randomUUID();
    private List<ProdutosParaCompra> itens = new  ArrayList<>();
    private final Pessoa comprador;
    private BigDecimal valorCompra = BigDecimal.ZERO;

    public Sacola(Pessoa comprador) {
        this.comprador= comprador;
        
    }
    public Sacola(Pessoa comprador,List<ProdutosParaCompra> produtosParaCompras){
        this(comprador);
        if(!produtosParaCompras.isEmpty()){
            addSacola(produtosParaCompras);
        } 
    }

    public void addSacola(ProdutosParaCompra produto){
        itens.add(produto);
    }

    public void addSacola(ProdutosParaCompra ... produto){
        for(ProdutosParaCompra produtos:produto){
            itens.add(produtos);
        }
    }
    public void addSacola(List<ProdutosParaCompra> produtosParaCompras){
        for(ProdutosParaCompra produto:produtosParaCompras){
            itens.add(produto);
        }
    }
    

    public void comprar(){
        calculaValorTotal();
        if(getValorCompra().compareTo(BigDecimal.ZERO) > 0){
            if(getValorCompra().compareTo(VALOR_MINIMO_COMPRA_DESCONTO) > 0){
                System.out.println("Oba! Conseguimos descontos!");
                BigDecimal porcentagem = DESCONTO_X_VALOR.divide(BigDecimal.valueOf(100));
                BigDecimal desconto = getValorCompra().multiply(porcentagem);
                BigDecimal valorFinal = getValorCompra().subtract(desconto);
                System.out.println("Valor final da sua compra: " + valorFinal);
                return;
            }
            System.out.println("Infelizmente você não atingiu o mínimo para desconto: R$" + VALOR_MINIMO_COMPRA_DESCONTO);
            System.out.println("O valor da sua compra: R$"+ getValorCompra());
            return;
        }
        throw new  ExceptionInInitializerError("Coloque pelo menos um produto!");

    }

    public BigDecimal calculaValorTotal() {
        for(ProdutosParaCompra item: itens){
            valorCompra = valorCompra.add(item.getValor());
        }
        return valorCompra;
        
    }

   public BigDecimal getValorCompra(){
    return valorCompra;
   }
}
  
