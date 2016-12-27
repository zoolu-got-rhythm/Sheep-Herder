import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Slime on 23/12/2016.
 */
public class Map {
    // compose all the objects
    List<Monkey> monkeys = new ArrayList<>();
    int height;
    int width;

    public Map(int height, int width){
        this.height = height;
        this.width = width;

        // spawn monkeys
        for (int i = 0; i < 5; i++){
            monkeys.add(new Monkey(new Vector(i,i)));
        }
    }

    public void turn(){
        Map self = this;
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(self.toString());

                for(Monkey monkey : monkeys){
                    monkey.move();
                    if(!(self.isInside(monkey))) {
                        System.out.println("out of bounds");
                        monkey.undoMove();
                    }

                    if(self.detection()){
                        monkey.undoMove();
                    }
                }
            }
        }, 0, 500);
    }

    public void generateMap(){

    }

    private Boolean isInside(Monkey actor) {
        return actor.getPos().getX() < this.width && actor.getPos().getX() >= 0 &&
                actor.getPos().getY() < this.height && actor.getPos().getY() >= 0;
    }

    private Boolean detection(Monkey monkey) {
            Monkey currentActor = monkey;
            for (int j = 0; j < this.monkeys.size(); j++) {
                if (i != j) { // stops the current actor from checking against itself
                    if (currentActor.getPos().getX() == this.monkeys.get(j).getPos().getX() &&
                            currentActor.getPos().getY() == this.monkeys.get(j).getPos().getY()) {
                        return true;
                    }
                }
            }

        return false;
    }

    // toString
    @Override
    public String toString(){
        String output = "";
        for(int j = 0; j < 20; j++)
            output += "\n";

        // var row = new Array(this.width);
        // var colum = new Array(this.height);

        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.width; y++) {
                Vector place = new Vector(x, y);
                //console.log(place);
                String tile = "-";
                for (int i = 0; i < this.monkeys.size(); i++) {
                    Monkey actor = this.monkeys.get(i);
                    if (actor.getPos().getX() == place.getX() &&
                            actor.getPos().getY() == place.getY()) {
                        tile = "0";
                    }
                }
                output += tile;
            }
            output += "\n";
        }
        output += "monkeys: " + this.monkeys.size();


        return output;
    }
}
