package br.edu.cafeteria.servico;

import java.util.ArrayList;
import java.util.HashMap;

import br.edu.cafeteria.modelo.Produto;

public class ServicoProdutos {
    private static HashMap<String, Produto> produtos = new HashMap<>();

    public static void adicionar(String codigo, Produto produto) {
        produtos.put(codigo, produto);
    }

    public static ArrayList<Produto> listar() {
        return new ArrayList<>(produtos.values());
    }

    public static Produto buscar(String codigo) {
        return produtos.get(codigo);
    }

    public static void remover(String codigo) {
        produtos.remove(codigo);
    }

    public static void atualizar(String codigo, String novoNome, float novoPreco, int novaQuantidade) {
        Produto produto = produtos.get(codigo);
        if (produto != null) {
            produto.setNome(novoNome);
            produto.setPreco(novoPreco);
            produto.setQuantidadeEstoque(novaQuantidade);
            produtos.put(codigo, produto);
        }
    }
}
