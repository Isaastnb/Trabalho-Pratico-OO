package br.edu.cafeteria.app.menu;

import br.edu.cafeteria.modelo.Estoque;
import br.edu.cafeteria.modelo.Produto;

public class MenuProdutos extends Menu {
    private static final String MENU_NAME = "Menu de Produtos";


    @Override
    public void exibirComandos() {
        System.out.println("adicionar <código> <nome> <preço> <quantidade>: Adicionar produto ao estoque");
        System.out.println("listar: Listar produtos");
        System.out.println("buscar <código>: Buscar produto pelo código");
        System.out.println("voltar: Voltar ao menu inicial");
        super.exibirComandos();
    }

    @Override
    public void tratarComando(String comando, String[] argumentos) {
        switch (comando) {
            case "adicionar":
                if (argumentos.length < 4) {
                    System.out.println("Uso: adicionar <código> <nome> <preço> <quantidade>");
                    return;
                }

                String codigo = argumentos[0];
                String nome = argumentos[1];
                double preco;
                int quantidade;
                try {
                    preco = Double.parseDouble(argumentos[2]);
                    quantidade = Integer.parseInt(argumentos[3]);
                } catch (NumberFormatException e) {
                    System.out.println("Preço e quantidade devem ser números válidos.");
                    return;
                }

                Estoque.adicionarProduto(codigo, new Produto(codigo, nome, preco, quantidade));
                return;

            case "listar":
                System.out.println("Produtos no estoque:");
                for (Produto produto : Estoque.getProdutos()) {
                    System.out.printf("Código: %s, Nome: %s, Preço: R$ %.2f, Quantidade: %d%n", produto.getCodigo(), produto.getNome(), produto.getPrecoBase(), produto.getQuantidadeEstoque());
                }
                return;
            case "buscar":
                if (argumentos.length < 1) {
                    System.out.println("Uso: buscar <código>");
                    return;
                }

                Produto produto = Estoque.getProduto(argumentos[0]);
                if (produto != null) {
                    System.out.printf("Código: %s, Nome: %s, Preço: R$ %.2f, Quantidade: %d%n", produto.getCodigo(), produto.getNome(), produto.getPrecoBase(), produto.getQuantidadeEstoque());
                } else {
                    System.out.println("Produto não encontrado.");
                }
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
