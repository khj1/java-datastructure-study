package com.example.datastructure.linkedlist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MyDoubleLinkedListTest {

    private MyDoubleLinkedList<Integer> linkedList;

    @BeforeEach
    void setup() {
        linkedList = new MyDoubleLinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
    }

    @Test
    void add() {
        assertThat(linkedList.getHeadData()).isEqualTo(1);
        assertThat(linkedList.getTailData()).isEqualTo(2);

        linkedList.add(3);
        assertThat(linkedList.getHeadData()).isEqualTo(1);
        assertThat(linkedList.getTailData()).isEqualTo(3);
    }

    @Test
    void findDataFromHead() {
        assertThat(linkedList.findFromHead(1)).isTrue();
        assertThat(linkedList.findFromHead(2)).isTrue();
    }

    @Test
    void findDataFromTail() {
        assertThat(linkedList.findFromTail(1)).isTrue();
        assertThat(linkedList.findFromTail(2)).isTrue();
    }

    @Test
    @DisplayName("임의의 노드 앞에 새로운 노드를 추가")
    void addNodeBetween() {
        linkedList.addBefore(15, 2);
        linkedList.addAfter(20, 2);

        assertThat(linkedList.getPrevData(2)).isEqualTo(15);
        assertThat(linkedList.getNextData(2)).isEqualTo(20);
    }

    @Test
    @DisplayName("임의의 노드 앞에 새로운 노드를 추가_예외상황")
    void addNodeBetweenException() {
        assertThatThrownBy(() -> linkedList.addBefore(15, 4))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> linkedList.addAfter(15, 4))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
