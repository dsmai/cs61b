import java.util.Arrays;
import java.util.ArrayList;

public class NBodyTest {
    public static void main(String[] args) {
        String filepath = "./data/planets.txt";
        // In in = new In(filepath);

        // System.out.println(in.readInt());
        // System.out.println(in.readDouble());

        // // This is to go to the end of current line
        // System.out.println(in.readLine());

        // // This is to get the next line below
        // System.out.println(in.readLine());

        Planet[] outputs = NBody.readPlanets(filepath);

        // print out outputs objects for testing
        System.out.println(Arrays.toString(outputs));
        for (Planet output : outputs) {
            System.out.println(output);
        }

        for (Planet output : outputs) {
            System.out.println(output.imgFileName + ": " + output.xxPos + " " + output.mass);
        }

        ArrayList<Planet> outputs_list = NBody.readPlanetsArrayList(filepath);
        // print out the outputs ArrayList
        for (Planet output_element : outputs_list) {
            System.out.println(output_element.imgFileName + ": " + output_element.xxPos + " " + output_element.mass);
        }

    }
}