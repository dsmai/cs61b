public class IntListLauncher {
    public static void main(String[] args) {
        IntList mylist = new IntList(5, null);
        mylist.rest = new IntList(10, null);
        mylist.rest.rest = new IntList(15, null);

        // System.out.println("Here is my simple linked list: " + mylist.first + ", " + mylist.rest.first + ", " + mylist.rest.rest.first);
        System.out.println("Size: " + mylist.size() + ", " + mylist.iterativeSize());
        System.out.println(mylist.get(Integer.valueOf(args[0])));
    }

    // IntList here is a nested class under IntListLauncher, so it acts like an instance variable
    // It cannot be accessed directly from the outer class's static method (such as main)
    // 2 ways to fix:
    // 1st way: moving the IntList class outside the IntListLauncher (example: class IntList)
    // 2nd way: add public static class IntList so it is now a nested static class (like a static variable)
    public static class IntList {
        public int first;    // this is the value of the node

        // rest is the pointer to the next node
        public IntList rest; // rest is a box of 64 bits to store address, but now just empty

        // constructor
        public IntList(int f, IntList r) {
            first = f;
            rest = r;
        }

        /**
         * Get size of linkedlist using recurssion
         * Important: need a base case => the next elemenet is null, or rest is null
         * If rest is null, return 1
         * Need a function that calls itself
         * @return
         */
        public int size() {
            if (rest == null) {
                return 1;
            }
            // if not base case, call itself (remember need to have a way to go down to the base case). Also add one because have to count the current one
            return 1 + rest.size();
        }

        /**
         * Get size but using iteration, not recursion
         * Initialize the size to 0
         * Need to have a way to iterate over the list, basically this = this.rest
         * Stop/exit when this = null
         * @return
         */
        public int iterativeSize() {
            int totalSize = 0;
            IntList p = this;
            while (p != null) {
                totalSize++;
                p = p.rest;
            }
            return totalSize;
        }

        /**
         * Need to iterate to get to position ith, starting from 0
         * @param i
         * @return
         */
        public int get(int i) {
            IntList p = this;
            int position = 0;
            while (position < i) {
                p = p.rest;
                position++;
            }
            return p.first;
        }
    }
}