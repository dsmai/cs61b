import java.util.Scanner;
import java.util.ArrayList;

public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    // G constant definition
    public static final double G_const = 6.67e-11;

    // Default constructor, initialize to all 0
    public Planet() {
        xxPos = 0.0;
        yyPos = 0.0;
        xxVel = 0.0;
        yyVel = 0.0;
        mass = 0.0;
        imgFileName = "";
    }

    /**
     * Detailed constructor
     * @param xP
     * @param yP
     * @param xV
     * @param yV
     * @param m
     * @param img
     */
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    /**
     * Constructor that takes in a planet and initialize an identical Planet object (a copy)
     * @param p a planet in argument
     */
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass  = p.mass;
        imgFileName = p.imgFileName;
    }

    /**
     * Calculate distance between said planet and the planet in argument
     * @param p a planet in argument
     * @return distance
     */
    public double calcDistance(Planet p) {
        double dx = xxPos - p.xxPos;
        double dy = yyPos - p.yyPos;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    /**
     * Calculate force exerted by planet p on the said planet
     * @param p a planet in argument
     * @return force
     */
    public double calcForceExertedBy(Planet p) {
        double distance = calcDistance(p);
        double force = (G_const * mass * p.mass) / (distance * distance);
        return force;
    }

    /**
     * Calculate xForce exerted on said planet by the planet in argument
     * @param p a planet in argument
     * @return xForce
     */
    public double calcForceExertedByX(Planet p) {
        double dx = p.xxPos - xxPos;
        double distance = calcDistance(p);
        double force = calcForceExertedBy(p);
        return (force * dx) / distance;
    }

    /**
     * Calculate yForce exerted on said planet by the planet in argument
     * @param p a planet in argument
     * @return yForce
     */
    public double calcForceExertedByY(Planet p) {
        double dy = p.yyPos - yyPos;
        double distance = calcDistance(p);
        double force = calcForceExertedBy(p);
        return (force * dy) / distance;
    }

    /**
     * Calculate total net xForce exerted on said planet by list of planets in argument
     * @param planets group of planets
     * @return total net xForce
     */
    public double calcNetForceExertedByX(Planet[] planets) {
        double totalNetForceX = 0.0;
        for (Planet planet : planets) {
            if (!this.equals(planet)) {
                // if not the same planet, than calculate force and add to totalNetForceX
                totalNetForceX += calcForceExertedByX(planet);
            }
        }
        return totalNetForceX;
    }

    /**
     * Calculate total net yForce exerted on said planet by list of planets in argument
     * @param planets group of planets
     * @return total net yForce
     */
    public double calcNetForceExertedByY(Planet[] planets) {
        double totalNetForceY = 0.0;
        for (Planet planet : planets) {
            if (!this.equals(planet)) {
                // if not the same planet, than calculate force and add to totalNetForceX
                totalNetForceY += calcForceExertedByY(planet);
            }
        }
        return totalNetForceY;
    }

    /**
     * Update x and y position of planet, given net xForce and yForce exerted on it
     * @param dt
     * @param fX net xForce exerted on the said planet
     * @param fY net yForce exerted on the said planet
     */
    public void update(double dt, double fX, double fY) {
        double ax = fX / mass;
        double ay = fY / mass;

        // calculate new velocity
        xxVel += ax * dt;
        yyVel += ay * dt;

        // calculate new position
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

    /**
     * Draw the planet using x and y position on canvas.
     *  */ 
    public void draw() {
        StdDraw.picture(xxPos, yyPos, "./images/" + imgFileName);
    }

}
