package com.itakinn.core;

import java.util.Scanner;


public class input {
    public static void iniciar() {
        Scanner ler = new Scanner(System.in);
        System.out.println();
        System.out.println("Seu nome?");
        String nome = ler.nextLine();

        int chute = 0;
        boolean numeroValido = false;
        while (!numeroValido) {
            System.out.println();
            System.out.println("Em qual número quer apostar?");
            System.out.println("Escolha um número entre 1 e 10:");
            System.out.print("Escolha: ");
            chute = ler.nextInt();

            if (chute >= 1 && chute <= 10) {
                numeroValido = true;
            } else {
                System.out.println();
                System.out.println("Número inválido. Escolha um número entre 1 e 100.");
            }
        }

        System.out.println();
        System.out.print("Valor da aposta: ");
        double valor = ler.nextDouble();
        System.out.println();
        query.verificar(nome, valor, chute);
        ler.nextLine();
        ler.close();
    }

}
