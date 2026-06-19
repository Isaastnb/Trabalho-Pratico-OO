package br.edu.cafeteria.app.menu;

public abstract class Menu {
    private Menu proximoMenu;

    public void exibirComandos() {}

    public void tratarComando(String comando) {}

    public Menu pegarProximoMenu() {
        return proximoMenu;
    }

    protected void setProximoMenu(Menu proximoMenu) {
        this.proximoMenu = proximoMenu;
    }
}
