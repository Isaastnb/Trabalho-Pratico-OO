package br.edu.cafeteria.excecao;

public class PontosExcepction extends RuntimeException {
    public PontosExcepction() {
        System.out.println("Você não tem XP suficiente para realizar a compra.");
    }

    public PontosExcepction(String message) {
        super(message);
    }
}
