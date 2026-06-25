package br.edu.cafeteria.modelo;

import br.edu.cafeteria.excecao.PontosInsuficientesException;

public class ClienteVIP extends Cliente {

    private static final int TAXA_CONVERSAO_XP = 10;

    public ClienteVIP(String nome, String cpf) {
        super(nome, cpf);
    }

    @Override
    public void adicionarXP(double valorGasto) {
        int pontos = (int) valorGasto * 2;
        somarXP(pontos);
    }

    public void pagarComXP(double valorCompra) throws PontosInsuficientesException {
        int pontosNecessarios = (int) (valorCompra * TAXA_CONVERSAO_XP);

        if (getSaldoXP() < pontosNecessarios) {
            throw new PontosInsuficientesException("Saldo de XP insuficiente. Necessário: " + pontosNecessarios);
        }

        subtrairXP(pontosNecessarios);
    }
}   