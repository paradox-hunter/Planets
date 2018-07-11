public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    //**constructor function */
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        ImgFileName = img;

    }

    //** constructor for the planet class */
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVal = p.xxVel;
        yyVal = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
}