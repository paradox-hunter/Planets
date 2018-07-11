public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVal;
    public double yyVal;
    public double mass;
    public String ImgFileName;

    //**constructor function */
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xp;
        yyPos = yp;
        xxVal = xV;
        yyVal = yV;
        mass = m;
        ImgFileName = img;

    }

    //** constructor for the planet class */
    public Planet(Planet p) {
        Planet = p;
    }
}