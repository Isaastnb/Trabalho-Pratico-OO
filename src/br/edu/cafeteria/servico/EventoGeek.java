package br.edu.cafeteria.servico;
import br.edu.cafeteria.modelo.venda.Pedido;

public class EventoGeek implements Promocional {
    @Override
    public void aplicarDesconto(Pedido pedido) {
        // Implementação do desconto para o evento geek
        System.out.println("Aplicando desconto do evento geek no pedido.");
    }
    
}
