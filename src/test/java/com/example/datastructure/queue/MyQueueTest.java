package com.example.datastructure.queue;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyQueueTest {

    @Test
    void dequeue_enqueue() {
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("Hi");
        queue.enqueue("Bye");

        assertThat(queue.dequeue()).isEqualTo("Hi");
        assertThat(queue.dequeue()).isEqualTo("Bye");
        assertThat(queue.dequeue()).isEqualTo(null);
    }
}
