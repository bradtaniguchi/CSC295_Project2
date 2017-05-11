package problem1;

/**
 *
 * @author Rudy Leiva
 * @author Bradley Taniguchi
 * 5/1/17
 * CSC 295
 */
public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;
    
    public Ball(int x, int y, int radius, int speed, int direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        xDelta = (float) (Math.cos(Math.toRadians(direction)) * speed);
        yDelta = (float) (Math.sin(Math.toRadians(direction)) * speed);
    }
    public void move() {
        this.x += xDelta;
        this.y += yDelta;
    }
    
    public void reflectHorizontal() {
        this.xDelta = -1 * xDelta;
    }
    public void reflectVertical() {
        this.yDelta = -1 * yDelta;
    }

    @Override
    public String toString() {
        return "Ball at{" + x + ", " + y + ") of velocity {" + xDelta + ", " + yDelta + '}';
    }
    
    
    /*getters and setters*/
    public float getX() {
        return x;
    }
    
    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getxDelta() {
        return xDelta;
    }

    public void setxDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getyDelta() {
        return yDelta;
    }

    public void setyDelta(float yDelta) {
        this.yDelta = yDelta;
    }
    
    public double getSize()
    {
        return ( 4.0 / 3.0 ) * Math.PI * Math.pow( radius, 3 );
    }
}
