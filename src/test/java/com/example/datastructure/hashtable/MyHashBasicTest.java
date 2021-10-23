package com.example.datastructure.hashtable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MyHashBasicTest {

    MyHashBasic hash;

    @BeforeEach
    void setup() {
        hash = new MyHashBasic(5);
        hash.save("keyA", "valueA");
    }

    @Test
    void hash_add() {
        assertThat(hash.get("keyA")).isEqualTo("valueA");
    }

    @Test
    void hash_get_exception() {
        assertThatThrownBy(() -> hash.get("dataB"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
