package problem1;

/**
 *
 * @author Rudy Leiva
 * @author Bradley Taniguchi
 * 5/1/17
 * CSC 295
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Problem 1");
        
        /*Test the Ball class*/
        System.out.println("Created Ball class..");
        Ball myBall = new Ball(1, 1, 1, 1, 45);
        System.out.println("Before Move:");
        System.out.println(myBall);
        myBall.move();
        System.out.println("After Move: ");
        System.out.println(myBall);
        
        /*now test container class*/
        System.out.println("\n\n Now Testing Container +Box");
        Ball ball = new Ball(50, 50, 5, 10, 30);
        System.out.println(ball);
        Container box = new Container(0,0, 100, 100);
        System.out.println(box);
        
        for(int i = 0; i < 100; ++i) {
            ball.move();
            box.collidesWith(ball);
            System.out.println(ball);
        }
        
    }
}
