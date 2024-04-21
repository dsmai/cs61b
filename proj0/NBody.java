import java.util.ArrayList;
import java.util.Collection; // import the Collection class to sort ArrayList

public class NBody {
    private static String imageToDraw = "./images/starfield.jpg";
    public static void main(String[] args) {
        // read input from command line args
        double T = Double.valueOf(args[0]);
        double dt = Double.valueOf(args[1]);
        String filename = args[2];
        // read input from files
        double universe_radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        // draw
        // first, set scale
        StdDraw.setScale(-universe_radius, universe_radius);
        StdDraw.enableDoubleBuffering();

        // clear the drawing window
        StdDraw.clear();
        StdDraw.picture(0, 0, imageToDraw);

        // show the galaxy picture
        StdDraw.show();

        double[] xForces = new double[planets.length];
        double[] yForces = new double[planets.length];
        for (int i = 0; i <= T; i += dt) {
            for (int index = 0; index < planets.length; index++) {
                xForces[index] = planets[index].calcNetForceExertedByX(planets);
                yForces[index] = planets[index].calcNetForceExertedByY(planets);
            }

            // call update on each planet
            for (int index = 0; index < planets.length; index++) {
                planets[index].update(dt, xForces[index], yForces[index]);
            }

            // draw the background again
            StdDraw.picture(0, 0, imageToDraw);

            // draw all the planets
            for (Planet planet : planets) {
                planet.draw();
            }

            // Show the offscreen buffer
            StdDraw.show();

            // Pause the animation for 10 milliseconds
            StdDraw.pause(10);
        }

        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", universe_radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                          planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                          planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
    }

    private static void testAnimation() {
        StdDraw.setScale(-2.0, +2.0);
        StdDraw.enableDoubleBuffering();
     
        for (double t = 0.0; true; t += 0.02) {
            double x = Math.sin(t);
            double y = Math.cos(t);
            StdDraw.clear();
            StdDraw.filledCircle(x, y, 0.1);
            StdDraw.filledCircle(-x, -y, 0.1);
            StdDraw.show();
            StdDraw.pause(20);
        }
    }

    private static void planetsAnimation(double dt, double T, String filename) {
        // read planets from file and draw them
        Planet[] planets = readPlanets(filename);

        for (int i = 0; i <= T; i += dt) {
            // update
            for (Planet planet : planets) {
                planet.update(dt, planet.calcNetForceExertedByX(planets), planet.calcNetForceExertedByY(planets));
            }

            StdDraw.picture(0, 0, imageToDraw);
            // draw (copy from offscreen canvas to onscreen canvas)
            for (Planet planet : planets) {
                planet.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
        }
    }

    public static double readRadius(String filename) {
        In in = new In(filename);
        int number_of_planets = in.readInt();
        double universe_radius = in.readDouble();

        // return the radius of the universe in that planet
        return universe_radius;
    }

    public static Planet[] readPlanets(String filename) {
        // create an In instance from In class (like scanner)
        In in = new In(filename);

        // read the first and second item
        int number_of_planets = in.readInt();
        double universe_radius = in.readDouble();

        // Create an array of Planet, using "new" keywords
        Planet[] planets = new Planet[number_of_planets];

        // starting from line 3, loop through each line until find line staring with [!], then stop
        // for (int i = 0; i < planets.length; i++)
        // in each line, assign planets[i].xxPos, planets[i].yyPos etc from in.readDouble() (first 5, last one is in.readString())

        for (int i = 0; i < number_of_planets; i++) {
            // create an instance of Planet class, using "new" default constructor
            planets[i] = new Planet(0, 0, 0, 0, 0, "");

            planets[i].xxPos = in.readDouble();
            planets[i].yyPos = in.readDouble();
            planets[i].xxVel = in.readDouble();
            planets[i].yyVel = in.readDouble();
            planets[i].mass  = in.readDouble();
            planets[i].imgFileName  = in.readString();
        }

        return planets;
    }

    // Read Planets but using ArrayList
    private static ArrayList<Planet> readPlanetsArrayList(String filename) {
        In in = new In(filename);

        int number_of_planets = in.readInt();
        double universe_radius = in.readDouble();

        // Initiate an array list of Planets
        ArrayList<Planet> planets_list = new ArrayList<>();

        for (int i = 0; i < number_of_planets; i++) {
            // create an instance of Planet class, using "new" default constructor
            Planet a_planet = new Planet(0, 0, 0, 0, 0, "");

            a_planet.xxPos = in.readDouble();
            a_planet.yyPos = in.readDouble();
            a_planet.xxVel = in.readDouble();
            a_planet.yyVel = in.readDouble();
            a_planet.mass  = in.readDouble();
            a_planet.imgFileName  = in.readString();
            
            // add the planet to the ArrayList
            planets_list.add(a_planet);
        }

        return planets_list;
    }
}