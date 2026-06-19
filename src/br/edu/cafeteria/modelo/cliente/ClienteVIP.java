package br.edu.cafeteria.modelo.cliente;

public class ClienteVIP extends Cliente {
    // Cliente VIP ganha XP em dobro
    @Override
    public void ganharXP(int totalGasto) {
        super.ganharXP(totalGasto * 2);
    }

    public void resgatar(int precoTotal) {
        int xpNecessario = precoTotal / 10;

        if (this.obterXp() < xpNecessario) {
            // TODO mudar dps
            throw new IllegalStateException("XP insuficiente para resgatar o pedido.");
        }

        this.removerXp(xpNecessario);
    }
}
