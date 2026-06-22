package br.edu.cafeteria.excecao;

public class EstoqueExcepction extends RuntimeException {
    public EstoqueExcepction() {
        System.out.println("Estoque insuficiente no momento.");
    }

    public EstoqueExcepction(String message) {
        super(message);
    }
    
    
}
