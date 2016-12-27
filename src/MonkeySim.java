import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Slime on 05/09/2016.
 */

class MonkeySim {

    private static String[] directions = "n e s w".split(" ");
    private HashMap<String, Vector> dir = new HashMap<String, Vector>(4);

    public MonkeySim() {

    }

    // this class is run on the default main thread
    public static void main(String[] args) {
        try {
            new MonkeySim().new Map(10, 10, 3).turn();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public class Map {
        // beware of how you can combine different expressions within expressions etc.
        // private members
        private int height, width;
        private ArrayList<Monkey> actors = new ArrayList<Monkey>();


        public Map(int height, int width, int n) {
            System.out.println(this.getClass() + " initializing");

            this.height = height;
            this.width = width;

            dir.put("n", new Vector(1, 0));
            dir.put("e", new Vector(0, 1));
            dir.put("s", new Vector(-1, 0));
            dir.put("w", new Vector(0, -1));

            int counter = 0;
            for (int row = 0; row <= this.height; row++) {
                for (int c = 0; c <= height; c++) {
                    if (counter < n) {
                        this.actors.add(new Monkey(new Vector(row, c)));
                    } else {
                        break; // or return?
                    }
                    counter++;
                }
            }
        }

        public Map() {
        }

        public void turn() {
            // need a clear terminal/console line of code here.
            System.out.println(toString());

            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    for (Monkey actor : actors) {
                        if (detection())
                            actor.undoMove();

                        if (!(isInside(actor)))
                            actor.undoMove();
                    }
                }
            }, 0, 100);
        }

        private Boolean isInside(Monkey actor) {
            return actor.getX() < width && actor.getX() >= 0 &&
                    actor.getY() < height && actor.getY() >= 0;
        }

        private Boolean detection() {
            for (int i = 0; i < this.actors.size(); i++) {
                Monkey currentActor = this.actors.get(i);
                for (int j = 0; j < this.actors.size(); j++) {
                    if (i != j) { // stops the current actor from checking against itself
                        if (currentActor.getX() == this.actors.get(j).getX() &&
                                currentActor.getY() == this.actors.get(j).getY()) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        @Override
        public String toString() {
            String output = "";

            // make rows and columns
            for (int x = 0; x < this.width; x++) {
                for (int y = 0; y < this.width; y++) {
                    Vector place = new Vector(x, y);
                    //console.log(place);
                    String tile = "-";
                    for (int i = 0; i < this.actors.size(); i++) {
                        Monkey actor = this.actors.get(i);
                        System.out.println(this.actors.get(i));
                        if (actor.getX() == place.getX() &&
                                actor.getY() == place.getY()) {
                            tile = "0";
                        }
                    }
                    output += tile;
                }
                output += "\n";
            }
            output += "monkeys: " + this.actors.size();

            return output;
        }
    }


    class Monkey{
        private Vector prevPos;
        private Vector pos;
        private String[] directions;

        public Monkey(Vector prevPos) {
            System.out.println(this.getClass() + " initializing");

            this.prevPos = prevPos;
            this.directions = directions;
            //this.pos;
        }


        public void move(){
            int r = (int) Math.floor(Math.random() * directions.length);
            String randomDirection = directions[r];
            Vector newPos = dir.get(randomDirection);

            this.prevPos = this.pos;
            this.pos = pos.plot(newPos);
        }

        public void undoMove(){
            this.pos = this.prevPos;
        }

        public int getX(){
            return this.pos.getX();
        }

        public int getY(){
            return this.pos.getY();
        }

        public Vector getPosition(){
            return this.pos;
        }
    }



    class Vector {
        private int x;
        private int y;

        public Vector(int x, int y) {
            System.out.println(this.getClass() + " initializing");
            this.x = x;
            this.y = y;
        }


        public int getX() {
            return this.x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return this.y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Vector plot(Vector other){
            return new Vector(this.getX() + other.getX(), this.getY() + other.getY());
        }
    }

}


