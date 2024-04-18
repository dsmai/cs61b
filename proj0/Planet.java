import java.util.Scanner;
import java.util.ArrayList;

public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    public static final double G_const = 6.67e-11;

    // constructor
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    // another constructor, take in a Planet and initialize an identical Planet object (a copy)
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass  = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        double dx = xxPos - p.xxPos;
        double dy = yyPos - p.yyPos;
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    // Calculate force exerted by planet p on the given planet
    public double calcForceExertedBy(Planet p) {
        double distance = calcDistance(p);
        double force = (G_const * mass * p.mass) / (distance * distance);
        return force;
    }

    public double calcForceExertedByX(Planet p) {
        double dx = p.xxPos - xxPos;
        double distance = calcDistance(p);
        double force = calcForceExertedBy(p);
        return (force * dx) / distance;
    }

    public double calcForceExertedByY(Planet p) {
        double dy = p.yyPos - yyPos;
        double distance = calcDistance(p);
        double force = calcForceExertedBy(p);
        return (force * dy) / distance;
    }

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

}
