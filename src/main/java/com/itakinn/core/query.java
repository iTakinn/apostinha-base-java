package com.itakinn.core;

import com.itakinn.Main;
import com.itakinn.constantes;

public class query {
    public static void verificar(String nome, Double valor, int numero) {
        db.lerDB(nome);
        Double saldoo = db.saldo;
        if (valor > saldoo){
            System.out.println("Voce nao tem esse valor.");
            System.out.println("Atualmente voce tem: "+ saldoo);
            Main.main(null);
        }else {
            int id =db.idd;
            jogar.jogo(valor, nome, numero, id);
        }
    }
    public static void ganhou(Double valor, String nome, int id) {
        Double adicionar = valor * constantes.ganho;
        db.addSaldo(adicionar, id);
        
    }
    public static void perdeu(Double valor, int id) {
        db.removerSaldo(valor, id);
    }
}
