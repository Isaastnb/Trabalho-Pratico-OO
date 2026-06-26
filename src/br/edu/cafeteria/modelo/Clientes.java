package br.edu.cafeteria.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Clientes {
        private static HashMap<String, Cliente> clientes = new HashMap<>();

    public static void adicionarCliente(String cpf, Cliente cliente) {
        clientes.put(cpf, cliente);
    }

    public static ArrayList<Cliente> listarClientes() {
        return new ArrayList<>(clientes.values());
    }

    public static Cliente getCliente(String cpf) {
        return clientes.get(cpf);
    }

    public static void removerCliente(String cpf) {
        clientes.remove(cpf);
    }

    public static void atualizarCliente(String cpf, Cliente cliente) {
        clientes.put(cpf, cliente);
    }
}
