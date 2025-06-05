
import domain.Pessoa;
import domain.ProdutosParaCompra;
import domain.Sacola;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        Pessoa caio = new Pessoa("Caio Estrada");
        ProdutosParaCompra computador = new ProdutosParaCompra("Televisão 50'", 1999.99);
        Sacola caioSacola = new Sacola(caio,List.of(computador));
        //Sacola caioSacola = new Sacola(caio);
        //caioSacola.addSacola(computador);
        //caioSacola.comprar();
    }
}
