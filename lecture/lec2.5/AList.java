public class AList<Item> {
    private Item[] items;
    private int size;
    private double usageRatio;

    // default constructor, empty list of 100 elements
    public AList() {
        items = (Item[]) new Object[100];
        size = 0;
        usageRatio = 0.0;
    }

    private void resize(int toSize) {
        Item[] newArray = (Item[]) new Object[toSize];

        // Copy to new array
        System.arraycopy(items, 0, newArray, 0, size);

        // reassign, copy the bits
        items = newArray;

        usageRatio = size/items.length;
    }

    // sizeDown() method is to release memory of the AList (nulling, so garbage collector can collect) when usage ratio is is below 0.25
    private void sizeDown() {
        int newSize = items.length / 2;

        // for loop to null all memory boxes after newSize
        for (int i = newSize + 1; i < items.length; i++) {
            items[i] = null;
        }

        usageRatio = size/items.length;
    }

    /** Insert x into the back of the list */
    public void addLast(Item x) {
        // Resize the array (copy to new bigger memory location)
        if (size == items.length) { // items.length is the default length of the items array upon creation
            resize(size * 2);
        }
        items[size] = x;
        size++;
        usageRatio = size/items.length;
    }

    /** Delete item from back of the list and return the deleted item */
    public Item removeLast() {
        Item backItem = getLast();
        items[size - 1] = null;
        size--;
        usageRatio = size/items.length;
        return backItem;
    }

    /** Return the item from the back of the list */
    public Item getLast() {
        return items[size - 1];
    }

    public Item get(int index) {
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
