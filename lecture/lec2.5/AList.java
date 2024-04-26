public class AList {
    private int[] items;
    private int size;
    private double usageRatio;

    // default constructor, empty list of 100 elements
    public AList() {
        items = new int[100];
        size = 0;
        usageRatio = 0.0;
    }

    private void resize(int toSize) {
        int[] newArray = new int[toSize];

        // Copy to new array
        System.arraycopy(items, 0, newArray, 0, size);

        // reassign, copy the bits
        items = newArray;

        usageRatio = size/items.length;
    }

    private void resize() {
        int[] newArray = new int[items.length / 2];

        // copy to the new array
        System.arraycopy(items, 0, newArray, 0, size);

        // reassign, copy the bits
        items = newArray;

        usageRatio = size/items.length;
    }

    /** Insert x into the back of the list */
    public void addLast(int x) {
        // Resize the array (copy to new bigger memory location)
        if (size == items.length) { // items.length is the default length of the items array upon creation
            resize(size * 2);
        }
        items[size] = x;
        size++;
        usageRatio = size/items.length;
    }

    public void removeLast() {
        items[size - 1] = 0;
        size--;
        usageRatio = size/items.length;
    }

    /** Return the item from the back of the list */
    public int getLast() {
        return items[size - 1];
    }

    public int get(int index) {
        return items[index];
    }

    public int size() {
        return size;
    }

    public int length() {
        return items.length;
    }

    public void printAList() {
        for (int i = 0; i < size; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}
