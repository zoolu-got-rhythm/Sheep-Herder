import java.util.HashMap;

/**
 * Created by Slime on 25/12/2016.
 */

// unit tests help you find flaws in your logic quikly, detach yourself from "your" code.
public class Monkey {
    private String[] direction = "n e s w".split(" ");
    private HashMap<String, Vector> dir = new HashMap<>(4);

    private Vector pos;
    private Vector prevPos;

    public Monkey(Vector origin){
        // initialize
        dir.put("n", new Vector(0,1));
        dir.put("e", new Vector(1, 0));
        dir.put("s", new Vector(-1, 0));
        dir.put("w", new Vector(0, -1));
        this.pos = origin;
        this.prevPos = pos;

    }

    public void move(){
        this.prevPos = this.pos;
        this.pos = this.pos.plot(dir.get(this.direction[(int) Math.floor(Math.random() * direction.length)]));
    }

    public void undoMove(){
        this.pos = this.prevPos;
    }

    public Vector getPos(){
        return this.pos;
    }

    public Vector getDir(String d){
        return this.dir.get(d);
    };

    @Override
    public String toString(){
        return this.pos.getX() + ", " + this.pos.getY();
    }
}
