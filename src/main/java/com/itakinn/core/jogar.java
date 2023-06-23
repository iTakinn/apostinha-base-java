package com.itakinn.core;

import java.util.Random;
import com.itakinn.constantes;

public class jogar {
    public static void jogo(Double valor, String nome, int chute, int id) {
        Random rdn = new Random();
        int oculto = rdn.nextInt(10)+1;
        if (chute != oculto){
            System.out.println();
            System.out.println("Voce perdeu, o numero era: "+ oculto+" \nseu chute foi: "+chute);
            System.out.println();
            query.perdeu(valor, id);
        } else {
            System.out.println();
            System.out.println("Parabens por ganhar!");
            System.out.println("Você multiplicou sua aposta em "+constantes.ganho+"x");
            System.out.println();
            query.ganhou(valor, nome, id);
        }
    }

}
