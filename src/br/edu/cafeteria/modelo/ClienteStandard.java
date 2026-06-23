package br.edu.cafeteria.modelo;

public class ClienteStandard extends Cliente {
    // Cliente Standard ganha XP normalmente, sem multiplicadores
    @Override
    public void ganharXP(int totalGasto) {
        super.ganharXP(totalGasto);
    }
    
}
