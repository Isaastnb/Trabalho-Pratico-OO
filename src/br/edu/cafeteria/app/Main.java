package br.edu.cafeteria.app;

import java.util.Scanner;

import br.edu.cafeteria.app.menu.Menu;
import br.edu.cafeteria.app.menu.MenuInicial;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem-vindo à Cafeteria Geek \"Byte & Brew\"!");
        System.out.println();

        // Estados
        //

        Menu menuAtual = new MenuInicial();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("-------------COMANDOS-------------");
                menuAtual.exibirComandos();
                System.out.println("----------------------------------");
                System.out.println();

                System.out.print(">> ");
                String linha = scanner.nextLine();

                menuAtual.tratarComando(linha.toLowerCase().trim());

                menuAtual = menuAtual.pegarProximoMenu();
            }
        }
    }
}
