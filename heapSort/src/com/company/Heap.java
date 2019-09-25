package com.company;

import java.util.Arrays;

public class Heap {

    private int[] vetor;
    private int size;
    private int tam;

    public Heap (int tam) {
        vetor = new int[tam];
        this.size = 0;
        this.tam = tam;
    }

    public Heap (int[] vetor) {
        this.vetor = vetor;
        this.size = vetor.length;
        this.tam = vetor.length;
    }

    private void ensureTam() {
        if(tam == getSize()) {
            this.vetor = Arrays.copyOf(this.vetor,getSize()*2);
            tam = getSize()*2;
        }
    }

    public int getSize() {
        return size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0 && getParentIndex(index) < size;
    }

    private int getParentIndex(int index) {
        return (int) Math.floor((index-1)/2);
    }

    public void addNum(int num) {
        this.ensureTam();
        this.vetor[getSize()] = num;
        heapifyUp(getSize());
        size++;
    }

    private void heapifyUp(int index) {
        if(!hasParent(index)) {
            return;
        }
        int parentIndex = getParentIndex(index);
        int valor = vetor[index];
        int pai = vetor[parentIndex];

        if(valor > pai) {
            vetor[index] = pai;
            vetor[parentIndex] = valor;
            heapifyUp(parentIndex);
        }
    }

    public void heapSort() {

    }

    private void heapifyDown(int i) {
        int leftChild = i * 2 + 1;
        int rightChild = i * 2 + 2;

        int childIndex = -1;
        if(leftChild < getSize()) {
            childIndex = leftChild;
        }

        if(childIndex < 0) {
            return;
        }

        if(rightChild < getSize()){
            if(vetor[rightChild] > vetor[leftChild]) {
                childIndex = rightChild;
            }
        }

        if(vetor[i] < vetor[childIndex]) {
            int tmp = vetor[i];
            vetor[i] = vetor[childIndex];
            vetor[childIndex] = tmp;
            heapifyDown(childIndex);
        }
    }

    public void imprimeVetor() {
        for(int i = 0; i < this.tam; ++i) {
            System.out.println(this.vetor[i]);
        }
    }

}
