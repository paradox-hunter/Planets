public class NBody {
    public static void main(String[] args) {

        /** getting the command line arguements */
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        /** Drawing tha canvas, the background and the planets fro the given input file */
        
        /** initializing an array of planets */
        Planet[] planets = readPlanets(filename);

        /**reading radius from the given file */
        double radius = readRadius(filename);

        /** creating the canvas */
        StdDraw.setScale(-radius, radius);

        /** clearing the drawing area */
        StdDraw.clear();

        /** initializeing and creating the background
         */
        String fileToDraw = "./images/starfield.jpg";
        StdDraw.picture(0, 0, fileToDraw); 

        /** drawing the array of planets on the canvas */
        for (Planet p: planets) {
            p.Draw();
        }

        /** Animation part 
         * The idea is to clear the canvas and draw the pictures of the planets
         * on the background. 
         * Then we discretize the time, calculate the change in the position of the planets,
         * and then redraw the universe. */
        

        // enabling buffering to avoid flickering during animation
        StdDraw.enableDoubleBuffering();

        double run_time = 0;
        int numberOfPlanets = planets.length; 

        while(run_time < T) {
            double[] xForces = new double[numberOfPlanets];
            double[] yForces = new double[numberOfPlanets];
            
            // calculating the net forces and storing in the arrays for each planets
            for (int i = 0; i < numberOfPlanets; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            // loop to update all the planets' positions
            int planetIndex = 0;
            while(planetIndex < numberOfPlanets) {
                for(Planet k: planets) {
                    k.update(dt, xForces[planetIndex], yForces[planetIndex]);
                planetIndex += 1;
                }
            }

            /* drawing the canvas and the planets to create the animation 
            * notice that this process if exactly the copy of the simple static
            * canvas drawn earlier */

            StdDraw.setScale(-radius, radius);
            StdDraw.clear();
            StdDraw.picture(0, 0, fileToDraw);
            for (Planet p: planets) {
                p.Draw();
            }

            /* using the show method of the StdDraw library to load the buffer */
            /* Shows the drawing to the screen, and waits 2000 milliseconds. */
		    StdDraw.show();
		    StdDraw.pause(10);
            // updating the loop variable run_time to calculate the next iteration of the position

            run_time += dt;
        }

        /* printing the state of the universe */
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
            planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
        }
        
    }

    /** method to fetch the radius from the file */

    public static double readRadius(String name) {
        In in = new In(name);

        //reading the given file
        in.readInt();
        double rad = in.readDouble();
        return rad;
    }

    public static Planet[] readPlanets(String name) {
        In data = new In(name);

        // skipping the irrelevant data in the file for htis function
        data.readInt();
        data.readDouble();

        /** creating an array of Planet objects */
        Planet[] planets = new Planet[5];

        //reading the file data one by one
        for (int i = 0; i < 5; i++) {
            double xPos = data.readDouble();
            double yPos = data.readDouble();
            double xVel = data.readDouble();
            double yVal = data.readDouble();
            double mass = data.readDouble();
            String img = data.readString();

            //instantiating the array with Planet objects using the constructor
            planets[i] = new Planet(xPos, yPos, xVel, yVal, mass, img);
        }
        return planets;

    }
}