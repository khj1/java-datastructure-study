package com.example.datastructure.linkedlist;

public class MyDoubleLinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    public void addBefore(T newData, T beforeData) {
        if (head == null) {
            head = new Node<>(newData);
            tail = head;
        } else if (head.data == beforeData) {
            Node<T> newNode = new Node<>(newData);
            head.prev = newNode;
            newNode.next = head.next;
            head = newNode;
        } else {
            Node<T> findNode = getNode(beforeData);
            Node<T> newNode = new Node<>(newData);

            newNode.next = findNode;
            if (findNode.prev == null) {
                head = newNode;
            } else {
                newNode.prev = findNode.prev;
                findNode.prev.next = newNode;
            }
            findNode.prev = newNode;
        }
    }

    public void addAfter(T newData, T afterData) {
        if (tail == null) {
            tail = new Node<>(newData);
            head = tail;
        } else if (tail.data == afterData) {
            Node<T> newNode = new Node<>(newData);
            tail.next = newNode;
            newNode.prev = tail.prev;
            tail = newNode;
        } else {
            Node<T> findNode = getNode(afterData);
            Node<T> newNode = new Node<>(newData);

            newNode.prev = findNode;
            if (findNode.next == null) {
                tail = newNode;
            } else {
                newNode.next = findNode.next;
                findNode.next.prev = newNode;
            }
            findNode.next = newNode;
        }
    }

    public T getPrevData(T data) {
        return getNode(data).prev.data;
    }

    public T getNextData(T data) {
        return getNode(data).next.data;
    }

    private Node<T> getNode(T data) {
        if(head == null){
            throw new IllegalStateException("데이터가 존재하지 않습니다.");
        }

        Node<T> node = this.head;
        while (node.hasNext()) {
            if (node.data == data) {
                return node;
            }
            node = node.next;
        }
        if (getTailData() == data) {
            return tail;
        }

        throw new IllegalArgumentException("데이터를 찾을 수 없습니다.");
    }

    private static class Node<T>{
        T data;
        Node<T> next = null;
        Node<T> prev = null;


        public Node(T data) {
            this.data = data;
        }

        public boolean hasNext() {
            return next != null;
        }

        public boolean hasPrev() {
            return prev != null;
        }
    }

    public void add(T data) {
        if (head == null) {
            head = new Node<>(data);
            tail = head;
        } else {
            tail.next = new Node<>(data);
            tail.next.prev = tail;
            tail = tail.next;
        }
    }

    public T getHeadData() {
        return head.data;
    }

    public T getTailData() {
        return tail.data;
    }

    public boolean findFromHead(T data) {
        if (head == null) {
            return false;
        }
        Node<T> node = this.head;
        while (node.hasNext()) {
            if (node.data == data) {
                return true;
            }
            node = node.next;
        }
        if (getTailData() == data) {
            return true;
        }
        return false;
    }

    public boolean findFromTail(T data) {
        if (tail == null) {
            return false;
        }
        Node<T> node = this.tail;
        while (node.hasPrev()) {
            if (node.data == data) {
                return true;
            }
            node = node.prev;
        }
        if (getHeadData() == data) {
            return true;
        }
        return false;
    }
}
