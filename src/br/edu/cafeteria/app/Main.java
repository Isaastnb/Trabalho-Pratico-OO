package br.edu.cafeteria.app;

import java.util.Scanner;
import java.util.Arrays;

import br.edu.cafeteria.app.menu.Menu;
import br.edu.cafeteria.app.menu.MenuInicial;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bem-vindo à Cafeteria Geek \"Byte & Brew\"!");
        System.out.println();

        Menu menuAtual = new MenuInicial();
        System.out.println("-------------COMANDOS-------------");
        menuAtual.exibirComandos();
        System.out.println("----------------------------------");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println();

                System.out.print(menuAtual.getMenuName() + " >> ");
                String linha = scanner.nextLine();
                String[] linhaArgs = linha.toLowerCase().trim().split(" ");
                String comando = linhaArgs[0];
                String[] argumentos = linhaArgs.length > 1 ? Arrays.copyOfRange(linhaArgs, 1, linhaArgs.length) : new String[0];

                menuAtual.tratarComando(comando, argumentos);

                menuAtual = menuAtual.pegarProximoMenu();
            }
        }
    }
}
