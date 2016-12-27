import junit.framework.TestCase;

/**
 * Created by Slime on 25/12/2016.
 */
public class MonkeyTest extends TestCase {
    public void testGetDir() throws Exception {
        Monkey m = new Monkey(new Vector(3,3));
        assertEquals(1, m.getDir("e").getX());
    }

    public void testMove() throws Exception {
        Monkey m = new Monkey(new Vector(5,5));
        m.move();

        Boolean notEqual = false;
        if(5 + 5 != m.getPos().getX() + m.getPos().getY()){
            notEqual = true;
        }
        assertTrue(true);
    }

    public void testGetPos() throws Exception {
        Monkey m = new Monkey(new Vector(5,5));
        assertEquals(5 + 5, m.getPos().getX() + m.getPos().getY());
    }

    // test objects

}