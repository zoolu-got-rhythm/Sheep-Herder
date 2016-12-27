/**
 * Created by Slime on 24/12/2016.
 */
class Vector {
    private int x;
    private int y;

    public Vector(int x, int y) {
        // System.out.println(this.getClass() + " initializing");
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
