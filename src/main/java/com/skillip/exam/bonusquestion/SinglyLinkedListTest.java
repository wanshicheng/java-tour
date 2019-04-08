package com.skillip.exam.bonusquestion;

import java.util.List;

public class SinglyLinkedListTest {
    public static void main(String[] args) {

    }
}

// 一个链表节点由数据字段和链接字段两个字段组成
class SinglyLinkedList<T> {
    private Node first;
    private Node last;


    public boolean isEmpty(){
        return false;
    }

    public void print() {

    }

    public void insert(T t) {

    }

    class Node<T> {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = next;
        }
    }
}
