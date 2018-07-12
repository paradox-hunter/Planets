//** class definition of Planet Class */
public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    //** declaring the gravitational constant */
    final static double G = 6.67e-11; 

    //** parameterized constructor function */
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;

    }

    //** copy constructor for the planet class 
    //** source for learning https://abhiandroid.com/java/constructor */
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    //** creating the methods for the class Planet */

    //** method to calculate distance b/w the calling planet and the passed planet */

    public double calcDistance(Planet p) {
        double dx = this.xxPos - p.xxPos;
        double dy = this.yyPos - p.yyPos;
        dx *= dx;
        dy *= dy;
        return Math.sqrt(dx + dy);
    }

    //** method to caculate the force exerted by the bodies */

    public double calcForceExertedBy(Planet p) {
        double r_square = this.calcDistance(p);
        r_square *= r_square;
        double force = (G * this.mass * p.mass) / r_square;
        return force;
    }

    //** method to calculate force exerted in the X axis */

    public double calcForceExertedByX(Planet p) {
        double dx = p.xxPos - this.xxPos;
        double f_x = (calcForceExertedBy(p) * dx) / calcDistance(p);
        return f_x;
    }

    //** method to calculate force exerted in the Y axis */

    public double calcForceExertedByY(Planet p) {
        double dy = p.yyPos - this.yyPos;
        double f_y = (calcForceExertedBy(p) * dy) / calcDistance(p);
        return f_y;
    }

    //** method to calculate the total force in the X direction */

    public double calcNetForceExertedByX(Planet planets[]) {
        double netForceInX = 0;
        for (Planet p : planets) {
            if (p.equals(this)) {
                continue;
            }
            netForceInX += calcForceExertedByX(p);
        }
            return netForceInX;
    }

    //** method to calculate the total force in the Y direction */

    public double calcNetForceExertedByY(Planet planets[]) {
        double netForceInY = 0;
        for (Planet p : planets) {
            if (p.equals(this)) {
                continue;
            }
            netForceInY += calcForceExertedByY(p);
        }
            return netForceInY;
    }

    //** method to update the position of the planet */

    public void update(double dt, double fX, double fY) {
    // calculating the acceleration
        double aX = fX / this.mass;
        double aY = fY / this.mass;

        // calculating the velocities
        this.xxVel = this.xxVel + (aX * dt);
        this.yyVel = this.yyVel + (aY * dt);

        //updating the position
        this.xxPos = this.xxPos + (this.xxVel * dt);
        this.yyPos = this.yyPos + (this.yyVel * dt);
    }

    //** method to draw the planets */

    public void Draw() {
        StdDraw.picture(this.xxPos, this.yyPos, this.imgFileName);
    }
}