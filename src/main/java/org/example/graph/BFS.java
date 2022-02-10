package org.example.graph;

import java.util.*;

public class BFS {

    public static ArrayList<String> path;

    public static<T> Optional<Node<T>> search(T value, Node<T> start){

        Queue<Node<T>> queue = new ArrayDeque<>();
        path = new ArrayList<String>();
        queue.add(start);

        Node<T> currentNode;
        Set<Node<T>> closed = new HashSet<>();

        while(!queue.isEmpty()){ //1. Verificar si se pudo continuar //Acá no es empty inicialmente por la asignación inicial
            currentNode = queue.remove();
            path.add(currentNode.getValue().toString());
            //System.out.println("Pasando por: "+currentNode.getValue().toString());
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
/*
    public static ArrayList<String> getPath(){
        return path;
    }*/
}
