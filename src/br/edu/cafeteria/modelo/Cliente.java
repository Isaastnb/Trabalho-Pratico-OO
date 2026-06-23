package br.edu.cafeteria.modelo;

public abstract class Cliente {

    private String nome;
    private String cpf;
    private int saldoXP;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.saldoXP = 0;
    }

    public abstract void adicionarXP(double valorGasto);

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getSaldoXP() {
        return saldoXP;
    }

    protected void somarXP(int pontos) {
        this.saldoXP += pontos;
    }

    protected void subtrairXP(int pontos) {
        this.saldoXP -= pontos;
    }
}