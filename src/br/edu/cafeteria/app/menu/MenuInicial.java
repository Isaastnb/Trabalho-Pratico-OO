package br.edu.cafeteria.app.menu;

public class MenuInicial extends Menu {
    private static final String MENU_NAME = "Menu Inicial";

    @Override
    public void exibirComandos() {
        System.out.println("produtos: Acessar menu de produtos");
        super.exibirComandos();
    }

    @Override
    public void tratarComando(String comando, String[] argumentos) {
        switch (comando) {
            case "produtos":
                super.setProximoMenu(new MenuProdutos());
                return;
        }

        super.tratarComando(comando, argumentos);
    }

    @Override
    public String getMenuName() {
        return MENU_NAME;
    }
}
