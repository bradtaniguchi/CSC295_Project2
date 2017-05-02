package problem2;

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
    
    public SpecialNumbers() {
        this.nonPrimeNum = (int) (Math.random() * 9999) + 1; //i thinks this is right..
        this.primeNum = (int) (Math.random() * 9999) + 1;
        this.perfectNum = weightedRandom();
    }
    /**
     * For Debugging constructor
     */
    public SpecialNumbers(int nonPrimeNum, int primeNum, int perfectNum) {
        this.nonPrimeNum = nonPrimeNum;
        this.primeNum = primeNum;
        this.perfectNum = perfectNum;
    }
    /**
     * TODO: Finish creating a weighted random..
     * @return 
     */
    private int weightedRandom() {
        
        return 1;
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
