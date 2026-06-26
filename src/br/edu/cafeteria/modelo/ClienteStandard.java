package br.edu.cafeteria.modelo;

public class ClienteStandard extends Cliente {
    // Cliente Standard ganha XP normalmente, sem multiplicadores
    public ClienteStandard(String nome, String cpf) {
        super(nome, cpf);
    }
    
    @Override
    public void adicionarXP(double valorGasto) {
        int pontos = (int) valorGasto;
        somarXP(pontos);
    }
}
