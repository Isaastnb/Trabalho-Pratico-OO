package br.edu.cafeteria.modelo;

import br.edu.cafeteria.excecao.EstoqueInsuficienteException;

public class Produto {
    private String codigo;
    private String nome;
    private double precoBase;
    private int quantidadeEstoque;

    public Produto(String codigo, String nome, double precoBase, int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoBase = precoBase;
        this.quantidadeEstoque = quantidadeEstoque;
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

    public void reduzirEstoque(int quantidade) {
        if(quantidadeEstoque < quantidade){
            throw new EstoqueInsuficienteException("Estoque insuficiente para realizar adicionar ao carrinho."); 
        }
        quantidadeEstoque -= quantidade;
    }

    public void adicionarEstoque(int quantidade) {
        quantidadeEstoque += quantidade;
    }
}
