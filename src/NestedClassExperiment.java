/**
 * Created by Slime on 15/10/2016.
 */
public class NestedClassExperiment {
    private int global = 1;

    class FirstLevel{
        public int local = 2;
        public FirstLevel(int local, Thing x){
            System.out.println(global);
            System.out.println(local);
            System.out.println(this.local);
            System.out.println(x.local);
        }
    }

    class Thing{
        public int local = 4;

        public int instantiateSelf(){
            return new Thing().local;
        }
    }



    public static void main(String... args) {
        System.out.println(new NestedClassExperiment().new FirstLevel(
                3, new NestedClassExperiment().new Thing()
        ).local);

        System.out.println(new NestedClassExperiment().new Thing().instantiateSelf());
    }
}
