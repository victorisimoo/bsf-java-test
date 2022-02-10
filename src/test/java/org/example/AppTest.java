package org.example;

import org.example.graph.BFS;
import org.example.graph.Node;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

/**
 * Unit test for simple App.
 */
public class AppTest  {

    private Node<Integer> tenNode;
    private Node<Integer> twoNode;
    private Node<Integer> threeNode;
    private Node<Integer> fourNode;

    @Test
    void givenNode_whenSearchFour_thenSecondNeighbor(){
        initNode();
        assertEquals(fourNode, BFS.search(4,twoNode).get());
    }

    @Test
    void givenNode_whenSearchFive_thenNotFound(){
        initNode();
        assertTrue(BFS.search(5, twoNode).isEmpty());
    }

    private void initNode(){
        //Inicialización de los objetos
        tenNode = new Node<>(10);
        twoNode = new Node<>(2);
        threeNode = new Node<>(3);
        fourNode = new Node<>(4);

        //Conexiones con los objetos
        tenNode.connect(twoNode); //10-2
        twoNode.connect(threeNode);
        threeNode.connect(tenNode);
        tenNode.connect(fourNode);
    }
}

