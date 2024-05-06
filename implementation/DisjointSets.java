public interface DisjointSets {
    /** connect tow items P and Q */
    void connect(int p, int q);

    /** check to see if two items are connected */
    boolean isConnected(int p, int q);
}