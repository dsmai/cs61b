public class Launcher {
    public static void main(String[] args) {
        AList mylist = new AList();
        mylist.addLast(15);
        mylist.addLast(20);
        mylist.addLast(30);
        mylist.printAList();
        mylist.addLast(40);
        mylist.printAList();
        System.out.println(mylist.size());
        System.out.println(mylist.length());
        mylist.addLast(50);
        mylist.addLast(60);
        System.out.println(mylist.size());
        System.out.println(mylist.length());
        mylist.addLast(70);
        mylist.addLast(80);
        System.out.println(mylist.size());
        System.out.println(mylist.length());
    }
}