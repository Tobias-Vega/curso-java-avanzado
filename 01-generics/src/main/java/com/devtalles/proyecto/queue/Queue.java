package com.devtalles.proyecto.queue;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Queue<T> {
    private  final LinkedList<T> elements = new LinkedList<>();

    public void enqueue(T element) {
        elements.addLast(element);
        System.out.println("Elemento agregado: " + element);
    }
    
    public boolean isEmpty() {
        return elements.isEmpty();
    }
    
    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        
        return elements.getFirst();
    }
    
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        
        return elements.removeFirst();
    }
    
    public void print() {
        for (Object o : elements) {
            System.out.println(o);
        }
    }
}
