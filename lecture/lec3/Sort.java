public class Sort {

    // Sort string destructively
    public static void sort(String[] x) {
        // call recursive on the rest of the array
        sort(x, 0);
    }

    // Sort starting from an index
    private static void sort(String[] x, int start) {
        if (start == x.length) {
            return;
        }

        int smallestIndex = findSmallest(x, start);

        // swap
        swap(x, start, smallestIndex);

        // call recursive
        sort(x, start + 1);
    }

    public static int findSmallest(String[] x, int start) {
        int smallestIndex = start;
        for (int i = start + 1; i < x.length; i++) {
            if (x[i].compareTo(x[smallestIndex]) < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    public static void swap(String[] x, int a, int b) {
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }


}