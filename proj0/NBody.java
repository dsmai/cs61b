import java.util.ArrayList;
import java.util.Collection; // import the Collection class to sort ArrayList

public class NBody {
    public static double readRadius(String filename) {
        In in = new In(filename);
        int firstItem = in.readInt();
        double secondItem = in.readDouble();

        // return the radius of the universe in that planet
        return secondItem;
    }

    public static Planet[] readPlanets(String filename) {
        // create an In instance from In class (like scanner)
        In in = new In(filename);

        // read the first and second item
        int firstItem = in.readInt();
        double secondItem = in.readDouble();

        // Create an array of Planet, using "new" ketwords
        Planet[] planets = new Planet[5];

        // starting from line 3, loop through each line until find line staring with [!], then stop
        // for (int i = 0; i < planets.length; i++)
        // in each line, assign planets[i].xxPos, planets[i].yyPos etc from in.readDouble() (first 5, last one is in.readString())

        for (int i = 0; i < planets.length; i++) {
            // create an instance of Planet class, using "new" default constructor
            planets[i] = new Planet();

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
    public static ArrayList<Planet> readPlanetsArrayList(String filename) {
        In in = new In(filename);

        int firstItem = in.readInt();
        double secondItem = in.readDouble();

        // Initiate an array list of Planets
        ArrayList<Planet> planets_list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            // create an instance of Planet class, using "new" default constructor
            Planet a_planet = new Planet();

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