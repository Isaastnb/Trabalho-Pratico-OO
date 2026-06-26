package br.edu.cafeteria.app.menu;

import java.util.ArrayList;

import br.edu.cafeteria.modelo.Cliente;
import br.edu.cafeteria.modelo.ClienteStandard;
import br.edu.cafeteria.modelo.Clientes;

public class MenuClientes extends Menu {
    private static final String MENU_NAME = "Menu de Clientes";

    @Override
    public void exibirComandos() {
        System.out.println("adicionar <cpf> <nome>: Adicionar cliente");
        System.out.println("listar: Listar clientes");
        System.out.println("buscar <cpf>: Buscar cliente pelo CPF");
        System.out.println("remover <cpf>: Remover cliente");
        System.out.println("voltar: Voltar ao menu inicial");
        super.exibirComandos();
    }

    @Override
    public void tratarComando(String comando, String[] argumentos) {
        switch (comando) {
            case "adicionar":
                if (argumentos.length < 2) {
                    System.out.println("Uso: adicionar <cpf> <nome>");
                    return;
                }

                String cpf = argumentos[0];
                String nome = argumentos[1];

                Clientes.adicionarCliente(cpf, new ClienteStandard(cpf, nome));
                return;

            case "listar":
                ArrayList<Cliente> clientes = Clientes.listarClientes();

                if (clientes.isEmpty()) {
                    System.out.println("Nenhum cliente cadastrado.");
                    return;
                }

                System.out.println("Clientes:");
                for (Cliente cliente : clientes) {
                    System.out.printf("CPF: %s, Nome: %s%n", cliente.getCpf(), cliente.getNome());
                }
                return;
            case "buscar":
                if (argumentos.length < 1) {
                    System.out.println("Uso: buscar <cpf>");
                    return;
                }

                Cliente cliente = Clientes.getCliente(argumentos[0]);
                if (cliente != null) {
                    System.out.printf("CPF: %s, Nome: %s%n", cliente.getCpf(), cliente.getNome());
                } else {
                    System.out.println("Cliente não encontrado.");
                }
                return;
            case "remover":
                if (argumentos.length < 1) {
                    System.out.println("Uso: remover <cpf>");
                    return;
                }

                Clientes.removerCliente(argumentos[0]);
                System.out.println("Cliente removido.");
                return;
            case "voltar":
                super.setProximoMenu(new MenuInicial());
                return;
        }

        super.tratarComando(comando, argumentos);
    }

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }
}
