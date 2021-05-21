package model;

public class Pratos {
    private String nome;
    private String tipo;

    public Pratos(){

    }

    public Pratos(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public Pratos(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
