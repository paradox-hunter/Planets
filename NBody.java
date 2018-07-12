public class NBody {
    public static void main(String[] args) {
        
    }

    // method to fetch the radius from the file

    public static double readRadius(String name) {
        In in = new In(name);

        //reading the given file
        in.readInt();
        double rad = in.readDouble();
        return rad;
    }

    public static Planet[] readPlanets(String name) {
        In data = new In(name);

        // reading the given file
        data.readInt();
        data.readDouble();

        Planet[] planets = new Planet[5];
        for (int i = 0; i < 5; i++) {
            double xPos = data.readDouble();
            double yPos = data.readDouble();
            double xVel = data.readDouble();
            double yVal = data.readDouble();
            double mass = data.readDouble();
            String img = data.readString();

            planets[i] = new Planet(xPos, yPos, xVel, yVal, mass, img);
        }
        return planets;

    }
}