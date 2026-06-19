package br.edu.cafeteria.app.menu;

public class MenuProdutos extends Menu {
    @Override
    public void exibirComandos() {
        System.out.println("voltar: Voltar ao menu inicial");
    }

    @Override
    public void tratarComando(String comando) {
        switch (comando) {
            case "voltar":
                super.setProximoMenu(new MenuInicial());
                break;
        }
    }
}
