package DSA.LinkedList;

public class Test {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
       // System.out.println(list);
        list.addLast(40);
        System.out.println(list.indexOf(40));
      //  list.reverse();
    }
}
