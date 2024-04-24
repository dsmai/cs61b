public class SLListLauncher {
    public static void main(String[] args) {
        SLList mylist = new SLList(20);
        mylist.addFirst(7);
        mylist.addFirst(11);

        System.out.println(mylist.getSentinel());
        System.out.println(mylist.getFirst());
        System.out.println(mylist.getLast());
        System.out.println("Size: " + mylist.size());

        mylist.addLastRecursive(100);
        System.out.println(mylist.getSentinel());
        System.out.println(mylist.getFirst());
        System.out.println(mylist.getLast());
        System.out.println("Size: " + mylist.sizeRecursive());

    }
}