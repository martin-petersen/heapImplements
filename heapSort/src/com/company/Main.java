package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rdm = new Random();
        int[] vetor = new int[10];
        for (int i = 0; i < 10; ++i) {
            vetor[i] = rdm.nextInt(10);
        }
        Heap heap = new Heap(vetor);
        System.out.println("AAAAAAAAAAA");
        heap.imprimeVetor();
        heap.heapSort();
        System.out.println("BBBBBBBBBBB");
        heap.imprimeVetor();

    }
}
