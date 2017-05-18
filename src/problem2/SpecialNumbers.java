package problem2;

import java.util.Random;
/**
 *
 * @author Rudy Leiva
 * @author Bradley Taniguchi
 * 5/1/17
 * CSC 295
 */
public class SpecialNumbers {
    private int nonPrimeNum;
    private int primeNum;
    private int perfectNum;
    private final Random random = new Random();

    public SpecialNumbers() {
        this.nonPrimeNum = random.nextInt(10000) + 1; //i thinks this is right..
        this.primeNum = random.nextInt(10000) + 1;
        this.perfectNum = weightedRandom();
    }
    public SpecialNumbers(int nonPrimeNum, int primeNum, int perfectNum) {
        this.nonPrimeNum = nonPrimeNum;
        this.primeNum = primeNum;
        this.perfectNum = perfectNum;
    }
    /**
     * @note I hope all these random generators are correct!
     * THEY AREN'T!
     */
    private int weightedRandom() {
        /*get a number between 1 and 10 for temp*/
        int temp = random.nextInt(10) + 1; 
        int num; //this will be the value we return
        if(temp <= 3) {
            num = random.nextInt(50) + 1;
            return num;
        } else if (temp <= 8) {
            num = random.nextInt(400) + 51;
            return num;
        } else if (temp <= 10 ) {
            num = random.nextInt(50) + 451;
            return num;
        } else { //do this incase the random generation is wrong
            System.out.println("ERROR in Weighted Random! " + temp);
            num = -1;
        }
        return num;
        
        /*
        nstructor, initialize nonPrimeNum and primeNum to two random numbers
        within [1, 10000], and the probablities for primeNum to be a random number within the range [1, 50], [50, 450] and
        [451, 500] are 30%, 50%, and 20%, respectively.
        */
    }
    /*getters and setters*/
    public int getNonPrimeNum() {
        return nonPrimeNum;
    }

    public void setNonPrimeNum(int nonPrimeNum) {
        this.nonPrimeNum = nonPrimeNum;
    }

    public int getPrimeNum() {
        return primeNum;
    }

    public void setPrimeNum(int primeNum) {
        this.primeNum = primeNum;
    }

    public int getPerfectNum() {
        return perfectNum;
    }

    public void setPerfectNum(int perfectNum) {
        this.perfectNum = perfectNum;
    }
    
}
