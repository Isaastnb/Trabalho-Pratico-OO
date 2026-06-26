package br.edu.cafeteria.app.menu;

public abstract class Menu {
    private Menu proximoMenu;

    public void exibirComandos() {}

    public void tratarComando(String comando) {}

    public Menu pegarProximoMenu() {
        Menu proximo = proximoMenu;
        proximoMenu = null; // Limpa para evitar transições fantasmas caso o menu seja reutilizado
        return proximo != null ? proximo : this;
    }

    protected void setProximoMenu(Menu proximoMenu) {
        this.proximoMenu = proximoMenu;
    }
}
