/**
 * Test Planet class
 */

public class TestPlanet {
    // main method
    public static void main(String[] args) {
        checkPlanetForces();
    }

    /**
     * Check equals method to check 2 Doubles
     * 
     * @param  expected     Expected double
     * @param  actual       Received double
     * @param  label        Label for the 'test' case
     * @param  eps          Tolerance for the double comparison.
     */
    private static void checkEquals(double actual, double expected, String label, double eps) {
        if (Math.abs(expected - actual) <= eps * Math.max(expected, actual)) {
            System.out.println("PASS: " + label + ": Expected " + expected + " and you gave " + actual);
        } else {
            System.out.println("FAIL: " + label + ": Expected " + expected + " and you gave " + actual);
        }
    }

    /**
     *  Method to check Planet class
     *  Create 2 planets and prints out the pairwise force between them
     */
    private static void checkPlanetForces() {
        System.out.println("Checking Planet class...");

        Planet sun = new Planet(1.0, 2.0, 3.0, 4.0, 5.0, "sun.gif");
        Planet saturn = new Planet(3.0, 4.0, 3.0, 5.0, 2.0, "saturn.gif");

        checkEquals(sun.calcForceExertedBy(saturn), Planet.G_const * 1.25, " calcForceExertedBy()", 0.01);
    }
}