package com.example.datastructure.hashtable;

public class MyHashChaining {

    public Slot[] hashTable;

    public MyHashChaining(Integer size) {
        this.hashTable = new Slot[size];
    }

    public String get(String key) {
        Integer address = hashFunc(key);
        if (hashTable[address] == null) {
            throw new IllegalArgumentException("해당 데이터는 존재하지 않습니다.");
        }
        return getValue(key);
    }

    private String getValue(String key) {
        Slot slot = hashTable[hashFunc(key)];
        while (!slot.key.equals(key)) {
            slot = slot.next;
        }
        return slot.value;
    }

    public static class Slot{
        String key;
        String value;
        Slot next = null;

        public Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Integer hashFunc(String key) {
        return key.charAt(0) % hashTable.length;
    }

    public boolean save(String key, String data) {
        Integer address = hashFunc(key);
        if (hashTable[address] != null) {
            Slot slot = hashTable[address];
            while (slot.next != null) {
                if (slot.key.equals(key)) {
                    slot.value = data;
                    return true;
                }
            }
            slot.next = new Slot(key, data);
        } else {
            hashTable[address] = new Slot(key, data);
        }
        return true;
    }
}
