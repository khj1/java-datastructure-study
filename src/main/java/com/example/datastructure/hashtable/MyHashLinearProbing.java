package com.example.datastructure.hashtable;

/*
해쉬 테이블의 빈번한 충돌을 막는 방법.
    1. 저장 공간 확대
    2. 해쉬 함수 재정의
 */
public class MyHashLinearProbing {
    public Slot[] hashTable;

    public MyHashLinearProbing(Integer size) {
        this.hashTable = new Slot[size];
    }

    public String get(String key) {
        Integer address = hashFunc(key);
        if (hashTable[address] == null) {
            throw new IllegalArgumentException("해당 데이터는 존재하지 않습니다.");
        }
        if (hashTable[hashFunc(key)].key.equals(key)) {
            return hashTable[hashFunc(key)].value;
        } else {
            Integer currentAddress = address + 1;
            while (hashTable[currentAddress] != null) {
                if (hashTable[currentAddress].key.equals(key)) {
                    return hashTable[currentAddress].value;
                } else {
                    currentAddress++;
                    if (currentAddress >= hashTable.length) {
                        throw new IllegalArgumentException("해당 데이터는 존재하지 않습니다.");
                    }
                }
            }
            throw new IllegalArgumentException("해당 데이터는 존재하지 않습니다.");
        }
    }

    public static class Slot{
        String key;
        String value;

        public Slot(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Integer hashFunc(String key) {
        return key.charAt(0) % hashTable.length;
    }

    public boolean save(String key, String value) {
        Integer address = hashFunc(key);
        if (hashTable[address] != null) {
            if (hashTable[address].key.equals(key)){
                hashTable[address].value = value;
            } else {
                Integer currentAddress = address + 1;
                while (hashTable[currentAddress] != null) {
                    if (hashTable[currentAddress].key.equals(key)) {
                        hashTable[currentAddress].value = value;
                        return true;
                    } else {
                        currentAddress++;
                        if (currentAddress >= hashTable.length) {
                            return false;
                        }
                    }
                }
                hashTable[currentAddress] = new Slot(key, value);
                return true;
            };
        } else {
            hashTable[address] = new Slot(key, value);
        }
        return true;
    }
}
