package com.itakinn;

import java.util.Scanner;

import com.itakinn.core.db;
import com.itakinn.core.input;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main(String[] args){
        if (args == null){
            input.iniciar();
        }else{
        Scanner ler = new Scanner(System.in);
        System.out.println("escolha uma opção");
        System.out.println();
        System.out.println("1-∞ - Jogar");
        System.out.println("0 - Criar database");
        System.out.println();
        System.out.println();

        int escolha = ler.nextInt();
        if (escolha == 0){
            db.criarDB();
        }else{
            input.iniciar();
        }
        
        }
    }
    
}
