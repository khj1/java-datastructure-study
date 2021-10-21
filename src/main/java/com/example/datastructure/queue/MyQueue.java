package com.example.datastructure.queue;

import java.util.LinkedList;
import java.util.List;

public class MyQueue<T> {
    private final List<T> queue;

    public MyQueue() {
        this.queue = new LinkedList<>();
    }

    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        if (queue.isEmpty()) {
            return null;
        }
        return queue.remove(0);
    }
}
