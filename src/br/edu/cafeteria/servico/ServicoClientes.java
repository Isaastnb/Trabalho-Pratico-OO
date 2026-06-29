package br.edu.cafeteria.servico;

import java.util.ArrayList;
import java.util.HashMap;

import br.edu.cafeteria.modelo.Cliente;
import br.edu.cafeteria.modelo.ClienteStandard;

public class ServicoClientes {
    private static HashMap<String, Cliente> clientes = new HashMap<>();

    public static void adicionar(String cpf, String nome) {
        clientes.put(cpf, new ClienteStandard(cpf, nome));
    }

    public static ArrayList<Cliente> listar() {
        return new ArrayList<>(clientes.values());
    }

    public static Cliente buscar(String cpf) {
        return clientes.get(cpf);
    }

    public static void remover(String cpf) {
        clientes.remove(cpf);
    }

    public static void atualizar(String cpf, String novoNome) {
        Cliente cliente = clientes.get(cpf);
        if (cliente != null) {
            cliente.setNome(novoNome);
            clientes.put(cpf, cliente);
        }
    }
}
