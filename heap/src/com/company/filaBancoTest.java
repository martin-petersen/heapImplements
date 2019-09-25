package com.company;

import heap.Pessoa;
import heap.filaBanco;
import org.junit.Test;

import static org.junit.Assert.*;

public class filaBancoTest {

//    Se utilizar o before ele vai instanciar a fila em cada teste sem precisar criar a fila em cada teste
//    como está sendo feito nesse teste
//    filaBanco fila = null
//    @Before
//    public void init() {
//        fila = new filaBanco();
//    }

    @Test
    public void ordenado() {
        //Arrange
        Pessoa vovo = new Pessoa("vovo", 65);
        Pessoa fulano = new Pessoa("fulano", 10);
        Pessoa sicrano = new Pessoa("sicrano", 25);

        filaBanco fila = new filaBanco();
        //Act
        fila.addPessoa(vovo);
        fila.addPessoa(fulano);
        fila.addPessoa(sicrano);

        //Assert
        assertSame(vovo,fila.peek());
        fila.remove();
        assertSame(sicrano,fila.peek());
        fila.remove();
        assertSame(fulano,fila.peek());
        fila.remove();
        assertNull(fila.peek());
    }

    @Test
    public void testPeek() {
        //Arrange
        filaBanco fila = new filaBanco();
        Pessoa vovo = new Pessoa("vovo", 65);
        Pessoa fulano = new Pessoa("fulano", 10);
        Pessoa sicrano = new Pessoa("sicrano", 25);
        //Act
        fila.addPessoa(vovo);
        fila.addPessoa(fulano);
        fila.addPessoa(sicrano);
        //Assert
        assertSame(vovo,fila.peek());
    }

    @Test
    public void mustReorderWhenPriorityChanges() {
        //Arrange
        filaBanco fila = new filaBanco();
        Pessoa vovo = new Pessoa("vovo", 65);
        Pessoa fulano = new Pessoa("fulano", 10);
        Pessoa sicrano = new Pessoa("sicrano", 25);
        fila.addPessoa(vovo);
        fila.addPessoa(fulano);
        fila.addPessoa(sicrano);
        //Act
        fulano.setIdade(67);
        //Assert
        assertSame(fulano,fila.peek());
    }

}