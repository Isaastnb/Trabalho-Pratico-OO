package br.edu.cafeteria.modelo;

import br.edu.cafeteria.excecao.EstoqueInsuficienteException;
import br.edu.cafeteria.servico.Promocional;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private static int contadorComandas = 1;

    private int numeroComanda;
    private String atendente;
    private Cliente cliente;
    private List<ItemPedido> itens;

    public Pedido(String atendente, Cliente cliente) {
        this.numeroComanda = contadorComandas++;
        this.atendente = atendente;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }
    
    public void adicionarItem(Produto p, int quantidade) throws EstoqueInsuficienteException {
        p.reduzirEstoque(quantidade);
        ItemPedido novoItem = new ItemPedido(p, quantidade);
        this.itens.add(novoItem);
    }

    /*public void adicionarItem(Produto p) throws EstoqueInsuficienteException {
        adicionarItem(p, 1);
    }*/

    
    
    public double calcularTotal(boolean isDiaEventoGeek) {
        double total = 0;

        for (ItemPedido item : itens) {
            Produto prod = item.getProduto();
            double subtotalItem = item.calcularSubtotal();

            if (isDiaEventoGeek && prod instanceof Promocional) {
                Promocional itemPromocional = (Promocional) prod;
                subtotalItem = itemPromocional.aplicarDesconto(10) * item.getQuantidade();
            }

            total += subtotalItem;
        }

        return total;
    }

    public int getNumeroComanda() {
        return numeroComanda;
    }

    public String getAtendente() {
        return atendente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }


}