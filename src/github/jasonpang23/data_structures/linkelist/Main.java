package github.jasonpang23.data_structures.linkelist;

public class Main {

    public static void main(String[] args) {

        LinkedList<Integer> linkList = new LinkedList<>() ;
        for (int i = 0; i < 10; i++) {
            linkList.addFirst(i+1);
            System.out.println(linkList);
        }
        linkList.add(2,3324);
        System.out.println(linkList);
        linkList.remove(2);
        System.out.println(linkList);

        linkList.removeFirst();
        System.out.println(linkList);
        linkList.removeLast();
        System.out.println(linkList);

    }
}
