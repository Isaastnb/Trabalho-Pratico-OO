package br.edu.cafeteria.modelo;

import br.edu.cafeteria.excecao.EstoqueInsuficienteException;

public class Produto {
    private String codigo;
    private String nome;
    private float precoBase;
    private int quantidadeEstoque;

    public Produto(String codigo, String nome, float precoBase, int quantidadeEstoque) {
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

    public float getPrecoBase() {
        return precoBase;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreco(float precoBase) {
        this.precoBase = precoBase;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
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
