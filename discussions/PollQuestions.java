public class PollQuestions {
    // main driver
    public static void main(String[] args) {
        /**
         * Demonstrate reference (pointer)
         */
        // Create a walrus instance of weight 1000 and tusksize 8.3, assign to
        // variable a of type Walrus (Reference type)
        // So variable a points to that walrus object(1000, 8.3)
        // Memory address of the Walrus instance is copied and stored in variable a (Reference type)
        Walrus a = new Walrus(1000, 8.3);

        // Declare variable b of type Walrus (not point to anything yet)
        Walrus b;

        // Assign a to b
        // Meaning now b points to the same Walrus object(1000, 8.3 as a)
        // a and b point to the same object
        b = a;

        // Modify weight of that object(1000, 8.3)
        b.weight = 20;

        // a and b are the same thing!
        // Note that this is similar to calling System.out.println(a.toString());
        System.out.println(a.toString());
        System.out.println(b.toString());

        /**
         * Now demonstrate something fun
         */
        // Declare variable x of type int, and assign value 5 to it
        int x = 5;

        // Declare variable y of type int, but not assign yet
        int y;

        // Assign/copy value of x to y, now x =5 and y = 5
        // Telling the Java interpreter to copy the bits from x to y
        y = x;

        // Change value of x. However, value of y is still 5
        x = 2;

        // x is 2, y is still 5 (not changed even if x changed)
        System.out.println("x is: " + x);
        System.out.println("y is: " + y);

        Walrus walrus = new Walrus(3500, 10.1);
        int z = 7;

        Walrus.doStuff(walrus, z);
        System.out.println(walrus);
        System.out.println(z);
    }

    // create Walrus nested class
    public static class Walrus {
        public int weight;
        public double tuskSize;

        // constructor
        public Walrus(int weight, double tuskSize) {
            this.weight = weight;
            this.tuskSize = tuskSize;
        }

        public static void doStuff(Walrus W, int z) {
            W.weight = W.weight - 100;
            z = z - 5;
        }

        public String toString() {
            return String.format("weight: %d, tusk size: %.2f", weight, tuskSize);
        }
    }
}