package br.edu.cafeteria.app.menu;

public class MenuInicial extends Menu {

    @Override
    public void exibirComandos() {
        System.out.println("sair: Sair do programa");
        System.out.println("produtos: Acessar menu de produtos");
    }

    @Override
    public void tratarComando(String comando) {
        switch (comando) {
            case "sair":
                System.out.println("Saindo do programa...");
                System.exit(0);
                break;
            case "produtos":
                super.setProximoMenu(new MenuProdutos());
                break;
        }

    }
}
