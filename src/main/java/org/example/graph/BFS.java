package org.example.graph;

import java.util.*;

public class BFS {

    public static<T> Optional<Node<T>> search(T value, Node<T> start){
        Queue<Node<T>> queue = new ArrayDeque<>();
        queue.add(start);

        Node<T> currentNode;
        Set<Node<T>> closed = new HashSet<>();

        while(!queue.isEmpty()){ //1. Verificar si se pudo continuar
            currentNode = queue.remove();
            //2. Verifico si se encuentra en la meta
            if(currentNode.getValue().equals(value)){
                return Optional.of(currentNode);

            }else {
                closed.add(currentNode);
                queue.addAll(currentNode.getNeighbors());
                queue.removeAll(closed);
            }
        }
        return Optional.empty();
    }
}
