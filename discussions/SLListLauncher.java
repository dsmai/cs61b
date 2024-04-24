public class SLListLauncher {
    public static void main(String[] args) {
        SLList mylist = new SLList(20);
        System.out.println(mylist.getFirst());
        mylist.addFirst(7);
        mylist.addFirst(11);
        System.out.println(mylist.getFirst());
    }
}