package br.edu.cafeteria.app.menu;

import java.util.ArrayList;
import java.util.Scanner;

import br.edu.cafeteria.modelo.Bebida;
import br.edu.cafeteria.modelo.Comida;
import br.edu.cafeteria.modelo.Produto;
import br.edu.cafeteria.modelo.TamanhoBebida;
import br.edu.cafeteria.modelo.TemperaturaBebida;
import br.edu.cafeteria.servico.ServicoProdutos;

public class MenuProdutos extends Menu {
    private static final String MENU_NAME = "Menu de Produtos";

    @Override
    public void exibirComandos() {
        System.out.println("adicionar <código> <nome> <preço> <quantidade> <tipo>: Adicionar produto ao estoque");
        System.out.println("listar: Listar produtos");
        System.out.println("buscar <código>: Buscar produto pelo código");
        System.out.println("remover <código>: Remover produto do estoque");
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
            case "voltar":
                super.setProximoMenu(new MenuInicial());
                return;
        }

        super.tratarComando(comando, argumentos);
    }

    private void comandoAdicionar(String[] argumentos) {
        if (argumentos.length < 5) {
            System.out.println("Uso: adicionar <código> <nome> <preço> <quantidade> <tipo>");
            return;
        }

        String codigo = argumentos[0];
        String nome = argumentos[1];
        float preco;
        int quantidade;
        String tipo = argumentos[4];
        try {
            preco = Float.parseFloat(argumentos[2]);
            quantidade = Integer.parseInt(argumentos[3]);
        } catch (NumberFormatException e) {
            System.out.println("Preço e quantidade devem ser números válidos.");
            return;
        }

        Produto produto;

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        switch (tipo.toLowerCase()) {
            case "comida":
                System.out.print("Digite o tempo de preparo (em minutos): ");
                int tempoPreparo = scanner.nextInt();
                System.out.print("O produto é vegano? (true/false): ");
                boolean vegano = scanner.nextBoolean();
                System.out.print("O produto é sem glúten? (true/false): ");
                boolean semGluten = scanner.nextBoolean();
                produto = new Comida(
                    codigo, nome, preco, 
                    quantidade, tempoPreparo, 
                    vegano, semGluten);
                break;
            case "bebida":
                System.out.print("Digite o tamanho (P/M/G): ");
                String tamanho = scanner.next();
                System.out.print("Digite mg de cafeína (0 se não tiver): ");
                int mgCafeina = scanner.nextInt();
                System.out.print("Digite a temperatura (QUENTE/GELADA): ");
                String temperatura = scanner.next();

                produto = new Bebida(
                    codigo, nome, preco, 
                    quantidade, TamanhoBebida.valueOf(tamanho.toUpperCase()), 
                    mgCafeina, TemperaturaBebida.valueOf(temperatura.toUpperCase()));
                break;
            default:
                System.out.println("Tipo de produto inválido. Use 'comida' ou 'bebida'.");
                return;
        }

        ServicoProdutos.adicionar(codigo, produto);
    }

    private void comandoListar() {
        ArrayList<Produto> produtos = ServicoProdutos.listar();

        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        System.out.println("Produtos no estoque:");
        for (Produto produto : produtos) {
            System.out.printf("Código: %s, Nome: %s, Preço: R$ %.2f, Quantidade: %d (%s)%n", 
                produto.getCodigo(), 
                produto.getNome(), 
                produto.getPrecoBase(), 
                produto.getQuantidadeEstoque(),
                produto instanceof Comida ? "Comida" : "Bebida");
        }
    }

    private void comandoBuscar(String[] argumentos) {
        if (argumentos.length < 1) {
            System.out.println("Uso: buscar <código>");
            return;
        }

        Produto produto = ServicoProdutos.buscar(argumentos[0]);
        if (produto != null) {
            System.out.printf("Código: %s, Nome: %s, Preço: R$ %.2f, Quantidade: %d%n", produto.getCodigo(), produto.getNome(), produto.getPrecoBase(), produto.getQuantidadeEstoque());
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private void comandoRemover(String[] argumentos) {
        if (argumentos.length < 1) {
            System.out.println("Uso: remover <código>");
            return;
        }

        ServicoProdutos.remover(argumentos[0]);
        System.out.println("Produto removido do estoque.");
    }

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }
}
