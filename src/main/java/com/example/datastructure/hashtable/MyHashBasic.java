package com.example.datastructure.hashtable;

public class MyHashBasic {
    public Slot[] hashTable;

    public MyHashBasic(Integer size) {
        this.hashTable = new Slot[size];
    }

    public String get(String key) {
        Integer address = hashFunc(key);
        if (hashTable[address] == null) {
            throw new IllegalArgumentException("해당 데이터는 존재하지 않습니다.");
        }
        return hashTable[hashFunc(key)].value;
    }

    public static class Slot{
        String value;

        public Slot(String value) {
            this.value = value;
        }
    }

    private Integer hashFunc(String key) {
        return key.charAt(0) % hashTable.length;
    }

    public boolean save(String key, String data) {
        Integer address = hashFunc(key);
        if (hashTable[address] != null) {
            hashTable[address].value = data;
        } else {
            hashTable[address] = new Slot(data);
        }
        return true;
    }
}
