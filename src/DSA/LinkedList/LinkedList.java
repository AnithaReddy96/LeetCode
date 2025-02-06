package DSA.LinkedList;


import java.util.NoSuchElementException;

public class LinkedList {
    private static class Node {
        private int val;
        private Node next;
        private int size;


        private Node(int val){
            this.val=val;
            this.next = null;
        }

    }

    private  Node first;
    private  Node last;
    private int size;

    //addFirst

    public void addFirst(int item){
       Node node = new Node(item);

       if(isEmpty()){
           first=last=node;
       }else{
           node.next = first;
           first = node;
       }
        size++;
    }

    //addLast

    public void addLast(int item){
        Node node = new Node(item);

        if(isEmpty()){
            first=last=node;
        }
        else{
            last.next = node;
            last = node;
        }
        size++;
    }
    //deleteFirst
    public void deleteFirst(){
        if(isEmpty())
            throw new NoSuchElementException();
        if(first==last)
            first=last=null;
        else
            first = first.next;
        size--;
    }
    //deleteLast

    public void deleteLast(){
        Node current = first;
        while(current.next!=null){
            current = current.next;
        }
        last = current;
        last.next = null;
        size--;
    }

    //contains
    public boolean contains(int item){
        return indexOf(item)!=-1;
    }
    //indexOf
    public int indexOf(int item){
        Node current = first;
        int index=0;

        while(current!=null){
            if(current.val==item)
                return index;
            else {
                current= current.next;
                index++;
            }


        }
        return -1;
    }

    public  boolean isEmpty(){
        return first==null;
    }

    public int size() {
        return size;
    }

    public int[] toArray(){
        int[] array = new int[size];
        Node current = first;
        int index =0;
        while(current!=null){
            array[index++] = current.val;
            current = current.next;
        }
        return array;
    }




}
