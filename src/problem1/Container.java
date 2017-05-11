package problem1;

/**
 *
 * @author Rudy Leiva
 * @author Bradley Taniguchi
 * 5/1/17
 * CSC 295
 */
public class Container {
    private int x1; //bottom left
    private int y1; //bottom left
    
    private int x2; //top right
    private int y2;// top right
    public Container(int x, int y, int width, int height) {
        this.x1 = x;
        this.y1 = y;
        
        this.x2 = x + width;
        this.y2 = y + height;
    }
    public boolean collidesWith(Ball ball) {
        /*check if the ball is outside of the box*/
        if(ball.getX() + ball.getRadius() >= x2 || ball.getX() - ball.getRadius() <= x1) {
            //System.out.println("The size of the ball is: " + ball.getSize());
            ball.reflectHorizontal();
            return true;
        }
        if(ball.getY() + ball.getRadius() >= y2 || ball.getY() - ball.getRadius() <= y1) {
            //System.out.println("The size of the ball is: " + ball.getSize());
            ball.reflectVertical();
            return true;
        }
        return false;
                
    }

    @Override
    public String toString() {
        return "Container at {" + x1 + ", " + y1 + "} to {" + x2 + ", " + y2 + '}';
    }
    
    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }
    
}
