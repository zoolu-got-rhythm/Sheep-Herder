import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Slime on 15/10/2016.
 */
public class TestTimer {
    public int x = 0;

    public static void main(String[] args){
        new TestTimer();
    }

    public TestTimer(){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                // System.out.;
                for(int i = 0; i <= 50; i++){
                    System.out.println("\n");
                }
                System.out.println(x);
                x++;
            }
        }, 0, 1000);
    }
}
