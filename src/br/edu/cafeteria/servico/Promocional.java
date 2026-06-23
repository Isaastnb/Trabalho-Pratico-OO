package br.edu.cafeteria.servico;
import br.edu.cafeteria.modelo.venda.Pedido;

public interface Promocional {
    public void aplicarDesconto(Pedido pedido);
}
