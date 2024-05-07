public interface Set<Item> {
    public void add(Item value);
    public void remove(Item value);
    public boolean contains(Item value);
    public int size();
    public void clear();
}
