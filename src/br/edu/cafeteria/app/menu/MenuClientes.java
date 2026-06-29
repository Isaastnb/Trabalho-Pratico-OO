package br.edu.cafeteria.app.menu;

import java.util.ArrayList;

import br.edu.cafeteria.modelo.Cliente;
import br.edu.cafeteria.servico.ServicoClientes;

public class MenuClientes extends Menu {
    private static final String MENU_NAME = "Menu de Clientes";

    @Override
    public void exibirComandos() {
        System.out.println("adicionar <cpf> <nome>: Adicionar cliente");
        System.out.println("listar: Listar clientes");
        System.out.println("buscar <cpf>: Buscar cliente pelo CPF");
        System.out.println("remover <cpf>: Remover cliente");
        System.out.println("atualizar <cpf> <novo_nome>: Atualizar nome do cliente");
        System.out.println("voltar: Voltar ao menu inicial");
        super.exibirComandos();
    }

    @Override
    public void tratarComando(String comando, String[] argumentos) {
        switch (comando) {
            case "adicionar":
                comandoAdicionar(argumentos);
                return;
            case "listar":
                comandoListar();
                return;
            case "buscar":
                comandoBuscar(argumentos);
                return;
            case "remover":
                comandoRemover(argumentos);
                return;
            case "atualizar":
                comandoAtualizar(argumentos);
                return;
            case "voltar":
                super.setProximoMenu(new MenuInicial());
                return;
        }

        super.tratarComando(comando, argumentos);
    }

    private void comandoAdicionar(String[] argumentos) {
        if (argumentos.length < 2) {
            System.out.println("Uso: adicionar <cpf> <nome>");
            return;
        }

        String cpf = argumentos[0];
        String nome = argumentos[1];

        ServicoClientes.adicionar(cpf, nome);
    }

    private void comandoListar() {
        ArrayList<Cliente> clientes = ServicoClientes.listar();

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("Clientes:");
        for (Cliente cliente : clientes) {
            System.out.printf("CPF: %s, Nome: %s%n", cliente.getCpf(), cliente.getNome());
        }
    }

    private void comandoBuscar(String[] argumentos) {
        if (argumentos.length < 1) {
            System.out.println("Uso: buscar <cpf>");
            return;
        }

        Cliente cliente = ServicoClientes.buscar(argumentos[0]);
        if (cliente != null) {
            System.out.printf("CPF: %s, Nome: %s%n", cliente.getCpf(), cliente.getNome());
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private void comandoRemover(String[] argumentos) {
        if (argumentos.length < 1) {
            System.out.println("Uso: remover <cpf>");
            return;
        }

        ServicoClientes.remover(argumentos[0]);
        System.out.println("Cliente removido.");
    }

    private void comandoAtualizar(String[] argumentos) {
        if (argumentos.length < 2) {
            System.out.println("Uso: atualizar <cpf> <novo_nome>");
            return;
        }

        String cpf = argumentos[0];
        String novoNome = argumentos[1];

        ServicoClientes.atualizar(cpf, novoNome);
    }

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }
}
