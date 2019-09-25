package com.company;

import heap.Pessoa;
import heap.filaBanco;

public class Main {

    public static void main(String[] args) {
	    //Heap
        filaBanco fila = new filaBanco();
        fila.addPessoa("20", 20);
        fila.addPessoa("10", 10);
        fila.addPessoa("60", 60);
        fila.addPessoa("80", 80);
        fila.addPessoa(new Pessoa("50",50));

        //fila.getPessoas()[2].setIdade(5);

        while(fila.getSize() > 0) {
            Pessoa p = fila.peek();
            System.out.println(p.getNome() + " esta sendo atendido");
            fila.remove();
        }
    }
}
