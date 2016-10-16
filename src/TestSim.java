/**
 * Created by Slime on 14/10/2016.
 */
public class TestSim {

    public static void main(String[] args){
        System.out.println("safdsaf");
        System.out.println(
            new Thing().getInstance().getState().getInstance().setState("blah").getInstance().getInstance().getInstance().getState()
        );
    }

    // singleton
    private static class Thing{
        private static String state;
        private static Thing instance = null;

        protected Thing(){
            System.out.println(this.getClass() + " is initializing");
            // run code to be initalised
            this.state = "singleton..";
        }

        public static Thing getInstance(){
            if(instance == null){
                instance = new Thing();
            }else{
                System.out.println("already instantiated");
            }
            return instance;
        }

        public static Thing getState(){
            System.out.println(state);
            return instance;
        }

        public static Thing setState(String msg){
            state = msg;
            return instance;
        }
    }
}