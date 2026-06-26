package br.edu.cafeteria.app.menu;

public class MenuProdutos extends Menu {
    @Override
    public void exibirComandos() {
        //System.out.println("Add produto: Adiciona produtos a lista");
        System.out.println("voltar: Voltar ao menu inicial");
    }

    @Override
    public void tratarComando(String comando) {
        switch (comando) {
            /*case "add produto":
                super.
                
                break;*/
            case "voltar":
                super.setProximoMenu(new MenuInicial());
                break;
        }
    }
}
