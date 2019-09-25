package heap;

import java.util.Arrays;

public class filaBanco {

    private Pessoa[] pessoas;
    private int size;
    private int tam;

    public filaBanco() {
        this(10);
    }

    public filaBanco(int tam) {
        pessoas = new Pessoa[tam];
        this.size = 0;
        this.tam = tam;
    }

    public void addPessoa(String nome, int idade) {
        addPessoa(new Pessoa(nome,idade));
    }

    public void addPessoa(Pessoa pessoa) {
        this.ensureTam();
        this.pessoas[size] = pessoa;
        heapifyUp(getSize());
        size++;
    }

    private void ensureTam() {
        if(tam == getSize()) {
            this.pessoas = Arrays.copyOf(this.pessoas,getSize()*2);
            tam = getSize()*2;
        }
    }

    public int getSize() {
        return size;
    }

    private void heapifyUp(int index) {
        if(!hasParent(index)) {
            return;
        }
        int parentIndex = getParentIndex(index);
        Pessoa node = pessoas[index];
        Pessoa pai = pessoas[parentIndex];

        if(node.getIdade() > pai.getIdade()) {
            pessoas[index] = pai;
            pessoas[parentIndex] = node;
            heapifyUp(parentIndex);
        }
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0 && getParentIndex(index) < size;
    }

    private int getParentIndex(int index) {
        return (int) Math.floor((index-1)/2);
    }

    public Pessoa peek() {
        if(getSize() == 0) {
            return null;
        }
        return pessoas[0];
    }
    public void remove() {
        pessoas[0] = pessoas[getSize()-1];
        pessoas[getSize()-1] = null;
        size--;
        heapifyDown(0);
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
            if(pessoas[rightChild].getIdade() > pessoas[leftChild].getIdade()) {
                childIndex = rightChild;
            }
        }

        if(pessoas[i].getIdade() < pessoas[childIndex].getIdade()) {
            Pessoa tmp = pessoas[i];
            pessoas[i] = pessoas[childIndex];
            pessoas[childIndex] = tmp;
            heapifyDown(childIndex);
        }
    }

    public void changeAge(int index, int idadeAtual) {

    }
}
