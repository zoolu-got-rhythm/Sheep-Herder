import junit.framework.TestCase;

/**
 * Created by Slime on 24/12/2016.
 */
public class VectorTest extends TestCase {
    public void testGetX() throws Exception {
        Vector co1 = new Vector(2,2);
        assertEquals(2, co1.getX());
    }

    public void testGetY() throws Exception {
        Vector co1 = new Vector(2,2);
        assertEquals(2, co1.getY());
    }

    public void testPlot() throws Exception {
        Vector co1 = new Vector(2,2);
        Vector co2 = co1.plot(new Vector(2,4));
        assertEquals(4 + 6, co2.getX() + co2.getY());
    }

}