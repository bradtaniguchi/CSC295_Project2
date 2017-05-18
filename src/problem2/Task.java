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
    private LinkedBlockingQueue<SpecialNumbers> results;
    private SpecialNumbers[] numbers;
    private int start;
    private int end;

    public Task(int start, int end, SpecialNumbers[] numbers, LinkedBlockingQueue<SpecialNumbers> results) {
        this.results = results;
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    /**
     * Calculates the given array locations given by start and end.
     */
    public void calculate() {
        for (int i = start; i < end; i++) {
            SpecialNumbers number = numbers[i];
            // check if nonPrimeNum is not prime
            if (isPrime(number.getNonPrimeNum())) {
                continue;
            }
            // check if primeNum is a primeNumber
            if (!isPrime(number.getPrimeNum())) {
                continue;
            }
            // check if perfectNum is a perfectNumber
            if (!isPerfect(number.getPerfectNum())) {
                continue;
            }
            // add the number to the results queue, we will check the varience
            // later when all the results come in.
            this.results.add(number); 
        }
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
    
//    /**
//     * 
//     * @param n
//     * @return the varience of
//     * 
//     */
//    private double getVarience(int n) {
//        
//    }
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
