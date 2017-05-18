package problem2;

import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author Rudy Leiva
 * @author Bradley Taniguchi
 * 5/1/17
 * CSC 295
 */
public class Task {
    private LinkedBlockingQueue<Boolean> results;
    private int start;
    private int end;

    public Task(int start, int end, LinkedBlockingQueue<Boolean> results) {
        this.results = results;
        this.start = start;
        this.end = end;
    }
    
    /**
     * Function that calculates if the given number matches the specifications.
     * If the given matches the specifications, we will push a a true result
     * into the results Queue. If it doesn't we append a false value into the
     * queue. 
     */
    public void calculate() {
        // test the value here...
    }
    /**
     * checks whether an integer is prime or not.
     * @param n the number to check
     * @return if the number is prime or not.
     */
    private boolean isPrime(int n)
    {
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }

    /**
     * checks whether an integer is perfect or not.
     * @param n the number to check
     * @return  if the number is perfect or not.
     */
    private boolean isPerfect(int n)
    {
        int sum = 0;

        for(int i = 1; i < n; i++)
        {
            if(n % i == 0)
            {
                sum += i;
            }
        }
        return sum == n;
    }
}
