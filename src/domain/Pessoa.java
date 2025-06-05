package domain;

public class Pessoa {
    public String nome;
    private final Sacola sacolaDeCompras;

    public Pessoa(Sacola sacolaDeCompras,String nome) {
        this.sacolaDeCompras = sacolaDeCompras;
        this.nome = nome;

    }

    public Pessoa(String nome){
        this(null,nome);
    }

 // Podemos criar uma pessoa com ousem uma sacola de comrpas!
    
}
