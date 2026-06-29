package br.edu.cafeteria.app.menu;

public class MenuInicial extends Menu {
    private static final String MENU_NAME = "Menu Inicial";

    @Override
    public void exibirComandos() {
        System.out.println("produtos: Acessar menu de produtos");
        System.out.println("clientes: Acessar menu de clientes");
        System.out.println("pedidos: Acessar menu de pedidos");
        super.exibirComandos();
    }

    @Override
    public void tratarComando(String comando, String[] argumentos) {
        switch (comando) {
            case "produtos":
                super.setProximoMenu(new MenuProdutos());
                return;
            case "clientes":
                super.setProximoMenu(new MenuClientes());
                return;
            case "pedidos":
                super.setProximoMenu(new MenuPedidos());
                return;
        }

        super.tratarComando(comando, argumentos);
    }

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }
}
