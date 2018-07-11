public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVal;
    public double yyVal;
    public double mass;
    public String imgFileName;

    //**constructor function */
    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVal = xV;
        yyVal = yV;
        mass = m;
        ImgFileName = img;

    }

    //** constructor for the planet class */
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVal = p.xxVal;
        yyVal = p.yyVal;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
}