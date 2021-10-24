package com.example.datastructure.hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MyHashLinearProbingTest {
    MyHashLinearProbing hash;

    @BeforeEach
    void setup() {
        hash = new MyHashLinearProbing(5);
        hash.save("keyA", "valueA");
        hash.save("keyB", "valueB");
    }

    @Test
    void hash_add() {
        assertThat(hash.get("keyA")).isEqualTo("valueA");
        assertThat(hash.get("keyB")).isEqualTo("valueB");
    }

    @Test
    void hash_get_exception() {
        assertThatThrownBy(() -> hash.get("dataB"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}