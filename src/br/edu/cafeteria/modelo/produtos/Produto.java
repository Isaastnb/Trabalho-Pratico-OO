package br.edu.cafeteria.modelo.produtos;

public class Produto {
    private String codigo;
    private String nome;
    private double precoBase;
    private int quantidadeEstoque;

    void reduzirEstoque(int quantidade) {
        quantidadeEstoque -= quantidade;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

}
