import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Slime on 15/10/2016.
 */
public class TestTimer {
    public int x = 0;
    public Timer timer;

    public static void main(String[] args){
        TestTimer timer = new TestTimer();
        TestTimer timer2 = new TestTimer();
        timer.start(10);
        timer2.start(30);
    }

    public TestTimer(){
        this.timer = new Timer();
    }

    public void start(int secs){
        TestTimer self = this;
        this.timer.schedule(new TimerTask() {
            @Override
            public void run() {
            System.out.println(x);
            if(self.x == secs) {
                System.out.println("should stop");
                stop();
            }
            x++;
            }
        }, 0, 1000);
    }

    private void stop(){
        this.timer.cancel();
    }
}
