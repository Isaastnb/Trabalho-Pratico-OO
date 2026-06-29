package br.edu.cafeteria.app.menu;

import java.util.ArrayList;
import java.util.Scanner;

import br.edu.cafeteria.modelo.Cliente;
import br.edu.cafeteria.modelo.ClienteVIP;
import br.edu.cafeteria.modelo.ItemPedido;
import br.edu.cafeteria.modelo.Pedido;
import br.edu.cafeteria.modelo.Produto;
import br.edu.cafeteria.servico.ServicoClientes;
import br.edu.cafeteria.servico.ServicoProdutos;

public class MenuPedidos extends Menu {
    private static final String MENU_NAME = "Menu de Pedidos";

    @Override
    public void exibirComandos() {
        System.out.println("criar <atendente> [cliente]: Criar novo pedido");
        System.out.println("voltar: Voltar ao menu inicial");
        super.exibirComandos();
    }

    @Override
    public void tratarComando(String comando, String[] argumentos) {
        switch (comando) {
            case "criar":
                comandoCriar(argumentos);
                return;
            case "voltar":
                super.setProximoMenu(new MenuInicial());
                return;
        }

        super.tratarComando(comando, argumentos);
    }

    private void comandoCriar(String[] argumentos) {
        if (argumentos.length < 1) {
            System.out.println("Uso: criar <atendente> [cliente]");
            return;
        }

        String atendente = argumentos[0];
        Cliente cliente = argumentos.length > 1 ? ServicoClientes.buscar(argumentos[1]) : null;

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite os itens do pedido (código quantidade), ou 'fim' para encerrar:");
        String linha;

        ArrayList<ItemPedido> itens = new ArrayList<>();

        while (!(linha = scanner.nextLine()).equalsIgnoreCase("fim")) {
            String[] partes = linha.split(" ");
            if (partes.length != 2) {
                System.out.println("Formato inválido. Use: <código> <quantidade>");
                continue;
            }

            Produto produto = ServicoProdutos.buscar(partes[0]);

            if (produto == null) {
                System.out.println("Produto não encontrado.");
                continue;
            }

            int quantidade;
            try {
                quantidade = Integer.parseInt(partes[1]);
            } catch (NumberFormatException e) {
                System.out.println("Quantidade inválida. Use um número inteiro.");
                continue;
            }

            itens.add(new ItemPedido(produto, quantidade));
        }

        System.out.print("É dia do evento geek? (true/false): ");
        boolean isDiaEventoGeek = scanner.nextBoolean();

        boolean pagarComXP = false;
        if (cliente != null && cliente instanceof ClienteVIP) {
            System.out.print("Deseja pagar com XP? (true/false): ");
            pagarComXP = scanner.nextBoolean();
        }

        Pedido pedido = new Pedido(atendente, itens, cliente);

        float total = pedido.calcularTotal(isDiaEventoGeek);
        pedido.pagar(pagarComXP);
        pedido.aplicarXP();

        System.out.println("Pedido criado com sucesso!");
        System.out.println("Comanda: " + pedido.getNumeroComanda());
        System.out.println("Total: " + total);
    }

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }
}
