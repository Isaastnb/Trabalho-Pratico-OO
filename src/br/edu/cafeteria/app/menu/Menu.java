package br.edu.cafeteria.app.menu;

public abstract class Menu {
    private Menu proximoMenu;
    private static final String MENU_NAME = "Menu";

    public void exibirComandos() {
        System.out.println("sair: Sair do programa");
        System.out.println("comandos: Exibir lista de comandos disponíveis");
    }

    public void tratarComando(String comando, String[] argumentos) {
        switch (comando) {
            case "sair":
                System.out.println("Saindo do programa...");
                System.exit(0);
                break;
            case "comandos":
                this.exibirComandos();
                break;
            default:
                System.out.println("Comando não reconhecido. Digite 'comandos' para ver a lista de comandos disponíveis.");
                break;
        }
    }

    public Menu pegarProximoMenu() {
        Menu proximo = proximoMenu;
        proximoMenu = null; // Limpa para evitar transições fantasmas caso o menu seja reutilizado
        return proximo != null ? proximo : this;
    }

    protected void setProximoMenu(Menu proximoMenu) {
        this.proximoMenu = proximoMenu;
    }

    public String getMenuName() {
        return MENU_NAME;
    }
}
