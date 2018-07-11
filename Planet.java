//** class definition of Planet Class */
public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

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
        double distance;
        double dx = this.xxPos - p.xxPos;
        double dy = this.yyPos - p.yyPos;
        dx *= dx;
        dy *= dy;
        return distance = Math.sqrt(dx + dy);
    }
}