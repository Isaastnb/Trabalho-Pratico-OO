package br.edu.cafeteria.modelo.cliente;

public abstract class Cliente {
    private int xp;

    public void ganharXP(int quantidade) {}

    public int obterXp() {
        return this.xp;
    }

    public void removerXp(int quantidade) {
        this.xp -= quantidade;
    }
}
