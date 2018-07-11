public class NBody {
    public static void main(String[] args) {
        
    }

    // method to fetch the radius from the file

    public static double readRadius(String name) {
        In in = new In(name);

        //reading the given file
        int numberOfPlanets = in.readInt();
        double rad = in.readDouble();
        return rad;
    }

    public static Planet[] readPlanets(String name) {
        In in = new In(name);

        // reading the given file
        int numberOfPlanets = in.readInt();
        double rad = in.readDouble();

        Planet planets = new Planet[5];
        for (int i = 0; i < 5; i++) {
            
        }


    }
}