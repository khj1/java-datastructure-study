package com.example.datastructure.stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyStackTest {
    @Test
    void push_pop() {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);

        Assertions.assertThat(stack.pop()).isEqualTo(2);
        Assertions.assertThat(stack.pop()).isEqualTo(1);
        Assertions.assertThat(stack.pop()).isEqualTo(null);
    }
}
