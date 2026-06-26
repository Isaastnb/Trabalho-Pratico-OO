package br.edu.cafeteria.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class Estoque {
    private static HashMap<String, Produto> produtos = new HashMap<>();

    public static void adicionarProduto(String codigo, Produto produto) {
        produtos.put(codigo, produto);
    }

    public static ArrayList<Produto> getProdutos() {
        return new ArrayList<>(produtos.values());
    }

    public static Produto getProduto(String codigo) {
        return produtos.get(codigo);
    }
}
