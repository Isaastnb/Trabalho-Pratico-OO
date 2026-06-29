package br.edu.cafeteria.modelo;

import br.edu.cafeteria.excecao.EstoqueInsuficienteException;
import br.edu.cafeteria.servico.Promocional;

import java.util.ArrayList;

public class Pedido {
    private static final int DESCONTO_EVENTO_GEEK = 10; 

    private static int contadorComandas = 1;

    private int numeroComanda;
    private String atendente;
    private Cliente cliente;
    private ArrayList<ItemPedido> itens;

    private float total;

    public Pedido(String atendente, ArrayList<ItemPedido> itens, Cliente cliente) {
        this.numeroComanda = contadorComandas++;
        this.atendente = atendente;
        this.cliente = cliente;
        this.itens = itens;
    }

    public Pedido(String atendente, ArrayList<ItemPedido> itens) {
        this(atendente, itens, null);
    }
    
    public void adicionarItem(Produto p, int quantidade) throws EstoqueInsuficienteException {
        p.reduzirEstoque(quantidade);
        ItemPedido novoItem = new ItemPedido(p, quantidade);
        this.itens.add(novoItem);
    }
    
    public float calcularTotal(boolean isDiaEventoGeek) {
        float total = 0;

        for (ItemPedido item : itens) {
            Produto prod = item.getProduto();
            float subtotalItem = item.calcularSubtotal();

            if (isDiaEventoGeek && prod instanceof Promocional) {
                Promocional itemPromocional = (Promocional) prod;
                subtotalItem = itemPromocional.aplicarDesconto(DESCONTO_EVENTO_GEEK) * item.getQuantidade();
            }

            total += subtotalItem;
        }

        this.total = total;
        return total;
    }

    public void aplicarXP() {
        cliente.adicionarXP((int) total);
    }

    public void pagar(boolean pagarComXP) {
        if (cliente != null && pagarComXP && cliente instanceof ClienteVIP) {
            ClienteVIP clienteVIP = (ClienteVIP) cliente;
            if (clienteVIP.getSaldoXP() >= total) {
                clienteVIP.pagarComXP((int) total);
                System.out.println("Pedido pago com XP.");
            } else {
                System.out.println("Saldo de XP insuficiente. Pedido pago em dinheiro.");
            }
            
            return;
        }

        System.out.println("Pedido pago em dinheiro.");
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

    public ArrayList<ItemPedido> getItens() {
        return itens;
    }
}